package leetcode;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {

        int[] h = {1,1,4,2,1,3};
        System.out.println(heightChecker(h));

    }
    public static int heightChecker(int[] heights) {
        int[] tmp = new int[heights.length];
        System.arraycopy(heights, 0, tmp, 0, heights.length);
        Arrays.sort(tmp);
        int answer = 0;
        for (int i = 0; i < heights.length ; i++) {
            if(heights[i] != tmp[i]){
                answer++;
            }
        }
        return answer;

    }
}
