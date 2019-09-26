package leetcode;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {

        int length = nums.length;
        int answer = 0;

        for (int i = 1; i < length ; i++) {
            if(nums[answer] != nums[i]){
                answer++;
                nums[answer] = nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));
        return answer+1;
    }
}
