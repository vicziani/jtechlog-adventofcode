package day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tyranny {

    public int calculateSumOfFuelRequirements() {
        try (var lines = new BufferedReader(new InputStreamReader(Tyranny.class.getResourceAsStream("input"))).lines()) {
            return lines
                    .mapToInt(Integer::parseInt)
                    .map(this::calculateForMass)
                    .sum();
        }
    }

    public int calculateSumOfFuelWithFuelRequirements() {
        try (var lines = new BufferedReader(new InputStreamReader(Tyranny.class.getResourceAsStream("input"))).lines()) {
            return lines
                    .mapToInt(Integer::parseInt)
                    .map(this::calculateForMassWithFuel)
                    .sum();
        }
    }

    private int calculateForMass(int mass) {
        return (mass / 3) - 2;
    }

    public int calculateForMassWithFuel(int mass) {
        var value = calculateForMass(mass);
        if (value <= 0) {
            return 0;
        }
        return value + calculateForMassWithFuel(value);
    }
}
