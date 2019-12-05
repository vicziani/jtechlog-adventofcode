package day2;

import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntcodeTest {

    @Test
    public void testFirstExample() {
        var intcode = new Intcode();
        intcode.load(new StringReader("1,0,0,0,99"));
        intcode.execute();
        assertEquals("2,0,0,0,99", intcode.toString());
    }

    @Test
    public void testSecondExample() {
        var intcode = new Intcode();
        intcode.load(new StringReader("2,3,0,3,99"));
        intcode.execute();
        assertEquals("2,3,0,6,99", intcode.toString());
    }

    @Test
    public void testFinal() {
        var intcode = new Intcode();
        intcode.load(new InputStreamReader(IntcodeTest.class.getResourceAsStream("input")));
        intcode.replace(1, 12);
        intcode.replace(2, 2);
        intcode.execute();
        assertEquals(3409710, intcode.getCode()[0]);
        System.out.println(intcode);
    }
}
