import java.util.ArrayList;
import java.util.Arrays;
import javax.naming.ldap.SortKey;

public class SecondBlock {

    public static void main(String[] args){
        System.out.println(opossitehouse(1, 3));
        System.out.println(opossitehouse(2, 3));
        System.out.println(opossitehouse(3, 5));
        System.out.println(opossitehouse(5, 46));

        System.out.println(nameShuffle("Donald Trump"));
        System.out.println(nameShuffle("Rosie O'Donnell"));
        System.out.println(nameShuffle("Seymour Butts"));

        System.out.println(discount(1500, 50));
        System.out.println(discount(89, 20));
        System.out.println(discount(100, 75));

        int[] a1 = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println(differenceMaxMin(a1));
        int[] a2 = {44, 32, 86, 19};
        System.out.println(differenceMaxMin(a2));

        System.out.println(equal(3, 4, 3));
        System.out.println(equal(1, 1, 1));
        System.out.println(equal(3, 4, 1));

        System.out.println(reverseString("Hello World"));
        System.out.println(reverseString("The quick brown fox."));
        System.out.println(reverseString("Edabit is really helpful!"));

        System.out.println(programmers(147, 33, 526));
        System.out.println(programmers(33, 72, 74));
        System.out.println(programmers(1, 5, 9));
        
        System.out.println(getXO("ooxx"));
        System.out.println(getXO("xooxx"));
        System.out.println(getXO("ooxXm"));
        System.out.println(getXO("zpzpzpp"));
        System.out.println(getXO("zzoo"));
        
        System.out.println(bomb("There is a bomb."));
        System.out.println(bomb("Hey, did you think there is a BOMB?"));
        System.out.println(bomb("This goes boom!!!"));

        System.out.println(getASCII("a", "a"));
        System.out.println(getASCII("AA", "B@"));
        System.out.println(getASCII("EdAbIt", "EDABIT"));
    }
    public static int opossitehouse(int house, int n){
        return n*2 - house + 1;
    }

    public static String nameShuffle(String s){
        return s.split(" ")[1] + " " + s.split(" ")[0];
    }

    public static double discount(int price, int persent){
        return price - (double)(price * (persent / 100.0));
    }

    public static int differenceMaxMin(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i: arr){
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        return max - min;
    }
    
    public static int equal(int a, int b, int c){
        int count = 0;
        if (a == b && a == c)
            count=3;
        else{
            if (a == b)
                count++;
            if (b == c)
                count++;
            if (a == c)
                count++;
        }
        return count;
    }

    public static String reverseString(String s){
        String rev_s = "";
        for (int i=s.length()-1; i>=0 ; i--){
            rev_s += s.charAt(i);
        }
        return rev_s;
    }

    public static int programmers(int a, int b, int c){
        return Math.max (Math.max(a, b), c) - Math.min (Math.min(a, b), c);
    }

    public static boolean getXO(String s){
        s = s.toLowerCase();
        int countX = 0;
        int countO = 0;
        for (int i=0; i < s.length(); i++){
            if (s.substring(i, i+1).equals("x"))
                countX++;
            if (s.substring(i, i+1).equals("o"))
                countO++;
        }
        return countO == countX;
    }

    public static String bomb(String s){
        s = s.toLowerCase();
        int bombCount = s.split("bomb").length - 1;
        return (bombCount > 0) ? "DUCK!" : "Relax, there's no bomb.";
    }

    public static boolean getASCII(String s1, String s2){
        return s1.chars().sum() == s2.chars().sum();
    }
}
