public class book extends SomeClass{
        public static void main(String[] args){
            book a = new book();
            a.someMethod();

    }
    public book(){

    }
    @Override
    public void someMethod(){
        int a = 2;
        System.out.println(a);
    }
}
