package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int W,H;
    static int[][] map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        while(true){
            readLine();
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if(W==0 && H==0){
                break;
            }
            map = new int[H][W];
            for(int i=0;i<H;i++){
                readLine();
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            boolean[][] visited = new boolean[H][W];
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        bfs(i,j,visited);
                        answer++;
                    }
                }
            }
            System.out.println(answer);

        }
    }

    public static void bfs(int x, int y,boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Node(x,y));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0;i<8;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= H || ny >= W){
                    continue;
                }
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx,ny));
                }
            }
        }

    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
