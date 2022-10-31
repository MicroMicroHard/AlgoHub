package UnitTest.AlgorithmTest.backtrackTest;

import Algorithm.backtrack.Combination_Time;
import org.junit.Test;

public class Combination_TimeTest {

    @Test
    public void testCombination_Time() {
        testGetCorrectTimeCount(new Combination_Time());
    }

    @Test
    public void testCombination_MaxTime() {
        testCountMaxTime(new Combination_Time());
    }

    public void testCountMaxTime(Combination_Time instance) {
        String answer = instance.GetCorrectMaxTime(demo01);
        assert answer.equals(target_MaxTime01);
        answer = instance.GetCorrectMaxTime(demo02);
        assert answer.equals(target_MaxTime02);
        answer = instance.GetCorrectMaxTime(demo03);
        assert answer.equals(target_MaxTime03);
        answer = instance.GetCorrectMaxTime(demo04);
        assert answer.equals(target_MaxTime04);
        answer = instance.GetCorrectMaxTime(demo05);
        assert answer.equals(target_MaxTime05);
        answer = instance.GetCorrectMaxTime(demo06);
        assert answer.equals(target_MaxTime06);
        answer = instance.GetCorrectMaxTime(demo07);
        assert answer.equals(target_MaxTime07);
        answer = instance.GetCorrectMaxTime(demo08);
        assert answer.equals(target_MaxTime08);
        answer = instance.GetCorrectMaxTime(demo09);
        assert answer.equals(target_MaxTime09);
        answer = instance.GetCorrectMaxTime(demo10);
        assert answer.equals(target_MaxTime10);
        answer = instance.GetCorrectMaxTime(demo11);
        assert answer.equals(target_MaxTime11);
        answer = instance.GetCorrectMaxTime(demo12);
        assert answer.equals(target_MaxTime12);
        answer = instance.GetCorrectMaxTime(demo13);
        assert answer.equals(target_MaxTime13);
        answer = instance.GetCorrectMaxTime(demo14);
        assert answer.equals(target_MaxTime14);
    }

    public void testGetCorrectTimeCount(Combination_Time instance) {
        int answer = instance.GetCorrectTimeCount(demo01);
        assert answer == target01;
        answer = instance.GetCorrectTimeCount(demo02);
        assert answer == target02;
        answer = instance.GetCorrectTimeCount(demo03);
        assert answer == target03;
        answer = instance.GetCorrectTimeCount(demo04);
        assert answer == target04;
        answer = instance.GetCorrectTimeCount(demo05);
        assert answer == target05;
        answer = instance.GetCorrectTimeCount(demo06);
        assert answer == target06;
        answer = instance.GetCorrectTimeCount(demo07);
        assert answer == target07;
        answer = instance.GetCorrectTimeCount(demo08);
        assert answer == target08;
        answer = instance.GetCorrectTimeCount(demo09);
        assert answer == target09;
        answer = instance.GetCorrectTimeCount(demo10);
        assert answer == target10;
        answer = instance.GetCorrectTimeCount(demo11);
        assert answer == target11;
        answer = instance.GetCorrectTimeCount(demo12);
        assert answer == target12;
        answer = instance.GetCorrectTimeCount(demo13);
        assert answer == target13;
        answer = instance.GetCorrectTimeCount(demo14);
        assert answer == target14;
    }

    //extreme
    int[] demo01 = {0, 0, 0, 0};
    int target01 = 1;
    String target_MaxTime01 = "0:00";
    int[] demo02 = {2, 3, 5, 9};
    int target02 = 1;
    String target_MaxTime02 = "23:59";
    //small_digits : Digits are no more than 2 (all permutations are valid times).
    int[] demo03 = {0, 0, 0, 1};
    int target03 = 4;
    String target_MaxTime03 = "10:00";
    int[] demo04 = {2, 3, 3, 2};
    int target04 = 3;
    String target_MaxTime04 = "23:32";
    // the_same_digits : Four digits are the same
    int[] demo05 = {1, 1, 1, 1};
    int target05 = 1;
    String target_MaxTime05 = "11:11";
    int[] demo06 = {2, 2, 2, 2};
    int target06 = 1;
    String target_MaxTime06 = "22:22";
    // different_digits : All digits are different
    int[] demo07 = {1, 8, 3, 2};
    int target07 = 6;
    String target_MaxTime07 = "23:18";
    int[] demo08 = {4, 0, 2, 1};
    int target08 = 16;
    String target_MaxTime08 = "21:40";
    // sorted_digits : Given digits are sorted not decreasingly.
    int[] demo09 = {1, 2, 2, 3};
    int target09 = 9;
    String target_MaxTime09 = "23:21";
    // corners
    // answer_zero : No time can be constructed using given digits.
    int[] demo10 = {6, 2, 4, 7};
    int target10 = 0;
    String target_MaxTime10 = "";
    int[] demo11 = {9, 9, 9, 9};
    int target11 = 0;
    String target_MaxTime11 = "";
    // three_equal_digits : Exactly three digits are equal.
    int[] demo12 = {6, 6, 6, 1};
    int target12 = 0;
    String target_MaxTime12 = "";
    int[] demo13 = {3, 3, 3, 5};
    int target13 = 0;
    String target_MaxTime13 = "";
    int[] demo14 = {1, 1, 1, 3};
    int target14 = 3;
    String target_MaxTime14 = "13:11";
}
