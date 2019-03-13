package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon2210 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static HashMap<String,Integer> hashMap;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        map = new int[5][5];
        hashMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                find(i,j,"");
            }

        }
        System.out.println(hashMap.size());
    }

    public static void find(int x,int y,String s) {
        if(s.length() == 6){
            hashMap.put(s,0);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx > 4 || ny > 4){
                continue;
            }
            find(nx, ny, s + map[nx][ny]);
        }

    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
