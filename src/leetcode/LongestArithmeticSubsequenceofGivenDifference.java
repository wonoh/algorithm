package leetcode;

import java.util.HashMap;

public class LongestArithmeticSubsequenceofGivenDifference {


    public static void main(String[] args) {

        int[] arr = {1,5,7,8,5,3,4,2,1};
        int diff = -2;
        System.out.println(longestSubsequence(arr,diff));
    }
    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            System.out.println("arr[i]-difference ==="+(arr[i]-difference));
            if(map.containsKey(arr[i]-difference)){
                System.out.println("같은게 있을때 arr[i]:"+i);
                map.put(arr[i],map.get(arr[i]-difference) +1);
            }else{
                map.put(arr[i],1);
            }
            max = Math.max(map.get(arr[i]),max);
        }
        System.out.println(map);

        return max;
    }
}
