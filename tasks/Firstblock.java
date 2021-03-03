public class Firstblock {
    public int convert(int min){
        return min*60;
    }
    public int points(int doublePoints, int triplePoints){
        return doublePoints*2 + triplePoints*3;
    }
    public int footballPoints(int wins, int draws, int lose){
        return wins*3 + draws;
    }
    public boolean divisibleByFive(int num){
        return num % 5 == 0;
    }
    public boolean and(boolean a, boolean b){
        return a&&b;
    }

    public int howManyWalls(int n, int w, int h){
        return n / (w*h);
    }

    public boolean profitableGamble(double prob, double prize, double pay){
        return prob * prize > pay;
    }

    public static int squaed(int a) {
    
        return a * a;
        
        }

    public int frames(int fps, int mins){
        return fps*mins*60;
    }

    public int mod(int a, int b){
        return a - (a / b * b);
    }
}