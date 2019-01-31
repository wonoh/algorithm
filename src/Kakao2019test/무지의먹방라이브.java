package Kakao2019test;

import java.util.Arrays;

public class 무지의먹방라이브 {
    public static void main(String[] args) {
        int[] food ={3,1,2};
        long k = 5;
        solution(food,k);
    }
    public static int solution(int[] food_times, long k) {
        int N = food_times.length;
        long[] foods = new long[N + 1];
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            foods[i] = food_times[i - 1];
            sum += foods[i];
        }
        if (k >= sum)
            return -1;

        Arrays.sort(foods);
        long count = N;
        System.out.println(Arrays.toString(foods));
        for (int i = 1; i <= N; i++, count--) {
            long remain = foods[i] - foods[i - 1];
            if (remain * count <= k) {
                k -= remain * count;
                continue;
            }

            k %= count;
            for (int j = 0; j < N; j++) {
                if (food_times[j] <= foods[i - 1])
                    continue;
                if (k == 0)
                    return j + 1;
                k--;
            }
        }

        return -1;

    }
}
