import java.util.*;
public class ThirdBlock {
    public static void main(String[] args){
        
        Object[][] l = {{"Nice", 942208},{"Abu Dhabi", 1482816},{"Naples", 2186853},{"Vatican City", 572}};
        System.out.println(millionsRouting(l));
        Object[][] l1 = {{"Manila", 13923452},{"Kuala Lumpur", 7996830},{"Jakarta", 10770487}};
        System.out.println(millionsRouting(l1));

        System.out.println(otherSides(1));
        System.out.println(otherSides(12));
        System.out.println(otherSides(2));
        System.out.println(otherSides(3));

        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        int[] a1 = {2, 8, 7, 5};
        System.out.println(warOfNumbers(a1));
        int[] a2 = {12, 90, 75};
        System.out.println(warOfNumbers(a2));
        int[] a3 = {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        System.out.println(warOfNumbers(a3));

        System.out.println(reverseCase("Happy Birthday"));
        System.out.println(reverseCase("MANY THANKS"));
        System.out.println(reverseCase("sPoNtAnEoUs"));

        System.out.println(inatorInator("Shrink"));
        System.out.println(inatorInator("Doom"));
        System.out.println(inatorInator("EvilClone"));

        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));

        System.out.println(totalDistance(70.0, 7.0, 0, false));
        System.out.println(totalDistance(36.1, 8.6, 3, true));
        System.out.println(totalDistance(55.5, 5.5, 5, false));

        int[] b1 = {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3};
        System.out.println(mean(b1));
        int[] b2 = {2, 3, 2, 3};
        System.out.println(mean(b2));
        int[] b3 = {3, 3, 3, 3, 3};
        System.out.println(mean(b3));

        System.out.println(parityAnalis(243));
        System.out.println(parityAnalis(12));
        System.out.println(parityAnalis(3));


    }
    public static Object[][] millionsRouting(Object[][] list){
        for (int i=0; i < list.length; i++){
            list[i][1] = ((int)list[i][1] + 500000) / 1000000 * 1000000;        
        }
        return Arrays.deepToString(list);
    }

    public static Double[] otherSides(int a){
        Double[] sides = new Double[] {a*2.0, a*Math.sqrt(3)};
        return sides;
    }

    public static String rps(String player1, String player2){
        String ans;
        final String R1 = "Player 1 wins";
        final String R2 = "Player 2 wins";
        final String R3 = "TIE";
        final String C1 = "rock";
        final String C2 = "paper";
        final String C3 = "scissors";
        final String OTHER = "Write a correct command";
        switch (player1) {
            case C1:
                if (player2.equals(C1))
                   ans = R3;
                else if (player2.equals(C2))
                    ans = R2;
                else if (player2.equals(C3))
                    ans =R1;
                else 
                    ans = OTHER;
                break;
            
            case C2:
                if (player2.equals(C1))
                    ans = R1;
                else if (player2.equals(C2))
                    ans = R3;
                else if (player2.equals(C3))
                    ans = R2;
                else 
                    ans = OTHER;
                break;

            case C3:
                if (player2.equals(C1))
                    ans = R2;
                else if (player2.equals(C2))
                    ans = R1;
                else if (player2.equals(C3))
                    ans = R3;
                else 
                    ans = OTHER;
                break;

            default:
                ans = OTHER;
                break;
        }
        return ans;
    }
    
    public static int warOfNumbers(int[] arr){
        int chetSum = 0;
        int nechetSum = 0;
        for (int i: arr){
            if (i % 2 == 0){
                chetSum += i;
            }
            else 
                nechetSum += i;
        }
        return Math.abs(nechetSum - chetSum);
    }

    public static String reverseCase(String s){
        String newS = "";
        for (int i=0; i < s.length(); i++){
            String substr = s.substring(i, i);
            if (substr.toLowerCase().equals(substr)) {
                newS += substr.toUpperCase(); 
            }
            else {
             newS += substr;
            }
        }
        return newS;
    }
    public static String inatorInator(String s){
        String[] vowels = new String[] {"q","w","r","t","p","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
        for (String vowel: vowels){
            if (s.substring(s.length()-1, s.length()).equals(vowel)){
                return s+="inator " + Integer.toString(s.length()) + "000";
            }
        }
        return s+="-inator " + Integer.toString(s.length()) + "000"; 
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        int[] arr = {a, b, c};
        int[] arr2 = {w, h};
        Arrays.sort(arr);
        Arrays.sort(arr2);
        if (arr[0] <= arr2[0] && arr[1] <= arr2[1]){
            return true;
        }
        else {
            return false;
        } 
            
    }

    public static double totalDistance(double fuel, double exp, int pas, boolean flag){
        if (flag)
            return fuel / ((exp*(100 + pas*5/100) + 1) * 0.1);
        else 
            return fuel / (exp*(100 + pas*5/100));
        
    }

    public static double mean(int[] arr){
        return Arrays.stream(arr).sum() / (double)arr.length;
    }

    public static boolean parityAnalis(int a){
        int sumNumbers = 0;
        int b = a;
        while (b > 0){
            sumNumbers += b % 10;
            b /= 10;
        }
        if (a % 2 == sumNumbers % 2)
            return true;
        else
            return false;
    }
}
