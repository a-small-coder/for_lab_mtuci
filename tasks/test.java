package tasks;
import java.util.Arrays;
import java.util.Optional;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test {
    public static void main(String[] args) {
        System.out.println(nicoChipher("mubashirhassan", "crazy"));
        // String[] arr;
        // arr = collect("intercontinentalisationalism", 6);
        // Arrays.sort(arr);
        // String ans = "";
        // for (String word:arr){
        //     ans += "\"" + word + "\", ";
        // }
        // ans = ans.substring(0, ans.length() - 2);
        // System.out.println("[" + ans + "]");

        // arr = collect("strengths", 19);
        // Arrays.sort(arr);
        // ans = "";
        // for (String word:arr){
        //     ans += "\"" + word + "\", ";
        // }
        // ans = ans.substring(0, ans.length() - 2);
        // System.out.println("[" + ans + "]");
        
        // arr = collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15);
        // Arrays.sort(arr);
        // ans = "";
        // for (String word:arr){
        //     ans += "\"" + word + "\", ";
        // }
        // ans = ans.substring(0, ans.length() - 2);
        // System.out.println("[" + ans + "]");

        // System.out.println("ationa, interc, ntalis, ontine");
        // System.out.println("eng, str, ths");
        // System.out.println("croscopicsilico, pneumonoultrami, volcanoconiosis");

        
    }

    // public static String[] collect(String str, int n){
    //     String[] arr;
    //     if (str.length() < n){
    //         arr = new String[1];
    //     }
    //     else{
    //         arr = new String[str.length() / n];
    //         arr[0] = str.substring(0, n);
    //         String[] otherArr = collect(str.substring(n), n);
    //         for (int i=1; i< arr.length; i++){
    //             if (otherArr.length > i-1)
    //                 arr[i] = otherArr[i-1];
    //         }
    //     }
    //     return arr;
    // }

    public static String nicoChipher(String message, String key){
        key = key.toLowerCase();
        int[] keyArr = new int[key.length()];

        String [] keyStrArr = new String[key.length()];
        for (int i=0; i < key.length(); i++){
            keyStrArr[i] = key.substring(i, i+1);
        }
        Arrays.sort(keyStrArr); // amtt from matt - 1234 to 2134
        String keyStr = "";
        for (int i=0; i < keyStrArr.length; i++){
            keyStr += keyStrArr[i];
        }
        for (int i=0; i < key.length(); i++){
            keyArr[i] +=  keyStr.indexOf(key.substring(i, i+1)) ; 
        }

        Map<Integer, String> encodeMessage = new HashMap<Integer, String>();
        int steps = 0;
        if ( message.length() % key.length() == 0){
            steps = message.length() / key.length();
        }
        else{
            steps= message.length() / key.length() + 1;
        }
        steps *= key.length();
            
        for (int i=0; i <steps; i++){
            String letter = " ";
            if (i < message.length()){
                letter = message.substring(i, i+1); 
            }
            int index = i % keyArr.length;
            if (encodeMessage.get(index) != null)
                encodeMessage.put(index, encodeMessage.get(index) + letter);
            else
            encodeMessage.put(index, letter);
        }
        String ans = "";
        for (int i=0; i < keyArr.length; i++){
            ans += encodeMessage.get(i);
        }
        return ans;
    }
}