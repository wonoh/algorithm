package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        map = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        map[i][j] = 0;
                    }else{
                        map[i][j] = 1;
                    }
                } else {
                    if (j % 2 ==0){
                        map[i][j] = 1;
                    }else{
                        map[i][j] = 0;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=0;i<8;i++){
            String line = br.readLine();
            for(int j=0;j<8;j++){
                if(line.charAt(j)=='F' && map[i][j]==0){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
