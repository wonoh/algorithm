package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Node> queue;
    static boolean[][] visited;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs();

    }

    public static void bfs() {
        queue.offer(new Node(x, y, 2, 0, 0));
        visited[x][y] = true;
        int result = 0;
        while (!queue.isEmpty()) {
            int targetX = Integer.MAX_VALUE;
            int targetY = Integer.MAX_VALUE;
            int eat = 0;
            int move = 0;
            int size = 0;
            int qSize = queue.size();
            System.out.println(queue.toString());
            for (int j = 0; j < qSize; j++) {
                Node now = queue.poll();
                System.out.println(now.toString());
                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                        continue;
                    }
                    if (now.size < map[nextX][nextY] || visited[nextX][nextY]) {
                        continue;
                    }
                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, now.size, now.eat, now.move + 1));
                    if (map[nextX][nextY] != 0 && map[nextX][nextY] < now.size) {
                        if(nextX < targetX){
                            targetX = nextX;
                            targetY = nextY;
                            eat = now.eat;
                            size = now.size;
                            move = now.move + 1;
                        }else if(nextX==targetX){
                            if(nextY < targetY){
                                targetX = nextX;
                                targetY = nextY;
                                eat = now.eat;
                                size = now.size;
                                move = now.move + 1;
                            }
                        }
                    }
                }
            }
            if(targetX!=Integer.MAX_VALUE){
                System.out.println("asd");
                eat++;
                if(eat==size){
                    size++;
                    eat = 0;
                }
                map[x][y] = 0;
                map[targetX][targetY] = 9;
                result += move;
                x = targetX;
                y = targetY;
                for(int i=0;i<N;i++){
                    Arrays.fill(visited[i],false);
                }
                queue.clear();
                visited[targetX][targetY] = true;
                queue.offer(new Node(targetX,targetY,size,eat,0));
            }
        }
        System.out.println(result);


    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

    static class Node {
        int x;
        int y;
        int size;
        int eat;
        int move;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", size=" + size +
                    ", eat=" + eat +
                    ", move=" + move +
                    '}';
        }

        public Node(int x, int y, int size, int eat, int move) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
            this.move = move;
        }
    }
}
