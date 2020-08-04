package leetcode;

import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(missingNumber(nums));


    }

    public static int missingNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length ; i++) {
            map.put(i,0);
        }
        for(int n:nums){
            map.put(n,1);
        }
        int answer = 0;
        for(Map.Entry entry : map.entrySet()){
            if(entry.getValue().equals(0)){
                answer=  (int) entry.getKey();
                break;
            }
        }
        return answer;


    }

}
