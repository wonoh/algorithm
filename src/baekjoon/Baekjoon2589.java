package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2589 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int H,W;
    static int[][] map;
    static Queue<Node> queue;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        readLine();
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] splitArray = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                if(splitArray[j].equalsIgnoreCase("W")){
                    map[i][j] = 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j]==0){
                    max = Math.max(bfs(i,j),max);
                }
            }
        }
        System.out.println(max);

    }
    public static int bfs(int x,int y){
        queue = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        queue.offer(new Node(x,y,0));
        visited[x][y] = true;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int dist = now.dist;
            max = Math.max(max,dist);
            for(int i=0;i<4;i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(nextX <0 || nextY < 0 || nextX >= H || nextY >= W){
                    continue;
                }
                if(!visited[nextX][nextY] && map[nextX][nextY] == 0){
                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX,nextY,now.dist+1));
                }
            }
        }
        return max;


    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
    private static class Node{
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
