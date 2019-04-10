package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1051 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int max,row,col;
    static int[][] map;
    public static void main(String[] args) throws IOException  {
        readLine();

        max = 1;

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i <row ; i++) {
            String[] input =br.readLine().split("");
            for (int j = 0; j <col ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(i,j,1);
            }
        }
        //System.out.println(Arrays.deepToString(map));
        System.out.println(max);

    }
    public static void find(int x,int y,int depth){
        int start = map[x][y];
        if(x+depth >= row || y+depth >= col){
            return;
        }
        if(start == map[x+depth][y] &&
                start == map[x][y+depth] &&
                start == map[x+depth][y+depth]){
            max = Math.max(max,(depth+1) * (depth+1));
            //System.out.println("max 갱신"+max);
        }
        if(depth+1 >= row || depth+1 >= col){
            return;
        }
        find(x,y,depth+1);
    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
