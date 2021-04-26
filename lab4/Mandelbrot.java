import java.awt.geom.*;
public class Mandelbrot extends FractalGenerator {

    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange (Rectangle2D.Double rectangle){
        
       rectangle.setFrame(-2, -1.5, 3, 3);
    }

    public int numIterations(double x, double y){
        double realZ = 0.0;
        double imageZ = 0.0;
        int i = 0;
        while (realZ*realZ + imageZ*imageZ < 4 && i < MAX_ITERATIONS){
            double newRealZ = realZ * realZ - imageZ*imageZ + x;
            double newImageZ = 2 * realZ * imageZ + y;
            realZ = newRealZ;
            imageZ = newImageZ;
            i++;
            
        }
        if (i == MAX_ITERATIONS){
            return -1;
        }
        else
            return i;
    }

    public String toString(){
        return "Mandelbrot";
    }
}
