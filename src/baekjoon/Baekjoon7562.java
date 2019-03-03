package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -2, -1};
    static int[] dy = {1, 2, 2, 1, -1, -2, -1, -2};
    static Queue<Node> queue;
    static int N, X, Y;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            queue = new LinkedList<>();
            readLine();
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            queue.offer(new Node(startX, startY,0));
            visited[startX][startY] = true;
            readLine();
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            bfs();
        }

    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(now.x== X && now.y == Y){
                System.out.println(now.count);
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N){
                    continue;
                }
                if(!visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY,now.count+1));
                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
