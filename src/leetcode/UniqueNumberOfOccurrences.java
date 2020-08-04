package leetcode;

import java.util.*;

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {


        int[] arr = {26, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2, 16, 20, 16, 17, 16, 2, 16, 20, 26, 16};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry e : map.entrySet()) {
            set.add((Integer) e.getValue());
        }

        return set.size() == map.size();
    }
}
