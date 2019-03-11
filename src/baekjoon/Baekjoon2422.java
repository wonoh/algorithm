package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2422 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M, N;
    static boolean[][] select;

    public static void main(String[] args) throws IOException {
        readLine();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new boolean[N+1][N+1];
        int answer = 0;

        for (int m = 0; m < M; m++) {
            readLine();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            select[a][b] = true;
            select[b][a] = true;
        }
        //System.out.println(Arrays.deepToString(select));
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if(!select[i][j]){
                    for(int k=j+1;k<=N;k++){
                        if(!select[i][k] && !select[j][k]){
                            answer++;
                        }
                    }
                }
            }
        }


        System.out.println(answer);


    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
