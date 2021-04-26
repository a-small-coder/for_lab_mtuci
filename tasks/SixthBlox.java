import java.util.*;

public class SixthBlox {

    public static void main(String[] args){
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));       
        
        System.out.println(nicoChipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoChipher("andiloveherso", "tesha"));
        System.out.println(nicoChipher("mubashirhassan", "crazy"));
        System.out.println(nicoChipher("edabitisamazing", "matt"));
        System.out.println(nicoChipher("iloveher", "612345"));
        
        int[] a1 = {1, 2, 3, 9, 4, 5, 15, 3};
        int[] a2 = {1, 2, 3, 9, 4, 15, 3, 5};
        int[] a3 = {1,  2, -1,  4,  5,  6,  10, 7};
        int[] a4 = {1, 2, 3, 4, 5,  6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(twoProduct(a1, 45)));
        System.out.println(Arrays.toString(twoProduct(a2, 45)));
        System.out.println(Arrays.toString(twoProduct(a3, 20)));
        System.out.println(Arrays.toString(twoProduct(a4, 10)));
        
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        
        System.out.println(generateNonconsecutive(1));
        System.out.println(generateNonconsecutive(2));
        System.out.println(generateNonconsecutive(3));
        System.out.println(generateNonconsecutive(4));
        
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        
        int[] b1 = {1, 2, 3, 4, 5};
        int[] b2 = {1, 2, 3, 7, 9};
        int[] b3 = {10, 9, 7, 2, 8};
        int[] b4 = {1, 6, 5, 4, 8, 2, 3, 7};
        List<int[]> s1 = sumUp(b1);
        String ans = "[";
        for(int[] el: s1){
            ans += Arrays.toString(el) + " ";
        }
        ans += "]";
        System.out.println(ans);
        List<int[]> s2 = sumUp(b2);
        ans = "[";
        for(int[] el: s2){
            ans += Arrays.toString(el) + " ";
        }
        ans += "]";
        System.out.println(ans);
        List<int[]> s3 = sumUp(b3);
        ans = "[";
        for(int[] el: s3){
            ans += Arrays.toString(el) + " ";
        }
        ans += "]";
        System.out.println(ans);
        List<int[]> s4 = sumUp(b4);
        ans = "[";
        for(int[] el: s4){
            ans += Arrays.toString(el) + " ";
        }
        ans += "]";
        System.out.println(ans);
    }

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
            String s = key.substring(i, i+1);
            int ind = keyStr.indexOf(key.substring(i, i+1));
            keyStr = keyStr.replaceFirst(s, " ");
            keyArr[ind] = i; 
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
        steps /=  key.length();
        for (int j=0; j < steps; j++){
            for (int i=0; i < keyArr.length; i++){
                String symbol = encodeMessage.get(keyArr[i]);
                ans += symbol.substring(j, j+1);
            }
        }
        
        return ans;
    }

    public static int[] twoProduct(int[] arr, int val) {
		int first=0, second=0;
		int[] answer = new int[2];
		for(int i=arr.length-1;i>0;--i) {
			second=arr[i];
			for(int j=i-1;j>=0;--j) {
				first=arr[j];
				if(first*second==val) {
					answer[0]=first;
					answer[1]=second;
				}
			}
		}
		return answer;
	}

    public static int[] isExact(int val) {
		int[] answer = new int[0];
		int number = isFact(val,2);
		if(number!=-1)
		{
			answer=new int[] {val,number};
		}
		return answer;
	}
	public static int isFact(int number, int k) {
		if(number==1) {
			return k-1;
		}
		if(number%k!=0)
			return -1;
		return isFact(number/k,k+1);
	}

    public static String fractions(String number){
        int dotIndex = number.indexOf(".");
        int bracketIndex = number.indexOf("(");
        int wholePart = Integer.parseInt(number.substring(0, dotIndex));
        String unrepeatPart = number.substring(dotIndex + 1, bracketIndex);
        String repeatPart = number.substring(bracketIndex + 1, number.length() - 1); 
        int firstBit = 0;
        if (unrepeatPart.length() > 0){
            firstBit = Integer.parseInt(unrepeatPart);
        } 

        int chisl = Integer.parseInt(unrepeatPart+repeatPart) - firstBit;
        String znam_str = "";
        for (int i=0; i < repeatPart.length(); i++){
            znam_str += "9";
        }
        for (int i=0; i < unrepeatPart.length(); i++){
            znam_str += "0";
        }
        int znam = Integer.parseInt(znam_str);
        int k = 2;
		int t = Math.max(chisl, znam);
		while (k < t) {
			if (chisl % k == 0 && znam % k == 0) {
				chisl /= k;
				znam /= k;
			}
            else{
                k++;
            }
			    
		}
        return Integer.toString(wholePart*znam + chisl) + "/" + Integer.toString(znam);
    }

    public static String pilish_string(String s){
        String  Pi = "314159265358979";
        String ans = "";
        if (s.length() == 0){
            return ans;
        }
        int currentIndex = 0;
        for(int i=0; i<Pi.length(); i++){
            int bitSize = Integer.parseInt(Pi.substring(i, i+1));
            int sLostLen = s.substring(currentIndex, s.length()).length();
            if (sLostLen == 0){
                break;
            }
            if (sLostLen < bitSize){
                String repeat = s.substring(s.length()-1);
                String dop = repeat;
                ans += s.substring(currentIndex, s.length());
                for (int j=1; j < bitSize - sLostLen ; j++ ){
                    dop += repeat;
                }
                ans += dop;
                break;
            }
            else{
                ans += s.substring(currentIndex, currentIndex + bitSize) + " ";
            }
            currentIndex += bitSize;
        }
        return ans;
    }

    public static String generateNonconsecutive(int n) {		
		return recurse(n,false,"");
	}
	public static String recurse(int n, boolean isOne,String s) {
		if(n == 1) {
			if(isOne){
                return s + "0 ";
            }
			else{
                return s + "0" + " " + s + "1 ";
            }
		}
		if(isOne) {
			return recurse(n - 1, false, s + "0");
		}
        else {
			return recurse(n - 1, false, s + "0") + recurse(n - 1, true, s + "1");
		}	
	}

    public static String isValid(String s){
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i=0; i< s.length(); i++){
            String sym = s.substring(i, i+1);
            if (dictionary.keySet().contains(sym)){
                int old = dictionary.get(sym);
                dictionary.replace(sym, old, old+1);
            }
            else{
                dictionary.put(sym, 1);
            }
        }
        int count = 0;
        int sum = 0;
        int mis = 0;
        String ans = "YES";
        for (int value: dictionary.values()){
            if (count != 0 && Math.abs(sum / count - value) > 1 ){
                ans = "NO";
                    break;
            }
            sum+= value;
            count++;
            if ( (double) sum/ count != sum / count){
                mis++;
                sum -= value;
                count--;
                if (mis > 1){
                    ans = "NO";
                    break;
                }
            }
        }
        return ans;
    }

    public static List<int[]> sumUp(int[] arr){
        List<int[]> newA = new ArrayList<int[]>();
        for (int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==8) {
                    int[] pair = {Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
					newA.add(pair);
                }         
			}
		}
        return newA;
    }

}
