package leetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));

    }

    public static int[] shuffle(int[] nums, int n) {

        int[] shuffled = new int[nums.length];
        int left = 0;
        int right = n;
        int leftIndex = 0;
        int rightIndex = 1;
        for (int i = 0; i < n; i++) {
            shuffled[leftIndex] = nums[left];
            shuffled[rightIndex] = nums[right];
            left++;
            right++;
            leftIndex+=2;
            rightIndex+=2;
        }

        return shuffled;
    }
}
