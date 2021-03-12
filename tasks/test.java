package java_mtuci.tasks;


public class test {
    public static void main(String[] args) {
        int[] arr =  {3, 5, 7, 10, 15};
        System.out.println(longestRun(arr));

//         totalPoints(["cat", "create", "sat"], "caster") ➞ 2
// // Since "create" is an invalid word.

// totalPoints(["trance", "recant"], "recant") ➞ 108
// // Since "trance" and "recant" score 54 pts each.

// totalPoints(["dote", "dotes", "toes", "set", "dot", "dots", "sted"], "tossed") ➞ 13


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