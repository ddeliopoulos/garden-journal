package ddeliopoulos.github.example;

import org.apache.el.parser.AstTrue;

public class EnumExample {

    public static void main(String[] args) {
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
