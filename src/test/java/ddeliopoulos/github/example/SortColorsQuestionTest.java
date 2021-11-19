package ddeliopoulos.github.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortColorsQuestionTest {

    @Test
    void sortColors_GivenEmptyArrayThenBecomesSorted() {
        //given
        int[] nums = new int[0];

        SortColorsQuestion.sortColors(nums);
        //then
        Assertions.assertEquals(nums.length, 0);
    }

    @Test
    void sortColors_GivenArrayWithOneElement() {
        //given
        int[] nums = {1};

        SortColorsQuestion.sortColors(nums);
        //then
        Assertions.assertEquals(nums.length, 1);
    }

    @Test
    void sortColors_GivenTwoElements() {
        //given
        int[] nums = {1, 0};

        SortColorsQuestion.sortColors(nums);

        Assertions.assertArrayEquals(new int[]{0, 1}, nums);
    }

    @Test
    void sortColors_GivenAFewElements() {
        //given
        int[] nums = {1, 0, 2};

        SortColorsQuestion.sortColors(nums);

        //then
        Assertions.assertArrayEquals(new int[]{0, 1, 2}, nums);
    }

    @Test
    void sortColors_GivenManyElements() {
        //given
        int[] nums = {1, 0, 2, 0, 2, 0};

        SortColorsQuestion.sortColors(nums);

        //then
        for (int i = 0; i < nums.length - 1; i++) {
            assertTrue(nums[i + 1] >= nums[i], Arrays.toString(nums) + " is wrong at " + i);
        }
    }
}