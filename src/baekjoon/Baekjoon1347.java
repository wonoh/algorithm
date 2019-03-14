package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1347 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int N;
    static char[] input;
    public static void main(String[] args) throws IOException {
        map = new int[100][100];
        N= Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        int direction = 1; // 1 남 4 동 3 북 2 서
        int x =50;
        int y =50;
        map[50][50] =1;
        for (int i = 0; i < N; i++) {
            if(input[i] == 'R'){
                direction++;
                if(direction==5){
                    direction=1;
                }
            }else if(input[i] =='L'){
                direction--;
                if(direction==0){
                    direction=4;
                }
            }else{
                if(direction==1){
                    x++;
                }else if(direction==2){
                    y--;
                }else if(direction==3){
                    x--;
                }else{
                    y++;
                }
                map[x][y] = 1;
            }
        }
        int startx = Integer.MAX_VALUE;
        int starty=Integer.MAX_VALUE;
        int endx=Integer.MIN_VALUE;
        int endy=Integer.MIN_VALUE;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                 if(map[i][j]==1){
                     startx = Math.min(startx,i);
                     starty = Math.min(starty,j);
                     endx = Math.max(endx,i);
                     endy = Math.max(endy,j);
                 }
            }
        }
        for (int i = startx; i <= endx ; i++) {
            for (int j = starty; j <= endy ; j++) {
                if(map[i][j]==1){
                    System.out.print('.');
                }else{
                    System.out.print('#');
                }
            }
            System.out.println();
        }

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
