package java_mtuci.lab1;

public class Palindroms {
    public static void main(String[] args ) {
        for (int i = 0; i < args.length; i++) {
        String s = args[i];
        String rev_s = reverseString(s);
        if (isPalindrome(s, rev_s))
            System.out.println(s + " is a palindrome");
        else
            System.out.println(s + " is not a palindrome");
       } 
    }
    public static String reverseString(String Strings){
        String rev_s = "";
        for (int i=Strings.length(); i>=0 ; i--){
            rev_s += Strings.charAt(i);
        }
        return rev_s;
    }
    public static Boolean isPalindrome(String s1, String s2){
        if (s1.equals(s2))
        return true;
        else
        return false;
    }
}
