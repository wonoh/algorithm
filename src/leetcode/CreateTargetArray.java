package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateTargetArray {

    public static void main(String[] args) {


        createTargetArray(new int[]{0,1,2,3,4},
                new int[]{0,1,2,2,1});
    }

    public static int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> array = new ArrayList<>();
        for(int i = 0; i < index.length; i++){
            array.add(index[i], nums[i]);
        System.out.println(array);
        }
        for(int i = 0; i < index.length; i++){
            nums[i] = array.get(i);
        }
        return nums;

    }
}
