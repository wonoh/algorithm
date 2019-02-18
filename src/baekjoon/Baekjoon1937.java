package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1937 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    public static int dfs(int x, int y) {
        if(dist[x][y]!=0){
            return dist[x][y];
        }
        int day = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }
            if (map[nextX][nextY] > map[x][y]) {
                day = Math.max(day,dfs(nextX,nextY)+1);
                dist[x][y] = day;
            }
        }
        return day;
    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
