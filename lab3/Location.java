package lab3;
/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Location guest = (Location) obj;
        return xCoord == guest.xCoord && yCoord == guest.yCoord;
    }

    @Override
    public int hashCode(){
        final int prime = 37;
        int result= 17;

        result = prime * result + (int)xCoord;
        result = prime * result + (int)yCoord;
        return result;
    }
}