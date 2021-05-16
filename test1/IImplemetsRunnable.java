public class IImplemetsRunnable implements Runnable{
    private int threadName;

    public IImplemetsRunnable(int num){
        this.threadName = num;
    }
    public IImplemetsRunnable(){
        this.threadName = -1;
    }
    @Override
    public void run(){
        System.out.println("I'm runnabe number: " + this.threadName);
    }
}
