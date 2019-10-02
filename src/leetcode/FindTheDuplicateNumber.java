package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {


        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));

    }

    public static int findDuplicate(int[] nums) {

        int length = nums.length;
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length ; i++) {
            if(map.containsKey(nums[i])){
                answer = nums[i];
                break;
            }else{
                map.put(nums[i],nums[i]);
            }
        }
        return answer;
    }
}
