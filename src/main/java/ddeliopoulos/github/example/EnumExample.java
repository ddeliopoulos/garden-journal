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

        int[][] grid = {{2,1,1},
                        {1,1,0},
                        {0,1,1}};

        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {

        int rowLength = grid.length;
        int colLength = grid[0].length;
        int min = 0;
     while(min < 3) {
         for (int row = 0; row < rowLength; row++) {
             for (int col = 0; col < colLength; col++) {
                 if (row > 0 && grid[row][col] == 2 && grid[row - 1][col] == 2) col++;

                 if (col == 0 && row != rowLength - 1 && grid[row][col] == 2) {
                     if (grid[row + 1][col] == 1) grid[row + 1][col] = 2;
                     if (grid[row][col + 1] == 1) {
                         grid[row][col + 1] = 2;
                         col++;
                     }
                 } else if (col > 0 && col < colLength - 1 && grid[row][col] == 2) {
                     if (grid[row][col - 1] == 1) grid[row][col - 1] = 2;
                     if (grid[row + 1][col] == 1) grid[row + 1][col] = 3;
                     if (grid[row][col + 1] == 1) {
                         grid[row][col + 1] = 2;
                         col++;
                     }
                 } else if (col == colLength - 1 && row != rowLength - 1 && grid[row][col] == 2) {
                     if (grid[row + 1][col] == 1) grid[row + 1][col] = 2;
                 } else continue;
             }
         }
         min++;

         for (int[] row : grid) {
             System.out.println(row[0]);
             }
         }
        System.out.println(Arrays.deepToString(grid));

        return min;
        }



//                if(grid[row][col] == 1 && row - 1 >= 0 && grid[row - 1][col] == 2){
//                    grid[row][col]+=1;
//                }
//
//                if(grid[row][col] == 2){
//                    if(row == 0){
//                        if(col == 0){
//                            if(grid[row+1][col] == 1) grid[row+1][col] = 2;
//                            if(grid[row][col+1] == 1) {
//                                grid[row][col + 1] = 2;
//                                col++;
//                            }
//                        }
//                        else if(col == colLength-1){
//
//                        }
//                    }
//                }
//
//                    if(row + col == 0){
//                        if(grid[row+1][col] == 1) grid[row+1][col] = 2;
//                        if(grid[row][col+1] == 1) {
//                            grid[row][col + 1] = 2;
//                            col++;
//                        }
//                    }
//
//
//                    if(col > 0 && col < colLength-1 && row-1 >= 0){
//                        if(grid[row][col] == 2 && grid[row][col+1] == 1) grid[row][col + 1] += 1;
//                        if(grid[row][col-1] == 1 ) grid[row][col-1]+=1;
//                          col++;
//                      }
//
//                    if(grid[row][colLength-1] == 2 && grid[row][col-1] == 1){
//                         grid[row][col-1] +=1;
//                      col++;

//                  if(grid[row][col] == 2 && grid[row+1][col] == 1) {
//                    grid[row][col + 1]+=1;
//                    if (grid[row+1][col] == 1) {
//                        nextRow = row+1;
//                        nextCol = col;
//                        if(row+1 != rowLength-1) grid[row+1][col] = 2;
//                        if(col != 0 && grid[row][col - 1] == 1) grid[row][col - 1] = 2;
//                        col++;
//                    }
//                }

    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> hMap = new HashMap<>();
        int nonRepeatingNum = 100000;
        if(s.length() == 1) return 0;
        hMap.put(s.charAt(0), 1);

        for(int i = 1; i < s.length(); i++){
            if(!hMap.containsKey(s.charAt(i))){
                hMap.put(s.charAt(i), 1);
            }else hMap.put(s.charAt(i), hMap.get(s.charAt(i)) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hMap.entrySet()) {
            if(entry.getValue() == 1 && s.indexOf(entry.getKey()) < nonRepeatingNum) nonRepeatingNum = s.indexOf(entry.getKey());
        }
        if(nonRepeatingNum != 100000) return nonRepeatingNum;
        else return -1;
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

