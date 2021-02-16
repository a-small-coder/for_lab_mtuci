package java_mtuci.lab2;

public class Point3d {
    /* координата X */
    private double xCoord;
    /* координата Y */
    private double yCoord;
    /* координата z */
    private double zCoord;
    /** Конструктор инициализации **/
    public Point3d ( double x, double y, double z) {
    xCoord = x;
    yCoord = y;
    zCoord = z;
    }
    /** Конструктор по умолчанию. **/
    public Point3d () {
    //Вызовите конструктор с двумя параметрами и определите источник.
    this(0.0, 0.0, 0.0);
    }
    /** Возвращение координаты X **/
    public double getX () {
    return xCoord;
    }
    /** Возвращение координаты Y **/
    public double getY () {
    return yCoord;
    }
    /** Возвращение координаты Z **/
    public double getZ () {
        return zCoord;
        }
    /** Установка значения координаты X. **/
    public void setX ( double val) {
    xCoord = val;
    }
    /** Установка значения координаты Y. **/
    public void setY ( double val) {
    yCoord = val;
    }
    /** Установка значения координаты Y. **/
    public void setZ ( double val) {
        zCoord = val;
        }
    // являются ли 2 точки одинаковыми
    public static boolean isTwoPointsEqual(Point3d point1, Point3d point2){
        if (point1.getX() == point2.getX() && point1.getY() == point2.getY() && point1.getZ() == point2.getZ())
            return true;
        else
            return false;
    }
    // определение расстояния между точками
    public double distanceTo(Point3d point){
        if (!isTwoPointsEqual(point, this)){
            double sqrDifX = Math.pow(xCoord - point.getX(), 2.0);
            double sqrDifY = Math.pow(yCoord - point.getY(), 2.0);
            double sqrDifZ = Math.pow(zCoord - point.getZ(), 2.0);
            double distance = Math.sqrt(sqrDifX + sqrDifY + sqrDifZ);
            return distance;
        }
        else
            return 0.0;
    }
}
