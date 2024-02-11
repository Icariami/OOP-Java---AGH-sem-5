import java.util.Arrays;
import java.util.Objects;

/**
 * The BigNumber class represents non-negative real numbers with arbitrary precision.
 * Objects of this class are immutable, ensuring that their values cannot be changed after creation.
 * Each BigNumber object can have an arbitrary number of digits both before and after the decimal point.
 * For simplicity, we assume that both the integer and fractional parts always have at least one digit.
 * (e.g., for integers, the fractional part has one digit equal to 0).
 */
public final class BigNumber {
    public static void main(String[] args){
        BigNumber test1 = new BigNumber(new byte[]{1,2,3,4}, new byte[]{5,6,7,8});
        System.out.println(test1);
        System.out.println(BigNumber.ZERO);

        BigNumber test2 = test1.floor();
        System.out.println(test2);

        BigNumber test3 = BigNumber.valueOf(new byte[]{2}, new byte[]{0});
        System.out.println(test3);
    }

    /**
     * Integer part of this number.
     */
    private final byte[] integer;

    /**
     * fractional part of this number.
     */
    private final byte[] frac;


    private  int hash;
    private boolean isHash = false;

    /**
     * The BigNumber representing zero (0.0).
     */
    public static final BigNumber ZERO = new BigNumber(new byte[]{0}, new byte[]{0});

    /**
     * The BigNumber representing one (1.0).
     */
    public static final BigNumber ONE = new BigNumber(new byte[]{1}, new byte[]{0});

    /**
     * The BigNumber representing two (2.0).
     */
    public static final BigNumber TWO = new BigNumber(new byte[]{2}, new byte[]{0});

    /**
     * The BigNumber representing ten (10.0).
     */
    public static final BigNumber TEN = new BigNumber(new byte[]{1,0}, new byte[]{0});

    /**
     * Constructs a BigNumber from integer and fractional parts.
     *
     * @param i The integer part of the number
     * @param f The fractional part of the number
     */
    public BigNumber(byte[] i, byte[] f){
        this.integer = Arrays.copyOf(i, i.length);
        this.frac = Arrays.copyOf(f, f.length);
    }

    /**
     * Constructs a BigNumber as 0.0.
     */
    public BigNumber(){
        this.integer = new byte[]{0};
        this.frac = new byte[]{0};
    }

    /**
     * Constructs a Bignumer as a floor of other BigNumber.
     * @param other other BigNumber
     */
    private BigNumber(BigNumber other){
        this.integer = other.integer;
        this.frac = ZERO.frac;
    }

    /**
     * Returns a string representation of this BigNumber.
     * @return a string representation of this BigNumber.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(byte b : integer){
            result.append(b);
        }
        result.append(".");
        for(byte b : frac){
            result.append(b);
        }
        return result.toString();
    }

    /**
     * Returns the copy of the integer part of this BigNumber.
     * @return the copy of the integer part of this BigNumber.
     */
    public byte[] getInteger(){
        return Arrays.copyOf(integer, integer.length);
    }

    /**
     * Returns the copy of the fractional part of this BigNumber.
     * @return the copy of the fractional part of this BigNumber.
     */
    public byte[] getFrac(){
        return Arrays.copyOf(frac, frac.length);
    }

    /**
     * Returns a new BigNumber representing the floor of this number.
     * @return A new BigNumber representing the floor of this number.
     */
    public BigNumber floor(){
        return new BigNumber(this);
    }

    /**
     * Creates a BigNumber from given integer and fractional parts.
     * If the provided parts match predefined constants (ZERO, ONE, TWO, TEN), the constants are returned.
     *
     * @param i The integer part of the number
     * @param f The fractional part of the number
     * @return A BigNumber created from the given parts
     */
    public static BigNumber valueOf(byte[] i, byte[] f) {
        if(Arrays.equals(i, ZERO.integer) && Arrays.equals(f, ZERO.frac)) return ZERO;
        if(Arrays.equals(i, ONE.integer) && Arrays.equals(f, ONE.frac)) return ONE;
        if(Arrays.equals(i, TWO.integer) && Arrays.equals(f, TWO.frac)) return TWO;
        if(Arrays.equals(i, TEN.integer) && Arrays.equals(f, TEN.frac)) return TEN;
        return new BigNumber(i, f);
    }

    /**
     * Compares this BigNumber with the specified object for equality.
     * Two BigNumber objects are considered equal if they have the same integer and fractional parts.
     *
     * @param o The object to compare with this BigNumber
     * @return {@code true} if the specified object is equal to this BigNumber, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigNumber bigNumber = (BigNumber) o;
        return Arrays.equals(integer, bigNumber.integer) && Arrays.equals(frac, bigNumber.frac);
    }

    /**
     * Computes a hash code for this BigNumber based on its integer and fractional parts.
     *
     * @return A hash code value for this BigNumber
     */
    @Override
    public int hashCode() {
        if(!isHash) {
            isHash = true;
            hash = Arrays.hashCode(integer);
            hash = 31 * hash + Arrays.hashCode(frac);
        }
        return hash;
    }
}
