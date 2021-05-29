import java.util.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
// https://www.nytimes.com
// https://apache.org/
// http://htmlbook.ru/
public class Crawler7 {
    public static final String URL_PROTOCOL = "http://";
    public static final String URL_PREFIX = "href=\"";
    public static final String END_URL = "\"";
    Date currentDate;
    

    public static void main(String[] args) throws IOException {

        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите ссылку:");
        String firstUrl = scaner.nextLine();
        System.out.println("глубину поиска от 1 до 1000");
        int maxDepth = 0;
        try {
            maxDepth = Integer.parseInt(scaner.nextLine());
            scaner.close();

        } catch (Exception e) {
            scaner.close();
            writeMessage("Невверное значение глубины поиска");
            return;
        }
        if (maxDepth <= 0) {
            writeMessage("Depth must be > 0");
            return;
        }

        LinkedList<URLDepthPair7> indexingSites = new LinkedList<URLDepthPair7>();
        LinkedList<URLDepthPair7> remainingSites = new LinkedList<URLDepthPair7>();
        LinkedList<String> urls = new LinkedList<String>();
        String sUrl = URL_PROTOCOL + firstUrl;

        URLDepthPair7 pairF = new URLDepthPair7(sUrl, 0);
        Socket socket = new Socket();
        try{
            socket.close();
            socket = new Socket(firstUrl, 80);
            socket.setSoTimeout(2000);
            PrintWriter myWriter = new PrintWriter(socket.getOutputStream(), true);
            myWriter.println("GET " + pairF.getUrl() + " HTTP/1.1");
            myWriter.println("Host: " + pairF.getWebHost());
            myWriter.println();
        }
        catch (Exception e){
        }
        Crawler7 c = new Crawler7();
        long startTime = c.startTimer(firstUrl);
        URLDepthPair7 urlDepthPair = new URLDepthPair7(firstUrl, 0);
        urls.add(firstUrl);
        remainingSites.add(urlDepthPair);
        while (remainingSites.size() != 0) {
            URLDepthPair7 currentPair = remainingSites.pop();
            remainingSites.remove(currentPair);
            if (indexingSites.contains(currentPair)) {
                continue;
            }
            if (currentPair.getParseDeep() == maxDepth) {
                continue;
            }

            indexingSites.add(currentPair);
            writeMessage("now, the " + currentPair.toString() + " was indexed It's number is: "
                    + indexingSites.indexOf(currentPair) + "/" 
                    + Integer.toString(indexingSites.size() + remainingSites.size()));

            LinkedList<URLDepthPair7> newURLDepthPairs = research(currentPair, urls);
            if (!(newURLDepthPairs == null)) {
                for (int i = 0; i < newURLDepthPairs.size(); i++) {
                    URLDepthPair7 pair = newURLDepthPairs.get(i);
                    if (!remainingSites.contains(pair))
                        remainingSites.add(pair);
                }
            }
        }
                
        socket.close();
        for (int i = 0; i < indexingSites.size(); i++) {
            writeMessage(indexingSites.get(i).getUrl());
        }
        writeMessage("All indexed ursl: " + Integer.toString(indexingSites.size()));
        Date otherDate = new Date();
        long endTime = otherDate.getTime() / 1000;
        String timer = Long.toString(endTime - startTime);
        System.out.println("Work time = " + timer + " seconds");
        
    }

    public static void writeMessage(String str) {
        System.out.println(str);
    }

    public static LinkedList<URLDepthPair7> research(URLDepthPair7 currentPair, LinkedList<String> urls) {
        LinkedList<URLDepthPair7> newURLDepthPairs = new LinkedList<URLDepthPair7>();
        URLConnection connection;
        try {
            connection = new URL(currentPair.getUrl()).openConnection();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return newURLDepthPairs;
        }
        Scanner scanner;
        try {
            scanner = new Scanner(connection.getInputStream());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            return newURLDepthPairs;
        }
        
            scanner.useDelimiter("\\Z");
            String line = "";
            if (scanner.hasNext()){
                line = scanner.next();
            }
            scanner.close();
            int startIndex = 0;
            int endIndex = 0;
            while (true){
                startIndex = line.indexOf(URL_PREFIX, endIndex);
                endIndex = line.indexOf(END_URL, startIndex + URL_PREFIX.length());
                if (startIndex == -1 || endIndex == -1){
                    break;
                }
                if (endIndex - startIndex > 200){
                    String temp = line.substring(startIndex, startIndex+URL_PREFIX.length());
                    line.replaceFirst(temp, "");
                    continue;
                }
                String newLink = line.substring(startIndex + 6, endIndex);
                if (!newLink.contains(URL_PROTOCOL)){
                    continue;
                }
                boolean isBadLink = false;
                for (Object urlEnd: WRONG_URL_ENDS){
                    if (newLink.substring(newLink.length() - 4, newLink.length()).equals(urlEnd)){
                        isBadLink = true;
                        break;
                    }
                    
                }
                if (isBadLink){
                    continue;
                }
                if (urls.contains(newLink)){
                    continue;
                }
                urls.add(newLink);
                URLDepthPair7 newURLDepthPair = new URLDepthPair7(newLink, currentPair.getParseDeep() + 1);
                newURLDepthPairs.add(newURLDepthPair);
            }
            return newURLDepthPairs;
            
        
    }

    public long startTimer(String firstUrl){
        currentDate = new Date();
        long startTime = currentDate.getTime() / 1000;
        return startTime;
    }
    public static final String[] WRONG_URL_ENDS = {".apk", ".ogv"};
}