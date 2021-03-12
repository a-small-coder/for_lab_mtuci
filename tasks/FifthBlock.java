package java_mtuci.tasks;

public class FifthBlock {
    
    public boolean sameLetterPattern(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        int count1 = 0;
        String allChar1 ="";
        int count2 = 0;
        String allChar2 ="";
        String patternS1 = "";
        String patternS2 = "";
        s1.toLowerCase();
        s2.toLowerCase();
        for (int i=0; i < s1.length(); i++){
            String c1 = Character.toString(s1.charAt(i));
            try {
                Integer.parseInt(c1);
            }
            catch (Exception e){
                if (!allChar1.contains(c1)){
                    count1++;
                    allChar1 += c1;
                    patternS1+= Integer.toString(count1) + ".";
                    s1.replaceAll(c1, Integer.toString(count1));
                }
            }

            String c2 = Character.toString(s2.charAt(i));
            try {
                Integer.parseInt(c2);
            }
            catch (Exception e){
                if (!allChar2.contains(c2)){
                    count2++;
                    allChar2 += c2;
                    patternS2+= Integer.toString(count2) + ".";
                    s2.replaceAll(c2, Integer.toString(count2));
                }
            }
        }
        if (patternS1.equals(patternS2)){
            return true;
        }
        else{
            return false;
        }
    }

    public static String spiderVsFly(String startP, String endP){
        int L = 8;
        int sCircle = (int)startP.charAt(1) - 48;
        int eCircle = (int)endP.charAt(1) - 48;
        int startLineCode = (int)startP.charAt(0)- 64; // буквы A - H имеют коды 65-73 в колировке ASCII
        int endLineCode = (int)endP.charAt(0) - 64; // поэтому получим номер начальной и конечной линиии, отняв 64
        int distanceLines = Math.abs(startLineCode - endLineCode);
        int d = (distanceLines + 2 * (distanceLines / (L - 1))) % (L/2);
        String pass = "";
        int mod;
        if (d == 0){
            pass = startP;
            if (pass.equals("A0")){
                startLineCode = endLineCode;
            }
            while (startLineCode != endLineCode || sCircle != eCircle){ 
                if (startLineCode != endLineCode){
                    mod = -1;
                }
                else {
                    mod = 1;
                }
                sCircle += mod;
                if (sCircle == 0){
                startLineCode = 1;
                }
                String addPass = (char)(startLineCode+64) + Integer.toString(sCircle);
                pass += "-" + addPass;
                if (addPass.equals("A0")){
                    startLineCode = endLineCode;
                }
            }
        }
        else if (d <=L/4){
            boolean isNeedSwap;
            if (startLineCode + 4 < endLineCode){
                isNeedSwap = true;
                int temp = endLineCode;
                endLineCode = startLineCode;
                startLineCode = temp;
                temp = sCircle;
                sCircle = eCircle;
                eCircle = temp;
            }
            else 
                isNeedSwap = false;

            pass = (char)(startLineCode + 64) + Integer.toString(sCircle);
            while (startLineCode != endLineCode || sCircle != eCircle){ 
                if (sCircle > eCircle){
                    sCircle--;
                }
                else if (sCircle == eCircle){
                    if (startLineCode == L){
                        startLineCode = 1;
                    }
                    else{
                        startLineCode++;
                    }
                }
                String addPass = (char)(startLineCode + 64) + Integer.toString(sCircle);
                pass += "-" + addPass;

            }
            if (isNeedSwap){
                String[] passSplited = pass.split("-");
                pass = passSplited[passSplited.length-1];
                for (int i=passSplited.length-2; i>=0 ; i--){
                    pass += "-" + passSplited[i];
                }
            }
        }
        else if (d >L/4){
            pass += spiderVsFly(startP, "A0");
            pass += spiderVsFly("A0", endP).substring(2);
        }
        return pass;
    }

    public static int digitsCount(Object num){
        int count = 0;
        if (num instanceof Integer){
            int number = (int) num;
            do {
                count++;
                number /= 10;
            } while (number > 0);
        }
        else if (num instanceof Long){
            long number = (long) num;
            do {
                count++;
                number /= 10;
            } while (number > 0);
        }
        else{
            System.out.println("This is not a integer type");
        }
        
        return count;
    }

    public static int totalPoints(String[] words, String rightWord){
        int score = 0;
        for (String word: words){
            boolean isRightWord = true;
            String wordForTest = rightWord;
            for (int i=0; i < word.length(); i++){
                String chr = Character.toString(word.charAt(i));
                if (wordForTest.contains(chr)){
                    wordForTest.replace(chr, "");
                } 
                else{
                    isRightWord = false;
                    break;
                }
            }
            if (isRightWord){
                score += word.length() - 2;
                if (word.length() == 6){
                    score += 50;
                }
            }
        }

        return score;
    }

    public static int longestRun(int[] arr){
        int count = 1;
        int maxCount = 0;
        for (int i=1; i < arr.length; i++){
            if (Math.abs(arr[i-1] - arr[i]) == 1){
                count++;
            }
            else{
                if (count > maxCount){
                    maxCount = count;
                }
                count = 1;
            }
        }
        if (count > maxCount){
            maxCount = count;
        }
        return maxCount;
    }
}
