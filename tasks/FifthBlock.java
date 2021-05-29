
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FifthBlock {

    public static void main(String[] args){
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        String[] a1 = {"cat", "create", "sat"};
        String[] a2 = {"trance", "recant"};
        String[] a3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(a1,"caster"));
        System.out.println(totalPoints(a2, "recant"));
        System.out.println(totalPoints(a3, "tossed"));

        int[] q1 = {1, 2, 3, 5, 6, 7, 8, 9};
        int[] q2 = {3, 2, 1, 2};
        int[] q3 = {5, 4, 2, 1};
        int[] q4 = {3, 5, 7, 10, 15};
        System.out.println(longestRun(q1));
        System.out.println(longestRun(q2));
        System.out.println(longestRun(q3));
        System.out.println(longestRun(q4));

        String[] s1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] s2 = {"10%"};
        String[] s3 = {"53%", "79%"};
        System.out.println(takeDownAverage(s1));
        System.out.println(takeDownAverage(s2));
        System.out.println(takeDownAverage(s3));

        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(rearrange("the4 t3o man5 Happ1iest of6 no7 birt2hday steel8!"));
        System.out.println(rearrange("is2 Thi1s T4est 3a"));
        System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println(rearrange(""));

        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(12002));
        System.out.println(isNew(10022));
    }

    // проверка схожести шаблонов строк
    public static boolean sameLetterPattern(String s1, String s2){
        int count1 = 0;
        int count2 = 0;
        String allChar1 ="";
        String allChar2 ="";
        String patternS1 = "";
        String patternS2 = "";
        for (int i=0; i < s1.length(); i++){
            if (!patternS1.equals(patternS2)){
                break;
            }
            String c1 = Character.toString(s1.charAt(i));
            if (allChar1.contains(c1)){
                int index = allChar1.indexOf(c1) + 1;
                patternS1+= Integer.toString(index) + ".";
            }
            else{
                count1++;
                allChar1 += c1;
                patternS1+= Integer.toString(count1) + ".";
                
            }

            String c2 = Character.toString(s2.charAt(i));
            if (allChar2.contains(c2)){
                int index = allChar2.indexOf(c2) + 1;
                patternS2+= Integer.toString(index) + ".";
            }
            else{
                count2++;
                allChar2 += c2;
                patternS2+= Integer.toString(count2) + ".";
                
            }
        }
        return patternS1.equals(patternS2);
    }

    // паук
    public static String spiderVsFly(String startP, String endP){

        int L = 8;
        int sCircle = (int)startP.charAt(1) - 48;
        int eCircle = (int)endP.charAt(1) - 48;
        int startLineCode = (int)startP.charAt(0)- 64; // буквы A - H имеют коды 65-73 в колировке ASCII
        int endLineCode = (int)endP.charAt(0) - 64; // поэтому получим номер начальной и конечной линиии, отняв 64
        int distanceLines = Math.abs(startLineCode - endLineCode);
        int[] D = {0, 1, 2, 3, 0, 3, 2, 1}; // удаленность линий A-H друг от друга
        int d = D[distanceLines]; 
        String pass = "";
        int mod;
        if (d == 0){ // точки находятся на одной линии
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
        else if (d <= 2){ 
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
        else if (d > 2){
            pass += spiderVsFly(startP, "A0");
            pass += spiderVsFly("A0", endP).substring(2);
        }
        return pass;
    }
    // количество цифр в числе
    public static int digitsCount(long x){
        return x > 9 ? digitsCount(x/10) + 1: 1;
        }

    // подсчет очков за угаданные слова
    public static int totalPoints(String[] words, String rightWord){
        int score = 0;
        for (String word: words){
            boolean isRightWord = true;
            String wordForTest = rightWord;
            for (int i=0; i < word.length(); i++){
                String chr = Character.toString(word.charAt(i));
                if (wordForTest.contains(chr)){
                    wordForTest = wordForTest.replace(chr, "");
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
    // поиск количества последовательных чисел
    public static int longestRun(int[] arr){
        int count = 1;
        int maxCount = 0;
        if (arr.length > 1){
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
        }
        if (count > maxCount){
            maxCount = count;
        }
        return maxCount;
    }
    // средний процент
    public static String takeDownAverage(String arr[]){
        if (arr.length == 0)
            return null;
        double sum = 0.0;
        double downRate = 0.05;
        for (int i = 0; i< arr.length; i++){
            double rate = Double.parseDouble(arr[i].substring(0, arr[i].length() - 1))  / 100.0; // "x%" to (x / 100)
            sum += rate;
        }
        double x = (sum / arr.length - downRate) * (arr.length + 1) - sum;
        x *= 100;
        String ans = Integer.toString((int) x) + "%";
        return ans;
    }

    // перестановка слов согласно цифрам в них
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
    // масимальное число из цифр двух исходных чисел
    public static int maxPossible(int firstNum, int secondNum){
        // чтение первого числа в массив
        String firstNumStr = Integer.toString(firstNum);
        int[] firstNumbers = new int[firstNumStr.length()];
        for (int i=0; i <firstNumStr.length(); i++){
            firstNumbers[i] = Integer.parseInt(firstNumStr.substring(i, i+1));
        }
        // чтение второго числа в массив
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
    // перевод часов
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
        
        // расчет добавочного времени
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
        int diffHours = timeBHours - timeAHours;
        int diffmins = timeBMins - timeAMins;
        // чтение даты из строки
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
        timeB.add(Calendar.HOUR, diffHours);
        timeB.add(Calendar.MINUTE, diffmins);
        SimpleDateFormat formatDateOut = new SimpleDateFormat("yyyy-M-d HH:mm"); 
        String ans = formatDateOut.format(timeB.getTime());
        return ans;
    }
    // является ли число наименьшим возможным для данного набора цифр
    public static boolean isNew(int num){
        String numStr = Integer.toString(num);
        int[] numbers = new int[numStr.length()];
        for (int i=0; i <numStr.length(); i++){
            numbers[i] = Integer.parseInt(numStr.substring(i, i+1));
        }

        Arrays.sort(numbers);
        // поиск индекса наименьшей цифры (> 0)
        int indexFirstNumNotZero = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] > 0){
                indexFirstNumNotZero = i;
                break;
            }
        }
        // собираем число из массива как: наименьшая цифра (> 0) + нули, если есть, + остальные цифры по возрастанию
        String numberS = Integer.toString(numbers[indexFirstNumNotZero]);
        for (int i = 0; i < numbers.length; i++){
            if (i != indexFirstNumNotZero){
                numberS += Integer.toString(numbers[i]);
            }
        }
        return numStr.equals(numberS);
    }
}
