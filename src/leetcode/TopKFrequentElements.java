package leetcode;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {

        int[] nums = {1,1,2,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums,k));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> list;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        list = sort(map).subList(0,k);
        return list;
    }
    public static List sort(Map map){

        ArrayList list = new ArrayList(map.keySet());

        list.sort((o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);
            return ((Comparable) v2).compareTo(v1);

        });

        return list;
    }
}
