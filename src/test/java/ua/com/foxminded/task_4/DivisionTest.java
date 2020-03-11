package ua.com.foxminded.task_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    Division division;
    @BeforeEach
    void setUp() {
       division  = new Division();


    }

    @Test
    public void shouldMakeDivision() {
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