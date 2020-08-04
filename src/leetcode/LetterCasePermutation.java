package leetcode;

import java.util.*;

public class LetterCasePermutation {

    public static void main(String[] args) {

        String s = "a1b2";
        System.out.println(letterCasePermutation(s));

    }

    public static List<String> letterCasePermutation(String S) {

        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
                System.out.println(queue.toString());
            }
        }

        return new LinkedList<>(queue);

    }


}
