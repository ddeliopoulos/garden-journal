package ddeliopoulos.github.example;

import java.util.Arrays;


public class SortColorsQuestion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        if (nums.length == 1) return;
        int start = 0;
        int end = nums.length - 1;
        int i = 0;

        while (i <= end) {
            if (nums[i] == 0) {
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            } else i++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
