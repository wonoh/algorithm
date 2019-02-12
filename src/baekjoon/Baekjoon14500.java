package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14500 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int N;
    static int M;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        readLine();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        answer = 0;
        for (int i = 0; i < N; i++) {
            readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;

                // ㅗ 모양
                if(i > 0 && M-j >= 3){
                    int sum = 0;
                    sum += map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+1];
                    answer = answer > sum ? answer : sum;
                }
                // ㅜ 모양
                if(i < N-1 && M-j >= 3){
                    int sum = 0;
                    sum += map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                    answer = answer > sum ? answer : sum;
                }
                // ㅓ 모양
                if(j > 0 && N-i >= 3){
                    int sum = 0;
                    sum += map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j-1];
                    answer = answer > sum ? answer : sum;
                }
                // ㅏ 모양
                if(j < M-1 && N-i >= 3){
                    int sum = 0;
                    sum += map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
                    answer = answer > sum ? answer : sum;
                }
            }
        }
        System.out.println(answer);
    }

    /**
     *
     * @param x
     * @param y
     * @param sum
     * @param count
     * ㅗ 모양 이외 나머지 모양 dfs로 4칸 이동하였을 때 만들어지는 도형들
     */
    public static void dfs(int x, int y, int sum, int count) {
        if (count == 4) {
            //System.out.println("4개선택시" + "X=" + x + "  y=" + y+"   sum="+sum);
            answer = answer > sum ? answer : sum;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            int dist = count + 1;
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || visited[nextX][nextY]) {
                continue;
            }
            visited[nextX][nextY] = true;
            dfs(nextX, nextY, sum + map[nextX][nextY], dist);
            visited[nextX][nextY] = false;
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
