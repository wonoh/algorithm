package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],false);
            }else{
                map.put(nums[i],true);
            }
        }
        int answer = 0;
        for(Map.Entry entry : map.entrySet()){
            if((boolean)entry.getValue()){
                answer = (int)entry.getKey();
                break;
            }
        }
        return answer;

    }

}
