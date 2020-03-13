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
    public void makeDivisionShouldMakeDivisionAndOutputTwoDecimalPlaceWhenDividendBigger() {
        String expected = "7/25 = 0,28";
        String actual = division.makeDivision(7, 25);
        assertEquals(expected, actual);
    }

    @Test
    public void makeDivisionShouldThrowIllegalArgumentExceptionWhenInputNegativeNumber() {
        assertThrows(IllegalArgumentException.class,() -> division.makeDivision(-78945, -4));
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
        String actual = division.makeDivision(78945, 4);
        assertEquals(expected, actual);
    }
}