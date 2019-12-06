package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Intcode {

    public static final int MAX_VALUE = 99;

    private int[] code;

    int position = 0;

    public void load(Reader reader) {
        try {
            var strings = new BufferedReader(reader).readLine().split(",");
            code = new int[strings.length];
            for (var i = 0; i < strings.length; i++) {
                code[i] = Integer.parseInt(strings[i]);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not load file", ioe);
        }
    }

    public void replace(int position, int value) {
        code[position] = value;
    }

    public void execute() {
        var operator = Operator.getByCode(code[position]);
        while (operator != Operator.EXIT) {
            operator.operate(code, position);

            position = position + 4;
            operator = Operator.getByCode(code[position]);
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(code).mapToObj(Integer::toString).collect(Collectors.joining(","));
    }

    public int[] getCode() {
        return code;
    }

    private enum Operator {

        ADD {
            public void operate(int[] code, int position) {
                var value1 = getValue(code, position + 1);
                var value2 = getValue(code, position + 2);
                var resultPosition = code[position + 3];
                code[resultPosition] = value1 + value2;
            }
        },

        MULTIPLY {
            public void operate(int[] code, int position) {
                var value1 = getValue(code, position + 1);
                var value2 = getValue(code, position + 2);
                var resultPosition = code[position + 3];
                code[resultPosition] = value1 * value2;
            }
        },
        EXIT {
            public void operate(int[] code, int position) {
            }
        }
        ;

        public abstract void operate(int[] code, int position);

        public int getValue(int[] code, int position) {
            int targetPosition = code[position];
            return code[targetPosition];
        }

        public static Operator getByCode(int code) {
            switch (code) {
                case 1:
                    return ADD;
                case 2:
                    return MULTIPLY;
                case 99:
                    return EXIT;
                default:
                    throw new IllegalArgumentException("Invalid code: " + code);
            }
        }

    }
}
