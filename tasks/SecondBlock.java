import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.ldap.SortKey;

public class SecondBlock {
    public int opossitehouse(int house, int n){
        return n*2 - house + 1;
    }

    public String nameShuffle(String s){
        return s.split(" ")[1] + " " + s.split(" ")[0];
    }

    public double discount(int price, int persent){
        return price - (double)(price * (persent / 100));
    }

    public int differenceMaxMin(int[] arr){
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
    
    public int equal(int a, int b, int c){
        int count = 0;
        if (a == b)
            count++;
        if (b == c)
            count++;
        if (a == c)
            count++;
        return count;
    }

    public static String reverseString(String s){
        String rev_s = "";
        for (int i=s.length()-1; i>=0 ; i--){
            rev_s += s.charAt(i);
        }
        return rev_s;
    }

    public int programmers(int a, int b, int c){
        return Math.max (Math.max(a, b), c) - Math.min (Math.min(a, b), c);
    }

    public boolean getXO(String s){
        s.toLowerCase();
        int oCount = s.split("o").length - 1;
        int xCount = s.split("x").length - 1;
        return oCount == xCount;
    }

    public String bomb(String s){
        s.toLowerCase();
        int bombCount = s.split("bomb").length - 1;
        return (bombCount > 0) ? "DUCK!" : "Relax, there's no bomb.";
    }

    public boolean getASCII(String s1, String s2){
        return s1.chars().sum() == s2.chars().sum();
    }
}
