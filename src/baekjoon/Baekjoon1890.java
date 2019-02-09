package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 점프        스터디 과제
 */
public class Baekjoon1890 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N+1][N+1];
        for (int i = 0; i < N; i++) {
            readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==N-1 && j==N-1){
                    continue;
                }
                if(i + map[i][j] < N){
                    dp[i+map[i][j]][j] += dp[i][j];
                }
                if(j + map[i][j] < N){
                    dp[i][j+map[i][j]] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }

    /*public static void dfs(int x, int y) {
        if (map[x][y] == 0) {
            answer++;
            return;
        }
        if (y + map[x][y] < N) {
            visited[x][y] = true;
            dfs(x, y + map[x][y]);
        }
        if (x + map[x][y] < N) {
            dfs(x + map[x][y], y);
            visited[x][y] = true;
        }
    }*/

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
