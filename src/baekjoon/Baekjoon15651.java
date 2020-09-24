package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15651 {

    static int N;
    static int M;
    static int[] num;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N + 1];

        dfs(0);
        System.out.println(result);
    }

    static void dfs(int current) {
        if (current == M) {
            for (int i = 0; i < M; i++) {
                result.append(num[i] + " ");
            }
            result.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                num[current] = i;
                dfs(current + 1);
            }
        }
    }
}
