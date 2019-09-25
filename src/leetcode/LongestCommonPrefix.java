package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {


        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        if(length == 0){
            return "";
        }
        if(length == 1){
            return strs[0];
        }

        String first = strs[0];
        String second = strs[1];

        int min = first.length() < second.length() ? first.length() : second.length();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < min ; i++) {
           if(first.charAt(i) == second.charAt(i)){
               result.append(first.charAt(i));
           }else{
               break;
           }

        }

        //2번째부터
        for (int i = 2; i < length ; i++) {
            if(!strs[i].startsWith(result.toString())){
                while(true){

                    result.delete(result.length()-1,result.length());

                    if(strs[i].startsWith(result.toString())){
                        break;
                    }
                }
            }
        }
        return result.toString();
    }
}
