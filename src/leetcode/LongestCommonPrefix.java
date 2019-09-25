package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {


        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        if(length == 1){
            return strs[0];
        }
        int max = 0;
        for (int i = 0; i < length ; i++) {
            max = max > strs[i].length() ? max : strs[i].length();
        }
        String[] tmp = new String[max];

        for (int i = 0; i < length-1 ; i++) {

            String now = strs[i];
            String next = strs[i+1];

            boolean flag = false;

            int nowLength = now.length();
            int nextLength = next.length();

            int min = nowLength < nextLength ? nowLength : nextLength;

            for (int j = 0; j < min; j++) {

                if(now.charAt(j) == next.charAt(j)){
                    tmp[j] = String.valueOf(now.charAt(j));
                    flag = true;
                }else{
                    if(tmp[j] != null){
                        tmp[j] = null;
                    }
                }
            }
            if(!flag){
                return "";
            }
        }
        StringBuilder result = new StringBuilder();
        for (String s : tmp) {
            if (s != null) {
                result.append(s);
            }
        }
        return result.toString();
    }
}
