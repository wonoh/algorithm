package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon13458 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, B, C;
    static int[] A;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        readLine();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        readLine();
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int supervisor = 0;
            if (map.containsKey(A[i])) {
                answer += map.get(A[i]);
                continue;
            }
            if (A[i] <= B) {
                supervisor++;
            } else {
                int remain = A[i] - B;
                supervisor++;
                if (remain % C == 0) {
                    supervisor += remain / C;
                } else {
                    supervisor += remain / C + 1;
                }
            }

            answer += supervisor;
            if (!map.containsKey(A[i])) {
                map.put(A[i], supervisor);
            }
        }
        System.out.println(answer);
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
