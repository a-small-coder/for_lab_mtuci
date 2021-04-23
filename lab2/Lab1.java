package lab2;
public class Lab1 {
    
    private static Point3d[] points = new Point3d[3];
    public static void main(String[] args){
        Point3d testPoint = new Point3d(1, 1, 1);
        for (int i=0; i < args.length; i+=3){
            double x = convertStingToDouble(args[i]);
            double y = convertStingToDouble(args[i+1]);
            double z = convertStingToDouble(args[i+2]);
            points[i/3] = new Point3d(x, y, z);
        }

        if (isTriangleExistance(points[1], points[2], points[0]))
            System.out.println("Треугольник не существует!");
        else{
            double s = computeArea(points[1], points[2], points[0]);
            s = Math.round(s*100)/100D;
            System.out.println(s);
        }
    }
    public static double convertStingToDouble(String s){
        double x = 0.0;
        try {
            x = Double.parseDouble(s); 
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
        return x;
    }
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        double a = p1.distanceTo(p2);
        double b = p1.distanceTo(p3);
        double c = p2.distanceTo(p3);
        double p = (a + b + c) / 2.0;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
    public static boolean isTriangleExistance(Point3d p1, Point3d p2, Point3d p3){
        if (p1.isTwoPointsEqual(p2) || p1.isTwoPointsEqual(p3) || p2.isTwoPointsEqual(p3)){
            return true;
        }
        else{
            return false;
        }
        
    }
    
}//java Lab1.java 0 0 0 0 1 0 1 0 0
