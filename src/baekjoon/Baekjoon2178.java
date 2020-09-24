package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2178 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] selected;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        map = new int[n][m];
        selected = new boolean[n][m];
        for (int i = 0; i < n ; i++) {
            String[] split1 = br.readLine().split("");
            for (int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(split1[j]);
            }
        }
        queue.offer(new Node(0,0));
        selected[0][0] = true;
        find();
    }

    public static int find(){
        int result = 0;
        while(!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                if(poll.x == n-1 && poll.y == m-1){
                    System.out.println(result);
                }
                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || selected[nx][ny]){
                        continue;
                    }
                    if(map[nx][ny] == 1){
                        selected[nx][ny] = true;
                        queue.offer(new Node(nx,ny));
                    }
                }
            }
        }
        return result;
    }
    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



}
