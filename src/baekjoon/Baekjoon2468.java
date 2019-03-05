package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,min,max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        map  = new int[N][N];
        for(int i=0;i<N;i++){
            readLine();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min,map[i][j]);
                max = Math.max(max,map[i][j]);
            }
        }
        int answer = 0;
        for(int i=0;i<=100;i++){
        int safe = 0;
            visited = new boolean[N][N];
            for(int x=0;x<N;x++){
                for(int y=0;y<N;y++){
                    if(!visited[x][y] && map[x][y] > i ){
                        dfs(x,y,i);
                        safe++;
                    }
                }
            }
            answer = Math.max(answer,safe);
        }
        /*int zero = 0;
        visited = new boolean[N][N];
        for(int x=0;x<N;x++){
            for(int y=0;y<N;y++){
                if(!visited[x][y] && map[x][y] > 0 ){
                    dfs(x,y,0);
                    zero++;
                }
            }
        }*/
        System.out.println(answer);
    }
    public static void dfs(int x,int y,int count){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                continue;
            }
            if(!visited[nx][ny] && map[nx][ny] > count){
                visited[nx][ny] = true;
                dfs(nx,ny,count);
            }
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
