package java_mtuci.lab1;


public class Palindroms {
    /*  основной метод, обрабатывает входные данные - аргументы консоли
        этот метод определяет, является ли входные строки палиндромами 
        пример аргументов консоли:  java Palindrome madam racecar apple kayak song noon
    */
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
    // создает перевернутую строку
    public static String reverseString(String s){
        String rev_s = "";
        for (int i=s.length()-1; i>=0 ; i--){
            rev_s += s.charAt(i);
        }
        return rev_s;
    }
    // проверка равенства строк
    public static Boolean isPalindrome(String s1, String s2){
        if (s1.equals(s2))
        return true;
        else
        return false;
    }
}
