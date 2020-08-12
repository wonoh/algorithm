package leetcode;

import java.util.Arrays;

public class ShuffleString {


    public static void main(String[] args) {
        System.out.println(restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3}));

    }

    public static String restoreString(String s, int[] indices) {

        StringBuilder sb = new StringBuilder();

        int m = -1;
        while (sb.length() != s.length()){
            m++;
            for (int i = 0; i < indices.length ; i++) {
                if(indices[i] == m){
                    sb.append(s.charAt(i));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
