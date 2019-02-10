package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        readLine();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (getSum() == N * M) {
            System.out.println(0);
        } else {
            bfs();
        }

    }

    public static void bfs() {
        int day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    Node node = new Node(i, j);
                    queue.offer(node);
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Node node = queue.poll();
                int x = node.x;
                int y = node.y;
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                        continue;
                    }

                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = 1;
                        queue.add(new Node(nextX, nextY));
                    }
                }
            }
                day++;
        }
        if (getSum() == N * M) {
            System.out.println(day-1);
        } else {
            System.out.println(-1);
        }
    }

    public static int getSum() {
        int exist = 0;
        int notExist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    notExist++;
                } else if (map[i][j] == 1) {
                    exist++;
                }
            }
        }
        return exist + notExist;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
