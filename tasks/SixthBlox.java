
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixthBlox {
    public static String hiddenAnagram(String str, String anagram){
        String noFound = "noutfond";
        String alphavit = "qwertyuiopasdfghjklzxcvbnm";
        String clStr = "";
        String clAnagram = "";
        str = str.toLowerCase();
        anagram = anagram.toLowerCase();
        int maxLen = Math.max(str.length(), anagram.length());
        for (int i=0; i < maxLen; i++){
            if (str.length() > i)
                if (alphavit.contains(str.substring(i, i+1)))
                    clStr += str.substring(i, i+1);

            if (anagram.length() > i)
                if (alphavit.contains(anagram.substring(i, i+1)))
                    clAnagram += anagram.substring(i, i+1);
        }

        for (int startPosition = 0; startPosition < clStr.length(); startPosition++){
            if (!clAnagram.contains(clStr.substring(startPosition, startPosition+1))){
                continue;
            }
            String anagramCopy = clAnagram;
            int letterIndex = startPosition;
            String ans = "";

            while (letterIndex < clStr.length()){
                String letter = clStr.substring(letterIndex, letterIndex + 1);
                if (anagramCopy.contains(letter)){
                    ans += letter;
                    anagramCopy = anagramCopy.replaceFirst(letter, "");
                }
                else{
                    break;
                }
                if (anagramCopy.length() == 0){
                    return ans;
                }
                letterIndex++;
            }
        }
        return noFound;
    }

    public static String[] collect(String str, int n){
        String[] arr;
        if (str.length() < n){
            arr = new String[1];
        }
        else{
            arr = new String[str.length() / n];
            arr[0] = str.substring(0, n);
            String[] otherArr = collect(str.substring(n), n);
            for (int i=1; i< arr.length; i++){
                if (otherArr.length > i-1)
                    arr[i] = otherArr[i-1];
            }
        }
        return arr;
    }

    public static String nicoChipher(String message, String key){
        key = key.toLowerCase();
        String alphavit = "abcdefghijklmnopqrstuvwxyz";
        int[] keyArr = new int[key.length()];

        String [] keyStrArr = new String[key.length()];
        Arrays.sort(keyStrArr); // amtt from matt - 1234 to 2134
        String keyStr = keyStrArr.toString();
        for (int i=0; i < key.length(); i++){
            keyArr[i] +=  keyStr.indexOf(key.substring(i, i+1)) ; 
        }

        Map<Integer, String> encodeMessage = new HashMap<Integer, String>();
        int steps = 0;
        if ( message.length() % key.length() != 0){
            steps = message.length() / key.length();
        }
        else{
            steps= message.length() / key.length() + key.length();
        }
            
        for (int i=0; i <steps; i++){
            String letter = " ";
            if (i < message.length()){
                letter = message.substring(i, i+1); 
            }
            encodeMessage.put(i % keyArr.length, letter);
        }
        String ans = "";
        for (int i=0; i < keyArr.length; i++){
            ans += encodeMessage.get(i);
        }
        return ans;
    }

    public static 
}
