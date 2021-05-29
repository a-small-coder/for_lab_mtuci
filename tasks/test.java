import java.util.Arrays;
import java.util.*;


public class test {
    public static void main(String[] args) {
        // System.out.println(spiderVsFly("A4", "F2"));
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        String s = "B4";
        LinkedList<String> ans = new LinkedList<String>();
        ans.add(spiderVsFly(s, "B4"));
        ans.add(spiderVsFly(s, "C4"));
        ans.add(spiderVsFly(s, "D4"));
        ans.add(spiderVsFly(s, "E4"));
        ans.add(spiderVsFly(s, "F4"));
        ans.add(spiderVsFly(s, "G4"));
        ans.add(spiderVsFly(s, "H4"));
        ans.add(spiderVsFly(s, "A4"));
        ans.add(spiderVsFly("H3", "E2"));
        ans.add(spiderVsFly("A4", "B2"));
        ans.add(spiderVsFly("A4", "C2"));
        ans.add(spiderVsFly("A4", "F2"));
        for (String i : ans){
            System.out.println(i);
        }
    }

    public static String spiderVsFly(String startP, String endP){

        int L = 8;
        int sCircle = (int)startP.charAt(1) - 48;
        int eCircle = (int)endP.charAt(1) - 48;
        int startLineCode = (int)startP.charAt(0)- 64; // буквы A - H имеют коды 65-73 в колировке ASCII
        int endLineCode = (int)endP.charAt(0) - 64; // поэтому получим номер начальной и конечной линиии, отняв 64
        int distanceLines = Math.abs(startLineCode - endLineCode);
        int[] D = {0, 1, 2, 3, 0, 3, 2, 1}; // удаленность линий A-H друг от друга
        int d = D[distanceLines]; 
        if (eCircle == 0 || sCircle == 0){
            d = 0;
        }
        String pass = "";
        int mod;
        if (d == 0){ // точки находятся на одной линии
            pass = startP;
            if (pass.equals("A0")){
                startLineCode = endLineCode;
            }
            while (startLineCode != endLineCode || sCircle != eCircle){ 
                if (startLineCode != endLineCode || (startLineCode == 1 && endP.equals("A0"))){
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
            if (startLineCode + 4 < endLineCode || startLineCode > endLineCode){
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
        

   
}