public class ThreadsExample {
    
    public static void main(String[] args){
        // threads from Thread
        for (int i=0; i<10;i++){
            SomeThreadClass someThread = new SomeThreadClass(i);
            someThread.start();
        }
        System.out.println("Start threads from Runnable");
        // threads from Runnable
        for (int i=0; i<10;i++){
            IImplemetsRunnable someRunnableClass = new IImplemetsRunnable(i);
            Thread someThread = new Thread(someRunnableClass);
            someThread.start();
        }
    }
}
