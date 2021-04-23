package tasks;
public class Firstblock {
    public static void main(String[] args){
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(2));

        System.out.println(points(13, 12));
        System.out.println(points(17, 12));
        System.out.println(points(38, 8));

        System.out.println(footballPoints(3, 4, 2));
        System.out.println(footballPoints(5, 0, 2));
        System.out.println(footballPoints(0, 0, 1));

        System.out.println(divisibleByFive(5));
        System.out.println(divisibleByFive(-55));
        System.out.println(divisibleByFive(37));

        System.out.println(and(true, false));
        System.out.println(and(true, true));
        System.out.println(and(false, true));
        System.out.println(and(false, false));

        System.out.println(howManyWalls(54, 1, 43));
        System.out.println(howManyWalls(46, 5, 4));
        System.out.println(howManyWalls(100, 4, 5));
        System.out.println(howManyWalls(10, 15, 12));
        System.out.println(howManyWalls(41, 3, 6));

        System.out.println(squaed(5));
        System.out.println(squaed(9));
        System.out.println(squaed(100));

        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(profitableGamble(0.9, 3, 2));

        System.out.println(frames(1, 1));
        System.out.println(frames(10, 1));
        System.out.println(frames(10, 25));

        System.out.println(mod(5, 2));
        System.out.println(mod(218, 5));
        System.out.println(mod(6, 3));
    }
    public static int convert(int min){
        return min*60;
    }
    public static int points(int doublePoints, int triplePoints){
        return doublePoints*2 + triplePoints*3;
    }
    public static int footballPoints(int wins, int draws, int lose){
        return wins*3 + draws;
    }
    public static boolean divisibleByFive(int num){
        return num % 5 == 0;
    }
    public static boolean and(boolean a, boolean b){
        return a&&b;
    }

    public static int howManyWalls(int n, int w, int h){
        return n / (w*h);
    }

    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob * prize > pay;
    }

    public static int squaed(int a) {
    
        return a * a;
        
        }

    public static int frames(int fps, int mins){
        return fps*mins*60;
    }

    public static int mod(int a, int b){
        return a - (a / b * b);
    }
}