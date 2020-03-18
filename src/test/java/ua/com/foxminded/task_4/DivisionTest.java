package ua.com.foxminded.task_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.task_4.logic.Division;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    Division division;

    @BeforeEach
    void setUp() {
        division = new Division();

    }

    @Test
    public void makeDivisionShouldThrowIllegalArgumentExceptionWhenDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> division.makeDivision(22, 0));
    }

    @Test
    public void makeDivisionShouldThrowIllegalArgumentExceptionWhenInputIsMoreThanCapacityInteger() {
        assertThrows(IllegalArgumentException.class, () -> division.makeDivision(6, 2147483647 + 1));
    }

    @Test
    public void makeDivisionShouldThrowIllegalArgumentExceptionWhenInputNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> division.makeDivision(-78945, -4));
    }

    @Test
    public void makeDivisionShouldMakeDivisionWhenDividendBigger() {
        String expected = "_50│25\n" +
                " 50│-\n" +
                " --│2\n";
        String actual = division.makeDivision(50, 25);
        assertEquals(expected, actual);
    }

    @Test
    public void makeDivisionShouldMakeDivisionWhenDivisorBigger() {
        String expected = "50/100 = 0.5";
        String actual = division.makeDivision(50, 100);
        assertEquals(expected, actual);
    }


    @Test
    public void makeDivisionShouldMakeDivision() {
        String expected = "_78945│4\n" +
                " 4    │-----\n" +
                " -    │19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n" +
                " _29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1\n";
        String actual = division.makeDivision(4, 78945);
        assertEquals(expected, actual);
    }


    @Test
    public void makeDivisionShouldMakeDivisionWhenDivisorMaxValue() {
        String expected = "6/999295989 = 6.004227041883984E-9";
        String actual = division.makeDivision(6, 2147483647);
        assertEquals(expected, actual);
    }

    @Test
    public void makeDivisionShouldMakeDivisionWhenDividendMaxValue() {
        String expected = "_2147483647│322\n" +
                " 1932      │------\n" +
                " ----      │666923\n" +
                " _2154\n" +
                "  1932\n" +
                "  ----\n" +
                "  _2228\n" +
                "   1932\n" +
                "   ----\n" +
                "   _2963\n" +
                "    2898\n" +
                "    ----\n" +
                "     _656\n" +
                "      644\n" +
                "      ---\n" +
                "      _1247\n" +
                "        966\n" +
                "        ----\n";
        String actual = division.makeDivision(2147483647, 322);
        assertEquals(expected, actual);
    }

    @Test
    public void makeDivisionShouldMakeDivisionWhenBothMaxValue() {
        String expected = "_2147483647│2147483647\n" +
                " 2147483647│-\n" +
                " ----------│1\n";
        String actual = division.makeDivision(2147483647, 2147483647);
        assertEquals(expected, actual);
    }

    @Test
    public void makeDivisionShouldMakeDivisionWhenInputMaxValueAndOutputMax() {
        String expected = "_2147483647│1\n" +
                " 2         │----------\n" +
                " -         │2147483647\n" +
                " _1\n" +
                "  1\n" +
                "  -\n" +
                "  _4\n" +
                "   4\n" +
                "   -\n" +
                "   _7\n" +
                "    7\n" +
                "    -\n" +
                "    _4\n" +
                "     4\n" +
                "     -\n" +
                "     _8\n" +
                "      8\n" +
                "      -\n" +
                "      _3\n" +
                "       3\n" +
                "       -\n" +
                "       _6\n" +
                "        6\n" +
                "        -\n" +
                "        _4\n" +
                "         4\n" +
                "         -\n" +
                "         _7\n" +
                "          7\n" +
                "          -\n";
        String actual = division.makeDivision(2147483647, 1);
        assertEquals(expected, actual);
    }

}
