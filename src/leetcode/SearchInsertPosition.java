package leetcode;

public class SearchInsertPosition {


    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        System.out.println(searchInsert(nums,3));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] < target){
                index++;
            }
            if(nums[i] == target){
                return i;
            }
        }
        return index;
    }
}
