import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigNumberTest {
    @Test
    public void testConstructionAndEquality() {
        BigNumber number1 = new BigNumber(new byte[]{1, 2, 3}, new byte[]{4, 5, 6});
        BigNumber number2 = new BigNumber(new byte[]{1, 2, 3}, new byte[]{4, 5, 6});
        BigNumber number3 = new BigNumber(new byte[]{1, 2, 3}, new byte[]{7, 8, 9});

        assertEquals(number1, number2);
        assertNotEquals(number1, number3);

        assertEquals(number1.hashCode(), number2.hashCode());
        assertNotEquals(number1.hashCode(), number3.hashCode());
    }

    @Test
    public void testStaticFields() {
        BigNumber zero = BigNumber.valueOf(new byte[]{0}, new byte[]{0});
        BigNumber one = BigNumber.valueOf(new byte[]{1}, new byte[]{0});
        BigNumber two = BigNumber.valueOf(new byte[]{2}, new byte[]{0});
        BigNumber ten = BigNumber.valueOf(new byte[]{1,0}, new byte[]{0});

        assertSame(zero, BigNumber.ZERO);
        assertSame(one, BigNumber.ONE);
        assertSame(two, BigNumber.TWO);
        assertSame(ten, BigNumber.TEN);

        assertEquals(zero.hashCode(), BigNumber.ZERO.hashCode());
        assertEquals(one.hashCode(), BigNumber.ONE.hashCode());
        assertEquals(two.hashCode(), BigNumber.TWO.hashCode());
        assertEquals(ten.hashCode(), BigNumber.TEN.hashCode());
    }

}
