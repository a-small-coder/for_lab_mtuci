package java_mtuci.tasks;
import java.util.*;

public class FourthBlock {
    
    public String sevenBoom(int[] arr){
        for (int i=0; i < arr.length; i++){
            if (Integer.toString(arr[i]).contains("7"))
                return "Boom!";
        }
        return "there is no 7 in the array";
    }

    public boolean cons(int[] arr){
        Arrays.sort(arr);
        for (int i=0; i<arr.length; i++){
            if (i+1 != arr[i])
                return false;
        }
        return true;
    }

    public String unmix(String str){
        int len = str.length() - (str.length() % 2);
        String newStr = "";
        for (int i=0; i <len; i+=2){
            newStr += str.charAt(i+1) + str.charAt(i);
        }
        return newStr;
    }

    public String noYelling(String str){
        int cutingLength = 0;
        for (int i=str.length()-1; i>=0 ; i--){
            if (str.charAt(i) == '!' || str.charAt(i) == '?')
                cutingLength++;
            else
                break;
        }
        if (cutingLength > 1)
            return str.substring(0, str.length()-cutingLength + 1);
        else 
            return str;
        
    }

    public String xPronounce(String str){
        String newString ="";
        String sep = "x";
        int lastI = 0;
        while (str.contains(sep)){
            int i = str.indexOf(sep);
            if (i - lastI > 0){
                newString+= str.substring(lastI, i);
            }
            lastI = i + 1;
            if (i == 0 || str.charAt(i-1) == ' '){
                if (i == str.length() || str.charAt(i+1) == ' '){
                    newString += "ecks";
                }
                else{
                    newString += "z";
                }
            }
            else
                {
                    newString += "cks";
                }
        }
        return newString;
    }

    public int largestGap(int[] arr){
        Arrays.sort(arr);
        int del = 0;
        int newDel;
        for (int i=1; i < arr.length; i++){
            newDel = arr[i] - arr[i-1];
            if( newDel > del)
                del = newDel;
        }
        return del;
    }

    public String commonLastVovel(String str){
        Map<String, Integer> vovelsMap = new HashMap<String, Integer>();
        String vovels = "aeiouy";
        str.toLowerCase();
        String[] strSplited = str.split(" ");
        for (String word: strSplited){
            char last = word.charAt(word.length() - 1);
            while (word.length() > 0 && (last < 97 || last > 122)){
                last = word.charAt(word.length() - 1);
            }
            String l = Character.toString(last);
            if (vovels.contains(l)){
                if (vovelsMap.containsKey(l)){
                    vovelsMap.replace(l, vovelsMap.get(l), vovelsMap.get(l) + 1);
                }
                else{
                    vovelsMap.put(l, 1);
                }

            }
        }
        int count = 0;
        String ans = "There is no last in word vovel";
        for (String vovel: vovelsMap.keySet()){
            int vovelCount = vovelsMap.get(vovel);
            if (vovelCount > count){
                count = vovelCount;
                ans = vovel;
            }
        }
        return ans;
    }

    public int memeSum(int a, int b) throws NumberFormatException {
        int maxNum = Math.max(a, b);
        int minNum = Math.min(a,b);
        String sum = "";
        while (maxNum > 0){
            int sumInt = maxNum % 10 + minNum % 10;
            sum = Integer.toString(sumInt) + sum;
            maxNum /= 10;
            minNum /= 10;
        }
        int summa = Integer.parseInt(sum);
        return summa;
    }

    public String unrepeated(String str){
        int[] chars = new int[108];
        for (int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            int codeC = (int) c;
            chars[codeC] += 1;
        }
        for (int i=0; i < chars.length; i++){
            if (chars[i] > 1){
                char c = (char) i;
                int index = str.indexOf(c, 0);
                str = str.substring(0, index + 1) + str.substring(index + 1, str.length()).replaceAll(Character.toString(c), "");
            }
        }
        return str;
    }
}
