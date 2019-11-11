package leetcode;

import java.util.Arrays;

public class MinMoves {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println(minMoves(nums));
    }
    public static int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;

    }

}
