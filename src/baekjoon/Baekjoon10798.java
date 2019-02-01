package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10798 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[5][15];
    public static void main(String[] args) throws IOException {
        for(int i=0;i<5;i++){
            String line = br.readLine();
            for(int j=0;j<line.length();j++){
                board[i][j] = (int)line.charAt(j);
            }
        }
        StringBuilder result = new StringBuilder();
        System.out.println(Arrays.deepToString(board));
        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++){
                if(board[j][i]==0){
                    continue;
                }
                result.append((char)board[j][i]);
            }
        }
        System.out.println(result.toString());
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
