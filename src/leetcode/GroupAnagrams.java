package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) {
            return null;
        }
        List<List<String>> answer = new ArrayList<>();

        int count = 0;
        while (count < strs.length) {
            List<String> subAnswer = new ArrayList<>();
            String s = "";
            for (int i = 0; i < strs.length; i++) {
                if(subAnswer.size() == 0){
                    for (int j = 0; j < strs.length ; j++) {
                        if(strs[j] != null){
                            char[] c = strs[j].toCharArray();
                            Arrays.sort(c);
                            subAnswer.add(strs[j]);
                            s = String.valueOf(c);
                            strs[j] = null;
                            count++;
                            break;
                        }
                    }
                    continue;
                }

                if (strs[i] == null || s.length() != strs[i].length()) {
                    continue;
                }
                char[] c = strs[i].toCharArray();
                Arrays.sort(c);
                if(s.contains(String.valueOf(c))){
                    count++;
                    subAnswer.add(strs[i]);
                    strs[i] = null;
                }
            }
            answer.add(subAnswer);
        }


        return answer;

    }


}
