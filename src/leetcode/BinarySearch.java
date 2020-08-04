package leetcode;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));

    }

    public static int search(int[] nums, int target) {
        int answer = Arrays.binarySearch(nums,target);
        return answer < 0 ? -1 : answer;



    }

}
