package java_mtuci.lab7;
import java.util.*;
import java.net.*;

public class Crawler {
    public static final String URL_PROTOCOL = "https://";
    public static final String URL_PREFIX = "href=\"";
    public static final String END_URL = "\"";
    public static void main(String[] args){
        
        if (args.length > -1){
            String firstUrl = "https://www.nytimes.com/";
            int maxDepth = 2;
            try{
                //maxDepth = Integer.parseInt(args[1]);
                
            }
            catch(Exception e){
                writeMessage("usage: java Crawler <URL> <depth>");
                return;
            }

            if (maxDepth <= 0 ){
                writeMessage("Depth must be > 0");
                return;
            }

            LinkedList <URLDepthPair> indexingSites = new LinkedList <URLDepthPair>();
            LinkedList <URLDepthPair> remainingSites = new LinkedList <URLDepthPair>();
            LinkedList <String> urls = new LinkedList <String>();

            URLDepthPair urlDepthPair = new URLDepthPair(firstUrl, 0);
            remainingSites.add(urlDepthPair);
            urls.add(firstUrl);
            //int iter = 0;
            while (remainingSites.size() != 0){
                URLDepthPair currentPair = remainingSites.pop();
                remainingSites.remove(currentPair);
                if (indexingSites.contains(currentPair)){
                    continue;
                }
                if (currentPair.getParseDeep() == maxDepth){
                    continue;
                }

                try {
                    URLConnection connection = new URL(currentPair.getUrl()).openConnection();
                    indexingSites.add(currentPair);
                    writeMessage("now, the " + currentPair.toString() +" was indexed It's number is: " + indexingSites.indexOf(currentPair));
                    // Socket socket = new Socket();
                    // socket.connect(new InetSocketAddress(currentPair.getUrl(), 80));
                    Scanner scanner = new Scanner(connection.getInputStream());
                    scanner.useDelimiter("\\Z");
                    String line = scanner.next();
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
                        line.replaceFirst(newLink, "");
                        if (urls.contains(newLink)){
                            continue;
                        }
                        urls.add(newLink);
                        URLDepthPair newURLDepthPair = new URLDepthPair(newLink, currentPair.getParseDeep() + 1);
                        remainingSites.add(newURLDepthPair);
                        
                    }
                    
                }
                catch(Exception e){
                    System.out.println(e);
                }

                //iter++;
            }

            for (int i=0; i < indexingSites.size(); i++){
                writeMessage(indexingSites.get(i).getUrl());
            }
            writeMessage("All indexed ursl: " + Integer.toString(indexingSites.size()));

        }
        else {
            writeMessage("usage: java Crawler <URL> <depth>");
        }

    }
    
    public static void writeMessage(String str){
        System.out.println(str);
    }

    public static LinkedList getSites(LinkedList list){
        return list;
    }

    public static void research(){
        
    }
}
