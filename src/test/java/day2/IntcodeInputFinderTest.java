package day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntcodeInputFinderTest {

    @Test
    void testFindInputs() {
        var finder = new IntcodeInputFinder();
        finder.findInputs();
        assertEquals(7912, finder.getResult());
    }
}
