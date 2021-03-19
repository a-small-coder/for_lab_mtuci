package java_mtuci.tasks;

import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String takeDownAverage(String arr[]){
        double sum = 0.0;
        int count = 0;
        double downRate = 0.05;
        for (int i = 0; i< arr.length; i++){
            double rate = Double.parseDouble(arr[i].substring(0, arr[i].length() - 1))  / 100.0; // "x%" to (x / 100)
            sum += rate;
            count++;
        }
        double x = (sum / count - downRate) * (count + 1) - sum;
        x *= 100;
        String ans = Integer.toString((int) x) + "%";
        return ans;
    }

    public static String rearrange(String wrongStr){
        String[] wrongStrSplited = wrongStr.split(" ");
        String[] resultStrArr = new String[wrongStrSplited.length];
        for (String word: wrongStrSplited){
            if (word.equals("")){
                continue;
            }
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(word);
            String numStr = "";
            while (matcher.find()) {
                int start=matcher.start();
                int end=matcher.end();
                numStr += (word.substring(start, end));
            }
            int position = Integer.parseInt(numStr) ;
            word = word.replaceAll(numStr, "");
            if (position != resultStrArr.length){
                word += " ";
            }
            resultStrArr[position - 1] = word;
            
        }
        String resultStr = "";
        for (String word: resultStrArr){
            resultStr += word;
        }
        return resultStr;
    }

    public static int maxPossible(int firstNum, int secondNum){
        String firstNumStr = Integer.toString(firstNum);
        int[] firstNumbers = new int[firstNumStr.length()];
        for (int i=0; i <firstNumStr.length(); i++){
            firstNumbers[i] = Integer.parseInt(firstNumStr.substring(i, i+1));
        }

        String secondNumStr = Integer.toString(secondNum);
        int[] secondNumbers = new int[secondNumStr.length()];
        for (int i=0; i <secondNumStr.length(); i++){
            secondNumbers[i] = Integer.parseInt(secondNumStr.substring(i, i+1));
        }
        Arrays.sort(secondNumbers);
        String res = "";
        int i = 0;
        int indexOfMaxN = secondNumbers.length - 1;
        while (i < firstNumbers.length){
            if (firstNumbers[i] < secondNumbers[indexOfMaxN]){
                res += Integer.toString(secondNumbers[indexOfMaxN]);
                secondNumbers[indexOfMaxN] = 0;
                Arrays.sort(secondNumbers);
            }              
            else
            res += Integer.toString(firstNumbers[i]);
            i++;
        }
        return Integer.parseInt(res);
    }

    public static String timeDifference(String cityA, String cityATime, String cityB){
        Map<String, String> cities = new HashMap<String, String>();
        cities.put("Los Angeles", "- 08:00");
        cities.put("New York", "- 05:00");
        cities.put("Caracas", "- 04:30");
        cities.put("Buenos Aires", "- 03:00");
        cities.put("London", "+ 00:00");
        cities.put("Rome", "+ 01:00");
        cities.put("Moscow", "+ 03:00");
        cities.put("Tehran", "+ 03:30");
        cities.put("New Delhi", "+ 05:30");
        cities.put("Beijing", "+ 08:00");
        cities.put("Canberra", "+ 10:00");
        
        int modA = 1;
        int modB = 1;
        if (cities.get(cityA).substring(0, 1).equals("-"))
            modA = -1;
        if (cities.get(cityB).substring(0, 1).equals("-"))
            modB = -1;
        int timeAHours = modA * Integer.parseInt(cities.get(cityA).substring(2,4));
        int timeAMins = modA * Integer.parseInt(cities.get(cityA).substring(5,7));
        int timeBHours = modB * Integer.parseInt(cities.get(cityB).substring(2,4));
        int timeBMins = modB * Integer.parseInt(cities.get(cityB).substring(5,7));

        SimpleDateFormat formatDateIn = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        Date date;
        try {
            date = formatDateIn.parse(cityATime);
        }
        catch (ParseException e) {
            return null;
        }

        GregorianCalendar timeB = new GregorianCalendar();
        timeB.setTime(date);
        int diffHours = timeBHours - timeAHours;
        int diffmins = timeBMins - timeAMins;
        timeB.add(Calendar.HOUR, diffHours);
        timeB.add(Calendar.MINUTE, diffmins);
        SimpleDateFormat formatDateOut = new SimpleDateFormat("yyyy-M-d HH:mm");
        String ans = formatDateOut.format(timeB.getTime());
        return ans;
    }

    public static boolean isNew(int num){
        String numStr = Integer.toString(num);
        int[] numbers = new int[numStr.length()];
        for (int i=0; i <numStr.length(); i++){
            numbers[i] = Integer.parseInt(numStr.substring(i, i+1));
        }
        boolean isNew = true;
        for (int j = 0; j< numbers.length; j++){
            if (numbers[j] == 0){
                continue;
            }
            int power = (int)Math.pow(10, numbers.length - 1);
            int newNum = numbers[j] * power;
            for (int k=0; k < numbers.length; k++){
                if (numbers[j] != numbers[k]){
                    power /= 10;
                    newNum += numbers[k] * power;
                }
            }
            if (newNum < num){
                isNew = false;
                break;
            }
        }
        return isNew;
    }
}
