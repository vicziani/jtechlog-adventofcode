package day2;

import java.io.InputStreamReader;

public class IntcodeInputFinder {

    private int noun;

    private int verb;

    public void findInputs() {
        for (noun = 0; noun <= Intcode.MAX_VALUE; noun++) {
            for (verb = 0; verb <= Intcode.MAX_VALUE; verb++) {
                var intcode = new Intcode();
                intcode.load(new InputStreamReader(Intcode.class.getResourceAsStream("input")));
                intcode.replace(1, noun);
                intcode.replace(2, verb);
                intcode.execute();
                if (intcode.getCode()[0] == 19690720) {
                    return;
                }
            }
        }
    }

    public int getResult() {
        return 100 * noun + verb;
    }
}
