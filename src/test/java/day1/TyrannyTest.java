package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TyrannyTest {

    @Test
    void testCalculateFuel() {
        assertEquals(3317668, new Tyranny().calculateSumOfFuelRequirements());
    }

    @Test
    void testCalculateSingleFuelWithFuel() {
        assertEquals(50346, new Tyranny().calculateForMassWithFuel(100756));
    }

    @Test
    void testCalculateFuelWithFuel() {
        assertEquals(4973628, new Tyranny().calculateSumOfFuelWithFuelRequirements());
    }
}
