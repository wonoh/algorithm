package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KidsWithCandies {

    public static void main(String[] args) {
        int[] a = {2,3,5,1,3};
        kidsWithCandies(a,3);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> booleans = new ArrayList<>();
        int max = 0;

        for (int candy : candies) {
            if(candy > max){
                max = candy;
            }
        }
        for (int candy : candies) {
            booleans.add(candy+ extraCandies >= max);
        }
        return booleans;

    }
}
