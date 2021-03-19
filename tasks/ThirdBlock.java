
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ThirdBlock {
    // public static void main(String[] args){
    //     Map<String, Integer> map = new HashMap();
    //     map.put("Nice", 942208);
    //     map.put("Abu Dhabi", 1482816);
    //     map.put("Naples", 2186853);
    //     map.put("Vatican City", 572);
    //     List list = new LinkedList<Map>();
    //     list.add(map);
    //     List<Array<String>> l = [["Nice", "942208"],["Abu Dhabi", "1482816"],["Naples", "2186853"],["Vatican City", "572"]];
    //     millionsRouting([["Nice", "942208"],["Abu Dhabi", "1482816"],["Naples", "2186853"],["Vatican City", "572"]]);
    // }
    // public static void millionsRouting(List<List<String>> list){
    //     for (Map m: list){
    //         for (Object key: m.keySet()){
    //             int n = ((int)m.get(key) + 500000) / 1000000 * 1000000;
    //             m.replace(key, n);
            
    //         }
    //     }
    //     System.out.println(list);
    // }

    public Double[] otherSides(int a){
        Double[] sides = new Double[] {a*2.0, a*Math.sqrt(3)};
        return sides;
    }

    public String rps(String player1, String player2){
        String ans;
        switch (player1) {
            case "rock":
                if (player2.equals("rock"))
                   ans = "TIE";
                else if (player2.equals("paper"))
                    ans = "Player 2 wins";
                else if (player2.equals("scissors"))
                    ans = "Player 1 wins";
                else 
                    ans = "Write a correct command";
                break;
            
            case "paper":
                if (player2.equals("rock"))
                    ans = "Player 1 wins";
                else if (player2.equals("paper"))
                    ans = "TIE";
                else if (player2.equals("scissors"))
                    ans = "Player 2 wins";
                else 
                    ans = "Write a correct command";
                break;

            case "scissors":
                if (player2.equals("rock"))
                    ans = "Player 2 wins";
                else if (player2.equals("paper"))
                    ans = "Player 1 wins";
                else if (player2.equals("scissors"))
                    ans = "TIE";
                else 
                    ans = "Write a correct command";
                break;

            default:
                ans = "Write a correct command";
                break;
        }
        return ans;
    }
    
    public int warOfNumbers(int[] arr){
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

    public String reverseCase(String s){
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
    public String inatorInator(String s){
        String[] vowels = new String[] {"q","w","r","t","p","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
        for (String vowel: vowels){
            if (s.substring(s.length()-1, s.length()).equals(vowel)){
                return s+="inator " + Integer.toString(s.length()) + "000";
            }
        }
        return s+="-inator " + Integer.toString(s.length()) + "000"; 
    }

    public boolean doesBrickFit(int a, int b, int c, int w, int h){
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

    public double totalDistance(double fuel, double exp, int pas, boolean flag){
        if (flag)
            return fuel / ((exp*(100 + pas*5/100) + 1) * 0.1);
        else 
            return fuel / (exp*(100 + pas*5/100));
        
    }

    public double mean(int[] arr){
        return Arrays.stream(arr).sum() / (double)arr.length;
    }

    public boolean parityAnalis(int a){
        int sumNumbers;
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
