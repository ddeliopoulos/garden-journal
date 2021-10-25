package ddeliopoulos.github.example;

import org.apache.el.parser.AstTrue;

public class EnumExample {

    public static void main(String[] args) {

        System.out.println(10 / 6);


        System.exit(0);


        System.out.println(fibbonacciIterative(5));
        System.out.println(fibbonacci(5));

        System.out.println(isPowerOfThree(1));


        DayOfWeek first = DayOfWeek.MONDAY;
        DayOfWeek second = DayOfWeek.MONDAY;

        if (first == second) {
            System.out.println("SAME");
        }
        ;

        for (DayOfWeek value : DayOfWeek.values()) {
            feedEddie();

            if (Boolean.TRUE.equals(value.isWeekend))
                feedEddie();
        }
    }

    static void feedEddie() {
        System.out.println("yum");
    }

    static int fibbonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibbonacci(n - 1) + fibbonacci(n - 2);
        }
    }

    public static boolean isPowerOfThree(int n) {
        double num = n;
        do{
            if(num == 0) return false;
            if(num == 1) return true;
            num/=3;
            if(num==1)return true;
        }while(num%3 == 0);
        return false;
    }


    static int fibbonacciIterative(int n) {
        int beforePrevious = 0;
        int previous = 1;

        for (int i = 0; i < n; ++i) {
            int tmp = beforePrevious;
            beforePrevious = previous;
            previous = tmp + previous;
        }
        return beforePrevious;
    }


    enum DayOfWeek {

        MONDAY(false),
        TUESDAY(false),
        WEDNESDAY(false),
        THURSDAY(false),
        FRIDAY(null),
        SATURDAY(true),
        SUNDAY(true);

        private final Boolean isWeekend;

        DayOfWeek(Boolean isWeekend) {
            this.isWeekend = isWeekend;
        }
    }


}
