package ddeliopoulos.github.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexityExample {

    public static void main(String[] args) {
        for (int input = 0; input < 1000; ++input) {
            List<Long> measurements = new ArrayList<>();
            for (int measure = 0; measure < 1000; ++measure) {
                long startTime = System.nanoTime();
                bla(input);
                long totalTimeMillis = System.nanoTime() - startTime;
                measurements.add(totalTimeMillis);
            }
            System.out.println(input + "\t" + median(measurements));
        }
    }

    private static long median(List<Long> list) {
        list.sort(Long::compareTo);
        if (list.size() % 2 == 0)
            return (long) ((double)list.get(list.size()/2) + (double)list.get(list.size()/2 - 1))/2;
        else
            return list.get(list.size() / 2);
    }

    public static int bla(int input) {
        ArrayList<Object> bla = new ArrayList<>();
        for (int i = 0; i < input; ++i) {
            bla.add(i);
        }
        return bla.size();
    }

    public static int blaBla(int input) {
        return input;
    }

}
