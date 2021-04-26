import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        showTypes();
        readConsole();
    }
    public static String readConsole(){
        Scanner str = new Scanner(System.in);
        String first_str = str.nextLine();
        System.out.println("You input: " + first_str);
        str.close();
        return first_str;
    }
    public static void showTypes(){
        System.out.println("Byte - it's a similar number type");
        byte num_in_byte = 15;
        System.out.println(num_in_byte);
        System.out.println("Int - it's a most popular number type");
        int num_in_integer = 15000;
        System.out.println(num_in_integer);
        System.out.println("Long - it's a large number type");
        long num_in_long = 15000000;
        System.out.println(num_in_long);
        System.out.println("Double - it's a number with dot type");
        double num_in_double = 15000000.123123;
        System.out.println(num_in_double);
        System.out.println("Char - it's a symbol type");
        char sym = 'A';
        System.out.println(sym);
        System.out.println("Bollean - it's a logic type");
        boolean is_true = true;
        System.out.println(is_true);

    }
}
