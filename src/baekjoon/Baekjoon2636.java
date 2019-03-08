package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2636 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, time,cheeze;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        readLine();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        time = 0;
        cheeze = 0;
        initAir();
        while (true) {
            getAir();
            System.out.println("가장자리 구한 후 맵상태");
            for(int i=0;i<N;i++){
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println();
            int size = 0;
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 3 && !visited[i][j]) {
                        size += bfs(i,j,visited);
                    }
                }
            }
            System.out.println("bfs 후 맵상태");
            System.out.println(time+"지난후 치즈 갯수"+size);
            for(int i=0;i<N;i++){
                System.out.println(Arrays.toString(map[i]));
            }
            if(size == 0){
                break;
            }
            time++;
            cheeze = size;
        }
        System.out.println(time);
        System.out.println(cheeze);
        //System.out.println(cheeze+" ----  "+time);

    }

    public static int bfs(int x, int y,boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            map[now.x][now.y] = -1;
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny] == 3){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx,ny));
                }
            }
            count++;
        }
        return count;

    }
    public static void getAir(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == -1) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 3;
                }
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    map[nx][ny] = -1;
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }
    public static void initAir() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            map[now.x][now.y] = -1;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 3;
                }
            }
        }


    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }
}
