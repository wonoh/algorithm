package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int X[] = {1, 0, -1, 0};
    static final int Y[] = {0, 1, 0, -1};
    static int[][] map;
    static Queue<Position> queue;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        readLine();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new LinkedList<>();
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        queue.offer(new Position(0, 0, 0));
        int step = 0;
        boolean flag = false;
        visited[0][0][0] = true;
        loop:while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Position visit = queue.poll();
                int x = visit.x;
                int y = visit.y;
                int crashed = visit.crashed;
                if (x == N - 1 && y == M - 1) {
                    flag = true;
                    break loop;
                }
                for (int i = 0; i < 4; i++) { //상하 좌우 탐색
                    int nextX = x + X[i];
                    int nextY = y + Y[i];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                        continue;
                    }
                    //System.out.println("다음x=>"+x+"  다음y=>"+y);
                    if (map[nextX][nextY] == 1) { // 벽
                        if(crashed == 0 && !visited[nextX][nextY][1]){
                            visited[nextX][nextY][1] = true;
                            queue.offer(new Position(nextX, nextY, 1));
                        }
                    } else {
                        if(!visited[nextX][nextY][crashed]){
                            visited[nextX][nextY][crashed] = true;
                            queue.offer(new Position(nextX, nextY, crashed));
                        }
                    }
                }
            }
        }
        if (flag) {
            System.out.println(step);
        } else {
            System.out.println(-1);
        }

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
class Position {
    int x;
    int y;
    int crashed;

    public Position(int x, int y, int crashed) {
        this.x = x;
        this.y = y;
        this.crashed = crashed;
    }
}
