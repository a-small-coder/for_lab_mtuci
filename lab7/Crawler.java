import java.util.*;
import java.io.IOException;
import java.net.*;

public class Crawler {
    public static final String URL_PROTOCOL = "https://";
    public static final String URL_PREFIX = "href=\"";
    public static final String END_URL = "\"";
    public static final String[] WRONG_URL_ENDS = {".apk", ".ogv"};

    public static void main(String[] args) {

        if (args.length > -1) {
            String firstUrl = "https://ru.wikipedia.org/";
            int maxDepth = 2;
            try {
                // maxDepth = Integer.parseInt(args[1]);

            } catch (Exception e) {
                writeMessage("usage: java Crawler <URL> <depth>");
                return;
            }

            if (maxDepth <= 0) {
                writeMessage("Depth must be > 0");
                return;
            }

            LinkedList<URLDepthPair> indexingSites = new LinkedList<URLDepthPair>();
            LinkedList<URLDepthPair> remainingSites = new LinkedList<URLDepthPair>();
            LinkedList<String> urls = new LinkedList<String>();

            URLDepthPair urlDepthPair = new URLDepthPair(firstUrl, 0);
            remainingSites.add(urlDepthPair);
            urls.add(firstUrl);

            Date currentDate = new Date();
            long startTime = currentDate.getTime() / 1000;
            while (remainingSites.size() != 0) {
                URLDepthPair currentPair = remainingSites.pop();
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

                LinkedList<URLDepthPair> newURLDepthPairs = research(currentPair, urls);
                if (!(newURLDepthPairs == null)) {
                    for (int i = 0; i < newURLDepthPairs.size(); i++) {
                        URLDepthPair pair = newURLDepthPairs.get(i);
                        if (!remainingSites.contains(pair))
                            remainingSites.add(pair);
                    }
                }
            }

            for (int i = 0; i < indexingSites.size(); i++) {
                writeMessage(indexingSites.get(i).getUrl());
            }
            writeMessage("All indexed ursl: " + Integer.toString(indexingSites.size()));
            Date otherDate = new Date();
            long endTime = otherDate.getTime() / 1000;
            String timer = Long.toString(endTime - startTime);
            System.out.println("Work time = " + timer + " seconds");

        } else {
            writeMessage("usage: java Crawler <URL> <depth>");
        }

    }

    public static void writeMessage(String str) {
        System.out.println(str);
    }

    public static LinkedList<URLDepthPair> research(URLDepthPair currentPair, LinkedList<String> urls) {
        LinkedList<URLDepthPair> newURLDepthPairs = new LinkedList<URLDepthPair>();
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
            String line = scanner.next();
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
                URLDepthPair newURLDepthPair = new URLDepthPair(newLink, currentPair.getParseDeep() + 1);
                newURLDepthPairs.add(newURLDepthPair);
            }
            return newURLDepthPairs;
            
        
    }
}