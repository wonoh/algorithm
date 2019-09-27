package leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));


    }

    public static int maxArea(int[] height) {

        int answer = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length ; j++) {
                int min = Math.min(height[i],height[j]);
                answer = Math.max(answer,min*(j-i));
            }
        }

        return answer;
    }
}
