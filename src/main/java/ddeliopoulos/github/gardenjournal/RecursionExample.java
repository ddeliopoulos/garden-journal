package ddeliopoulos.github.gardenjournal;

public class RecursionExample {

    public static void main(String... args) {
        fibonacciNumber(100000);
    }

    static int fibonacciNumber(int i) {
        if (i <= 1) return i;

        return fibonacciNumber(i - 1) + fibonacciNumber(i - 2);
    }
}
