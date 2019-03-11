package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2638 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Node> removeList;
    public static void main(String[] args) throws IOException {
        readLine();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       /* for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(map[i]));
        }*/
        int time = 0;
        while(true){
           init();
           /*    System.out.println("외부공기 구한후 맵");
           for(int i=0;i<N;i++){
               System.out.println(Arrays.toString(map[i]));
           }*/
            removeList = new ArrayList<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j] == 1){
                       setRemoveCheeze(i,j);
                    }
                }
            }
            //System.out.println(removeList.toString());
            if(removeList.size()==0){
                break;
            }
            for(Node n : removeList){
                map[n.x][n.y] = -1;
            }
          /*      System.out.println("치즈 녹인 후 맵");
            for(int i=0;i<N;i++){
                System.out.println(Arrays.toString(map[i]));
            }*/
            time++;
            //System.out.println("남은 치즈"+cheeze);

        }
        System.out.println(time);
        /*for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(map[i]));
        }*/

    }
    public static void setRemoveCheeze(int x,int y){
            int count = 0;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(map[nx][ny] == -1){
                    count++;
                }
            }
            if(count >= 2){
                removeList.add(new Node(x,y));
            }
    }
    public static void init() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new Node(0,0));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            map[now.x][now.y] = -1;
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if((map[nx][ny] == -1 || map[nx][ny] == 0) && !visited[nx][ny]){
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

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
