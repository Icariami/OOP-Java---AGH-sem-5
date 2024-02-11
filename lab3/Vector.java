import java.lang.Math;
import java.util.Objects;

/**
 * The vector class is a representation of a 3D math vector
 *
 */
public class Vector{

    /**
     * Constructs a vector and sets its all coordinates to 0.
     */
    public Vector(){
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
    }

    /**
     * Constructs a vector and sets its x-coordinate to the given number, and y and z coordinates to 0.
     * @param x x-coordinate value
     */
    public Vector(double x){
        this.X = x;
        this.Y = 0;
        this.Z = 0;
    }

    /**
     * Constructs a vector and sets the x and y coordinates to the given numbers, and z coordinate to 0.
     * @param x x-coordinate value
     * @param y y-coordinate value
     */
    public Vector(double x, double y){
        this.X = x;
        this.Y = y;
        this.Z = 0;
    }

    /**
     * Constructs a vector and sets the x, y and z coordinates to the given numbers.
     * @param x x-coordinate value
     * @param y y-coordinate value
     * @param z z-coordinate value
     */
    public Vector(double x, double y, double z){
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    /**
     * Copy constructor creates a vector with the other's vector coordinates.
     * @param other the other vector
     */
    public Vector(Vector other){
        this.X = other.X;
        this.Y = other.Y;
        this.Z = other.Z;
    }

    /**
     * Returns a string representation of this Vector, containing all three coordinates.
     * @return a string representation of this Vector
     */
    @Override
    public String toString(){
        return "[" + X + ", " + Y + ", " + Z + "]";
    }

    /**
     * Returns the x-coordinate of this vector
     * @return the x-coordinate of this vector
     */
    public double getX(){
        return this.X;
    }

    /**
     * Returns the y-coordinate of this vector
     * @return the y-coordinate of this vector
     */
    public double getY(){
        return this.Y;
    }

    /**
     * Returns the z-coordinate of this vector
     * @return the z-coordinate of this vector
     */
    public double getZ(){
        return this.Z;
    }

    /**
     * Adds two vectors - this vector and v2 vector.
     * @param v2 vector to be added to this vector.
     * @return sum of vectors.
     */
    public Vector add(Vector v2){
        Vector temp = new Vector(v2);
        temp.X += this.X;
        temp.Y += this.Y;
        temp.Z += this.Z;

        return temp;
    }

    /**
     * Substracts two vectors - v2 from this..
     * @param v2 vector to be substracted from this vector.
     * @return Substracted vector.
     */
    public Vector subtract(Vector v2){
        Vector temp = new Vector(this);
        temp.X -= v2.X;
        temp.Y -= v2.Y;
        temp.Z -= v2.Z;

        return temp;
    }

    /**
     * Multiplies this vector times the given parameter.
     * @param d multiplier.
     * @return the vector multiplied by d parameter.
     */
    public Vector multiply(double d){
        Vector temp = new Vector(this);
        temp.X *= d;
        temp.Y *= d;
        temp.Z *= d;

        return temp;
    }

    /**
     * Returns the Euclidean norm (length) of this vector, computed as the square root of the sum of the squares of its coordinates.
     * @return length of this vector.
     */
    public double length(){
        double len = 0;
        double dot = dotProduct(this, this);
        len = Math.sqrt(dot);
        return len;
    }

    /**
     * Computes the dot product of two vectors.
     * The dot product is calculated as the sum of the products of corresponding coordinates.
     *
     * @param v1 The first vector
     * @param v2 The second vector
     * @return The dot product of the two vectors
     */
    public static double dotProduct(Vector v1, Vector v2){
        double dot = 0;
        dot = dot + v1.X*v2.X + v1.Y*v2.Y + v1.Z*v2.Z;
        return dot;
    }

    /**
     * Computes the cross product of two vectors.
     * The cross product is a vector perpendicular to the plane formed by the two input vectors.
     *
     * @param v1 The first vector
     * @param v2 The second vector
     * @return The cross product vector
     */
    public static Vector crossProduct(Vector v1, Vector v2){
        double x = v1.Y*v2.Z - v1.Z*v2.Y;
        double y = v1.Z*v2.X - v1.X*v2.Z;
        double z = v1.X*v2.Y - v1.Y*v2.X;

        return new Vector(x,y,z);
    }

    /**
     * Constructs a vector from the given coordinates.
     *
     * @param x x-coordinate value
     * @param y y-coordinate value
     * @param z z-coordinate value
     * @return vector created from the given coordinates.
     */
    public static Vector vectorOf(double x, double y, double z){
        return new Vector(x,y,z);
    }

    /**
     * Normalizes the vector, transforming it into a unit vector.
     * A unit vector has a length of 1, while preserving its original direction.
     */
    public void normalize(){
        double len = this.length();
        this.X /= len;
        this.Y /= len;
        this.Z /= len;
    }

    /**
     * Negates the vector, changing the direction of each of its coordinates.
     */
    public void opposite(){
        this.X *= -1;
        this.Y *= -1;
        this.Z *= -1;
    }

    /**
     * Sets the x-coordinate of the vector to the specified value.
     *
     * @param x The new value for the x-coordinate
     */
    public void setX(double x){
        this.X = x;
    }

    /**
     * Sets the y-coordinate of the vector to the specified value.
     *
     * @param y The new value for the x-coordinate
     */
    public void setY(double y){
        this.Y = y;
    }

    /**
     * Sets the z-coordinate of the vector to the specified value.
     *
     * @param z The new value for the x-coordinate
     */
    public void setZ(double z){
        this.Z = z;
    }

    /**
     * Compares this vector with the given object for equality.
     *
     * @param obj The object to compare with this vector
     * @return {@code true} if the specified object is equal to this vector, {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vector other = (Vector)obj;
        int a = Double.compare(this.X, other.X);
        int b = Double.compare(this.Y, other.Y);
        int c = Double.compare(this.Z, other.Z);
        if(a == 0 && b == 0 && c == 0)
            return true;
        return false;
    }

    /**
     * Computes a hash code for this vector based on its coordinates.
     *
     * @return A hash code value for this vector
     */
    @Override
    public int hashCode(){
        return Objects.hash(X, Y, Z);
    }

    private double X, Y, Z;

    /**
     * zero vector
     */
    public static final Vector ZERO = new Vector();

    /**
     * unit vector in the x-direction
     */
    public static final Vector VERSOR_X = new Vector(1);

    /**
     * unit vector in the y-direction
     */
    public static final Vector VERSOR_Y = new Vector(0,1,0);

    /**
     * unit vector in the z-direction
     */
    public static final Vector VERSOR_Z = new Vector(0,0,1);
}
