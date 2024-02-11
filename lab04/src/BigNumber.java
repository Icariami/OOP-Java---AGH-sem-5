import java.util.Arrays;

/**
 * The BigNumber class represents non-negative real numbers with arbitrary precision.
 * Objects of this class are immutable, ensuring that their values cannot be changed after creation.
 * Each BigNumber object can have an arbitrary number of digits both before and after the decimal point.
 * For simplicity, we assume that both the integer and fractional parts always have at least one digit.
 * (e.g., for integers, the fractional part has one digit equal to 0).
 */
public final class BigNumber {

    /**
     * Integer part of this number.
     */
    private final byte[] integer;

    /**
     * Fractional part of this number.
     */
    private final byte[] frac;

    /**
     * Hash code cache to improve performance.
     */
    private int hash;
    private boolean isHash = false;

    /**
     * Represents zero.
     */
    public static final BigNumber ZERO = new BigNumber(new byte[]{0}, new byte[]{0});

    /**
     * Represents one.
     */
    public static final BigNumber ONE = new BigNumber(new byte[]{1}, new byte[]{0});

    /**
     * Represents two.
     */
    public static final BigNumber TWO = new BigNumber(new byte[]{2}, new byte[]{0});

    /**
     * Represents ten.
     */
    public static final BigNumber TEN = new BigNumber(new byte[]{1, 0}, new byte[]{0});

    /**
     * Private constructor for creating a BigNumber object.
     * @param i Integer part.
     * @param f Fractional part.
     */
    public BigNumber(byte[] i, byte[] f) {
        this.integer = Arrays.copyOf(i, i.length);
        this.frac = Arrays.copyOf(f, f.length);
    }

    /**
     * Copy constructor creates a BigNumber object with the same values as another BigNumber.
     * @param other The other BigNumber object.
     */
    private BigNumber(BigNumber other) {
        this.integer = Arrays.copyOf(other.integer, other.integer.length);
        this.frac = Arrays.copyOf(other.frac, other.frac.length);
    }

    /**
     * Factory method to create a BigNumber object with specified integer and fractional parts.
     * @param i Integer part.
     * @param f Fractional part.
     * @return A new BigNumber object.
     */
    public static BigNumber valueOf(byte[] i, byte[] f) {
        if (Arrays.equals(i, ZERO.integer) && Arrays.equals(f, ZERO.frac)) return ZERO;
        if (Arrays.equals(i, ONE.integer) && Arrays.equals(f, ONE.frac)) return ONE;
        if (Arrays.equals(i, TWO.integer) && Arrays.equals(f, TWO.frac)) return TWO;
        if (Arrays.equals(i, TEN.integer) && Arrays.equals(f, TEN.frac)) return TEN;
        return new BigNumber(i, f);
    }

    /**
     * Returns the integer part of this number.
     * @return The integer part.
     */
    public byte[] getInteger() {
        return Arrays.copyOf(integer, integer.length);
    }

    /**
     * Returns the fractional part of this number.
     * @return The fractional part.
     */
    public byte[] getFrac() {
        return Arrays.copyOf(frac, frac.length);
    }

    /**
     * Creates a new BigNumber object that represents the floor of this number.
     * @return The floor of this number.
     */
    public BigNumber floor() {
        return new BigNumber(this);
    }

    /**
     * Checks if two BigNumber objects are equal.
     * @param o The other object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigNumber bigNumber = (BigNumber) o;
        return Arrays.equals(integer, bigNumber.integer) && Arrays.equals(frac, bigNumber.frac);
    }

    /**
     * Computes the hash code for this BigNumber.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        if (!isHash) {
            isHash = true;
            hash = Arrays.hashCode(integer);
            hash = 31 * hash + Arrays.hashCode(frac);
        }
        return hash;
    }

    /**
     * Returns a string representation of this BigNumber.
     * @return The string representation.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (byte b : integer) {
            result.append(b);
        }
        result.append(".");
        for (byte b : frac) {
            result.append(b);
        }
        return result.toString();
    }
}

