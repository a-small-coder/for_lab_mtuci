package lab8;

import java.util.Date;
import java.util.LinkedList;

public class Crawler {
    

    public static void main(String[] args) {
        if (args.length == 3) {
            String firstUrl = args[0];
            // int maxDepth = 2;
            // int numThreads = 10;
            int maxDepth;
            int numThreads;
            try {
                maxDepth = Integer.parseInt(args[1]);

            } catch (Exception e) {
                System.out.println("usage: java Crawler <URL> <depth> <threads>");
                return;
            }

            if (maxDepth <= 0 || maxDepth > 10) {
                System.out.println("Depth must be from 1 to 10");
                return;
            }

            try {
                numThreads = Integer.parseInt(args[1]);

            } catch (Exception e) {
                System.out.println("usage: java Crawler <URL> <depth> <threads>");
                return;
            }

            if (numThreads <= 0 || numThreads > 100) {
                System.out.println("Depth must be from 1 to 100");
                return;
            }
            if (maxDepth < 3){
                numThreads = 10;
            }

            URLPool mainPool = new URLPool(maxDepth);
            LinkedList <Thread> allThreads = new LinkedList<Thread>();;
            URLDepthPair urlDepthPair = new URLDepthPair(firstUrl, 0);
            mainPool.put(urlDepthPair);
            mainPool.putInSeenList(firstUrl);
            
            int initialActive = Thread.activeCount();
            int dopTime = 0;
            Date currentDate = new Date();
            long startTime = currentDate.getTime() / 1000;
            while(mainPool.getWaitThreads() != numThreads && dopTime < 300) {
                int threadCount = Thread.activeCount();
                if (threadCount - initialActive < numThreads) {
                        dopTime = 0;
                        CrawlerThread crawler = new CrawlerThread(mainPool);
                        allThreads.add(crawler);
                        crawler.start();
                }
                else {
                    try {
                        Thread.sleep(100);  // 0.1 second
                        dopTime++;
                    }
                    catch (InterruptedException ie) {
                        System.out.println("Caught unexpected " +"InterruptedException, ignoring...");
                    }
    
                }

            } 
            mainPool.writeAllIndexed();
            for(Thread thread: allThreads){
                try{
                    thread.interrupt();
                }
                catch(Exception e){
                    System.out.println("Caught unexpected " + "InterruptedException, ignoring...");
                }
            }
            Date otherDate = new Date();
            long endTime = otherDate.getTime() / 1000;
            String timer = Long.toString(endTime - startTime);
            System.out.println("Work time = " + timer + " seconds");

        } else {
            System.out.println("usage: java Crawler <URL> <depth> <threads>");
        }

    }

}

