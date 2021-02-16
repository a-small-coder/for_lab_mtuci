public class Point3d extends Point2d {
    /* координата X */
    private double xCoord;
    /* координата Y */
    private double yCoord;
    /* координата z */
    private double zCoord;
    /** Конструктор инициализации **/
    public Point3d ( double x, double y, double z) {
    super(x, y);
    zCoord = z;
    }
    /** Конструктор по умолчанию. **/
    public Point3d () {
    //Вызовите конструктор с 3 параметрами и определите источник.
    this(0.0, 0.0, 0.0);
    }
    /** Возвращение координаты Z **/
    public double getZ () {
        return zCoord;
        }
    /** Установка значения координаты Y. **/
    public void setZ ( double val) {
        zCoord = val;
        }
    // являются ли 2 точки одинаковыми
    public  boolean isTwoPointsEqual(Point3d point2){
        if (this.getX() == point2.getX() && this.getY() == point2.getY() && this.getZ() == point2.getZ())
            return true;
        else
            return false;
    }
    // определение расстояния между точками
    public double distanceTo(Point3d point){
        if (!this.isTwoPointsEqual(point)){
            double sqrDifX = Math.pow(this.getX() - point.getX(), 2.0);
            double sqrDifY = Math.pow(this.getY() - point.getY(), 2.0);
            double sqrDifZ = Math.pow(this.getZ() - point.getZ(), 2.0);
            double distance = Math.sqrt(sqrDifX + sqrDifY + sqrDifZ);
            distance = Math.round(distance*100)/100D;
            return distance;
        }
        else
            return 0.0;
    }
}
