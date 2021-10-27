package ddeliopoulos.github.example;

import org.apache.el.parser.AstTrue;
import org.springframework.data.relational.core.sql.In;

import java.util.*;

public class EnumExample {

    public static void main(String[] args) {

//        System.out.println(10 / 6);
//
//
//        System.exit(0);
//
//
//        System.out.println(fibbonacciIterative(5));
//        System.out.println(fibbonacci(5));
//
//        System.out.println(isPowerOfThree(1));

        System.out.println(isHappy(18));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        String num = String.valueOf(n);
        int squaresOfDigits;
        do {
            squaresOfDigits = 0;
            for (int i = 0; i < num.length(); i++) {
                int singleNum = num.charAt(i) - '0';
                squaresOfDigits += singleNum * singleNum;
            }
            System.out.println(squaresOfDigits);

            if (set.contains(squaresOfDigits)) return false;
            else set.add(squaresOfDigits);
            num = String.valueOf(squaresOfDigits);

        } while (squaresOfDigits != 1);
        return true;
    }


//
//        DayOfWeek first = DayOfWeek.MONDAY;
//        DayOfWeek second = DayOfWeek.MONDAY;

//        if (first == second) {
//            System.out.println("SAME");
//        }


//        for (DayOfWeek value : DayOfWeek.values()) {
//            feedEddie();
//
//            if (Boolean.TRUE.equals(value.isWeekend))
//                feedEddie();
//        }


//    static void feedEddie() {
//        System.out.println("yum");
//    }
//
//    static int fibbonacci(int n) {
//        if (n <= 1) {
//            return n;
//        } else {
//            return fibbonacci(n - 1) + fibbonacci(n - 2);
//        }
//    }

    public static boolean isPowerOfThree(int n) {
        double num = n;
        do {
            if (num == 0) return false;
            if (num == 1) return true;
            num /= 3;
            if (num == 1) return true;
        } while (num % 3 == 0);
        return false;
    }


    public static boolean isValid(final String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            final char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') stack.push(currentChar);
            else { // closing bracket
                if (stack.empty()) {
                    return false;
                }
                final char previousOpeningBracket = stack.pop();
                if ((previousOpeningBracket == '(' && currentChar != ')')
                        || (previousOpeningBracket == '[' && currentChar != ']')
                        || (previousOpeningBracket == '{' && currentChar != '}')) {
                    return false;
                }
            }
            i++;
            System.out.println(Arrays.toString(stack.toArray()));
        }
        return stack.empty();
    }


//    public static boolean isValid(String s) {
//
//        Stack<Character> stack = new Stack<>();
//        if (s.length() % 2 != 0) return false;
//        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;
//        int stringLength = s.length();
//        char c = s.charAt(0);
//
//        int k = 0;
//        while (k < stringLength - 1) {
//            if (s.charAt(k) == '(' || s.charAt(k) == '[' || s.charAt(k) == '{') {
//                c = stack.push(s.charAt(k));
//            }
//            if (c == '(' && s.charAt(k + 1) == ')' || c == '[' && s.charAt(k + 1) == ']' || c == '{' && s.charAt(k + 1) == '}' && !stack.empty()) {
//                stack.pop();
//                c = stack.peek();
//            }
//            k++;
//            System.out.println(Arrays.toString(stack.toArray()));
//        }
//        return stack.empty();
//    }


//        for (int i = 0; i < stringLength; i++) {
//            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
//                c = stack.push(s.charAt(i));
//            }
//            if(i <= stringLength-1) {
//                if (c == '(' && s.charAt(i+1) == ')' || c == '[' && s.charAt(i+1) == ']' || c == '{' && s.charAt(i+1) == '}' && !stack.empty()) {
//                    stack.pop();
//                    c=stack.peek();
//                }
//            }
//            System.out.println(Arrays.toString(stack.toArray()));
//        }
//        return stack.empty();
//    }


    public static int fibbonacciIterative(int n) {
        int beforePrevious = 0;
        int previous = 1;

        for (int i = 0; i < n; ++i) {
            int tmp = beforePrevious;
            beforePrevious = previous;
            previous = tmp + previous;
        }
        return beforePrevious;
    }
}
//    enum DayOfWeek {
//
//        MONDAY(false),
//        TUESDAY(false),
//        WEDNESDAY(false),
//        THURSDAY(false),
//        FRIDAY(null),
//        SATURDAY(true),
//        SUNDAY(true);
//
//        private final Boolean isWeekend;
//
//        DayOfWeek(Boolean isWeekend) {
//            this.isWeekend = isWeekend;
//        }
//    }
//

