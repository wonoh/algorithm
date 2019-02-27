package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2583 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M,N,K,area;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        readLine();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        result = new ArrayList<>();
        K = Integer.parseInt(st.nextToken());
        for(int i=0;i<K;i++){
            readLine();
            int leftY = Integer.parseInt(st.nextToken());
            int leftX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int startX = 0;
            int endX = 0;
            if(leftY < rightY){
                startX = leftY;
                endX = rightY;
            }else{
                startX = rightY;
                endX = leftY;
            }
            int startY = 0;
            int endY = 0;
            if(leftX < rightX){
                startY = leftX;
                endY = rightX;
            }else{
                startY = rightX;
                endY = leftX;
            }
            for(int x=startY;x<endY;x++){
                for(int y=startX;y<endX;y++){
                    if(map[x][y]==1){
                        continue;
                    }
                    map[x][y] = 1;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0 && !visited[i][j]){
                    visited[i][j] = true;
                    area = 1;
                    result.add(dfs(i,j));
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int val:result){
            System.out.print(val+" ");
        }
    }
    public static int dfs(int x,int y){
        for(int i=0;i<4;i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N){
                continue;
            }
            if(!visited[nextX][nextY] && map[nextX][nextY] == 0){
                visited[nextX][nextY] = true;
                area++;
                dfs(nextX,nextY);
            }
        }
        return area;

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
