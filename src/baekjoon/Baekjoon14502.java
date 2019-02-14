package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] map;
    static int[][] temp;
    static Queue<Node> queue;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        readLine();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        map = new int[N][M];
        for(int i=0;i<N;i++){
            readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    temp = new int[N][M];
                    for(int x=0;x<N;x++){
                        for(int y=0;y<M;y++){
                            temp[x][y] = map[x][y];
                        }
                    }
                    temp[i][j] = 1;
                    dfs(1);
                    temp[i][j] = 0;
                }
            }
        }
        System.out.println(max);


    }
    public static void dfs(int count){
            if(count==3){ //벽 3개 세운경우
                mutation();
                return;
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(temp[i][j]==0){
                        temp[i][j] = 1;
                        dfs(count+1);
                        temp[i][j] = 0;
                    }
                }
            }

    }
    static class Node{
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
    public static void mutation(){

        Queue<Node> queue = new LinkedList<>();
        int[][] afterMutation = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                afterMutation[i][j] = temp[i][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(afterMutation[i][j]==2){
                    queue.offer(new Node(i,j));
                }
            }
        }
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0;i<4;i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >=M){
                    continue;
                }
                if(afterMutation[nextX][nextY]==0){
                    afterMutation[nextX][nextY] = -1;
                    queue.offer(new Node(nextX,nextY));
                }
            }
        }
        int safe = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(afterMutation[i][j]==0){
                    safe++;
                }
            }
        }
        max = max > safe ? max : safe;


    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
