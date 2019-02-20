package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Baekjoon10711 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int H;
    static int W;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Vector<Node> vector;
    static Queue<Node> queue;
    public static void main(String[] args) throws IOException {
        readLine();
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        vector = new Vector<>();
        queue = new LinkedList<>();
        int time = 0;
        for (int i = 0; i < H; i++) {
            String[] splitArray = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                if (!splitArray[j].equalsIgnoreCase(".")) {
                    map[i][j] = Integer.parseInt(splitArray[j]);
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) {
                    find(i, j);
                }
            }
        }
        if (vector.size() == 0) {
            System.out.println(time);
            return;
        }
        time++;
        addQueue();
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node now = queue.poll();
                int sum = 0;
                for (int h = 0; h < 8; h++) {
                    int nextX = now.x + dx[h];
                    int nextY = now.y + dy[h];
                    if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) {
                        continue;
                    }
                    if (map[nextX][nextY] == 0) {
                        sum++;
                    }
                }
                if (sum >= map[now.x][now.y]) {
                    if (vector.size() == 0) {
                        vector.add(now);
                    } else {
                        boolean flag = false;
                        for (int z = 0; z < vector.size(); z++) {
                            if (now.x == vector.get(z).x && now.y == vector.get(z).y) {
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            vector.add(now);
                        }
                    }
                }
            }
            if (vector.size() > 0) {
                addQueue();
            }else{
                break;
            }
            time++;
        }
        System.out.println(time);
    }
    public static void addQueue() {
        for (Node node : vector) {
            map[node.x][node.y] = 0;
        }
        for (Node node : vector) {
            for (int i = 0; i < 8; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) {
                    continue;
                }
                if (map[nextX][nextY] != 0) {
                        queue.offer(new Node(nextX, nextY));
                }
            }
        }
        vector.clear();
    }
    public static void find(int x, int y) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) {
                continue;
            }
            if (map[nextX][nextY] == 0) {
                sum++;
            }
        }
        if (sum >= map[x][y]) {
            vector.add(new Node(x, y));
        }
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
