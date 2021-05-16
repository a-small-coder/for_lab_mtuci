public class SomeThreadClass extends Thread {
    private int threadName;
    public int getThreadName(){
        return this.threadName;
    }
    public SomeThreadClass(int num){
        this.threadName = num;
    }
    public SomeThreadClass(){
        this.threadName = -1;
    }

    @Override
    public void run(){
        System.out.println("I'm Thread number: " + this.threadName);
    }
}
