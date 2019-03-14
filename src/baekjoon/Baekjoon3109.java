package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C,answer;
    static char[][] map;
    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};
    public static void main(String[] args) throws IOException {
        readLine();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        answer = 0;
        for (int i = 0; i <R ; i++) {
            answer+=dfs(i,0);
        }
        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if(y==C-1){
            return 1;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                continue;
            }
            if(map[nx][ny] =='x'){
                continue;
            }
            if(map[nx][ny] == '.'){
                map[nx][ny] = '=';
                if(dfs(nx,ny)==1){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
