package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Maximum69Number {

    public static void main(String[] args) {

        maximum69Number(9966);
    }

    public static int maximum69Number (int num) {
        int[] ints = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        String number = "";
        boolean isChange = false;
        for (int i = 0; i < ints.length ; i++) {
            if(ints[i] != 9 && !isChange){
                ints[i] = 9;
                isChange = true;
            }
            number += Integer.toString(ints[i]);
        }


        return Integer.parseInt(number);
    }
}
