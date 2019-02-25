package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1600 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K;
    static int W;
    static int H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] kdx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] kdy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        readLine();
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0][0] = true;
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0,0));
        while (!queue.isEmpty()) {
                Node now = queue.poll();
                int x = now.x;
                int y = now.y;
                int count = now.count;
                int time = now.time;
                if (x == H - 1 && y == W - 1) {
                    return time;
                }
                if(count < K){
                    for(int j=0;j<8;j++){
                        int nextX = x+kdx[j];
                        int nextY = y+kdy[j];
                        if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W || map[nextX][nextY] == 1) {
                            continue;
                        }
                        if(!visited[nextX][nextY][count+1]){
                            visited[nextX][nextY][count+1] = true;
                            queue.offer(new Node(nextX,nextY,count+1,time+1));
                        }
                    }
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dx[j];
                    int nextY = y + dy[j];
                    if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W || map[nextX][nextY] == 1) {
                        continue;
                    }
                    if (!visited[nextX][nextY][count]) {
                        visited[nextX][nextY][count] = true;
                        queue.offer(new Node(nextX, nextY, count,time+1));
                    }
                }
        }
        return -1;
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

    static class Node {
        int x;
        int y;
        int count;
        int time;

        public Node(int x, int y, int count, int time) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    ", time=" + time +
                    '}';
        }
    }

}
