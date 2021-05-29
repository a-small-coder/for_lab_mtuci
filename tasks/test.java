import java.util.Arrays;
import java.util.*;


public class test {
    public static void main(String[] args) {
        // System.out.println(spiderVsFly("A4", "F2"));
        String s = "B4";
        spiderVsFly(s, "B4");
        spiderVsFly(s, "C4");
        spiderVsFly(s, "D4");
        spiderVsFly(s, "E4");
        spiderVsFly(s, "F4");
        spiderVsFly(s, "G4");
        spiderVsFly(s, "H4");
        spiderVsFly(s, "A4");
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
        // if (d == 0){
        //     pass = startP;
        //     if (pass.equals("A0")){
        //         startLineCode = endLineCode;
        //     }
        //     while (startLineCode != endLineCode || sCircle != eCircle){ 
        //         if (startLineCode != endLineCode){
        //             mod = -1;
        //         }
        //         else {
        //             mod = 1;
        //         }
        //         sCircle += mod;
        //         if (sCircle == 0){
        //         startLineCode = 1;
        //         }
        //         String addPass = (char)(startLineCode+64) + Integer.toString(sCircle);
        //         pass += "-" + addPass;
        //         if (addPass.equals("A0")){
        //             startLineCode = endLineCode;
        //         }
        //     }
        // }
        // else if (d <=L/4){
        //     boolean isNeedSwap;
        //     if (startLineCode + 4 < endLineCode){
        //         isNeedSwap = true;
        //         int temp = endLineCode;
        //         endLineCode = startLineCode;
        //         startLineCode = temp;
        //         temp = sCircle;
        //         sCircle = eCircle;
        //         eCircle = temp;
        //     }
        //     else 
        //         isNeedSwap = false;

        //     pass = (char)(startLineCode + 64) + Integer.toString(sCircle);
        //     while (startLineCode != endLineCode || sCircle != eCircle){ 
        //         if (sCircle > eCircle){
        //             sCircle--;
        //         }
        //         else if (sCircle == eCircle){
        //             if (startLineCode == L){
        //                 startLineCode = 1;
        //             }
        //             else{
        //                 startLineCode++;
        //             }
        //         }
        //         String addPass = (char)(startLineCode + 64) + Integer.toString(sCircle);
        //         pass += "-" + addPass;

        //     }
        //     if (isNeedSwap){
        //         String[] passSplited = pass.split("-");
        //         pass = passSplited[passSplited.length-1];
        //         for (int i=passSplited.length-2; i>=0 ; i--){
        //             pass += "-" + passSplited[i];
        //         }
        //     }
        // }
        // else if (d >L/4){
        //     pass += spiderVsFly(startP, "A0");
        //     pass += spiderVsFly("A0", endP).substring(2);
        // }
        System.out.println(d);
        return pass;
    }
        

   
}