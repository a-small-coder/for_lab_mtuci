package tasks;
import java.util.*;


public class FourthBlock {

    public static void main(String[] args){
        int[] a1 = {1, 2, 3, 4, 5, 6, 7};
        int[] a2 = {8, 6, 33, 100};
        int[] a3 = {2, 55, 60, 97, 86};
        System.out.println(sevenBoom(a1));
        System.out.println(sevenBoom(a2));
        System.out.println(sevenBoom(a3));
        
        int[] b1 = {5, 1, 4, 3, 2}; 
        int[] b3 = {5, 1, 4, 3, 2, 8}; 
        int[] b4 = {5, 6, 7, 8, 9, 9}; 
        System.out.println(cons(b1));
        System.out.println(cons(b3));
        System.out.println(cons(b4));

        System.out.println(unmix("123456"));
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println(unmix("badce"));

        System.out.println(noYelling("What went wrong?????????"));
        System.out.println(noYelling("Oh my goodness!!!"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println(noYelling("Oh my goodness!"));
        System.out.println(noYelling("I just cannot believe it."));
        
        System.out.println(xPronounce("Inside the box was a xylophone"));
        System.out.println(xPronounce("The x ray is excellent"));
        System.out.println(xPronounce("OMG x box unboxing video x D"));

        int[] c1 = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}; 
        int[] c2 = {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}; 
        int[] c3 = {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9}; 
        System.out.println(largestGap(c1));
        System.out.println(largestGap(c2));
        System.out.println(largestGap(c3));

        System.out.println(someFunc(832));
        System.out.println(someFunc(51));
        System.out.println(someFunc(7977));
        System.out.println(someFunc(1));
        System.out.println(someFunc(665));
        System.out.println(someFunc(149));

        System.out.println(commonLastVovel("Hello World!"));
        System.out.println(commonLastVovel("Watch the characters dance!"));
        System.out.println(commonLastVovel("OOI UUI EEI AAI"));

        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));

        System.out.println(unrepeated("teshahset"));
        System.out.println(unrepeated("hello"));
        System.out.println(unrepeated("aaaaa"));
        System.out.println(unrepeated("WWE!!!"));
        System.out.println(unrepeated("call 911"));
    }
    
    public static String sevenBoom(int[] arr){
        for (int i=0; i < arr.length; i++){
            if (Integer.toString(arr[i]).contains("7"))
                return "Boom!";
        }
        return "there is no 7 in the array";
    }

    public static boolean cons(int[] arr){
        Arrays.sort(arr);
        for (int i=0; i<arr.length; i++){
            if (i+1 != arr[i])
                return false;
        }
        return true;
    }

    public static String unmix(String str){
        int len = str.length() - (str.length() % 2);
        String newStr = "";
        for (int i=0; i <len; i+=2){
            newStr += Character.toString(str.charAt(i+1)) + Character.toString(str.charAt(i));
        }
        return newStr;
    }

    public static String noYelling(String str){
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

    public static String xPronounce(String str){
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
            str = str.replaceFirst(sep, " ");
        }
        newString += str.substring(lastI, str.length());
        return newString;
    }

    public static int largestGap(int[] arr){
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

    public static int someFunc(int a){
        String str_a = Integer.toString(a);
        String reverse_str_a = "";
        for (int i=str_a.length(); i > 0; i-=1){
            reverse_str_a += str_a.substring(i-1, i);
        }
        int reverse_a = Integer.parseInt(reverse_str_a);
        return (a - reverse_a) > 0 ? a - reverse_a : 0;
    }

    public static String commonLastVovel(String str){
        Map<String, Integer> vovelsMap = new HashMap<String, Integer>();
        String vovels = "aeiouy";
        str = str.toLowerCase();
        String[] strSplited = str.split(" ");
        for (String word: strSplited){
            char last = word.charAt(word.length() - 1);
            while (word.length() > 0 && (last < 97 || last > 122)){
                last = word.charAt(word.length() - 1);
                word = word.substring(0, word.length()-1);
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

    public static int memeSum(int a, int b) throws NumberFormatException {
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

    public static String unrepeated(String str){
        Map<String, Integer> vovelsMap = new HashMap<String, Integer>();
        for (int i=0; i < str.length(); i++){
            String symbol = str.substring(i, i+1);
            if (vovelsMap.containsKey(symbol)){
                vovelsMap.replace(symbol, vovelsMap.get(symbol), vovelsMap.get(symbol) + 1);
            }
            else{
                vovelsMap.put(symbol, 1);
            }

        }
        for (String vovel: vovelsMap.keySet()){
            int vovelCount = vovelsMap.get(vovel);
            if (vovelCount > 1){
                int firstI = str.indexOf(vovel);
                str = str.substring(0, firstI + 1) + str.substring(firstI, str.length()).replaceAll(vovel, "");
            }
        }
        return str;
    }
}
