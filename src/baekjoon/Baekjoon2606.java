package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon2606 {
    
    static int com;
    static int con;
    static boolean[][] map;
    static int count = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        com = scan.nextInt();
        con = scan.nextInt();

        map = new boolean[com+1][com+1];
        visited =  new boolean[com+1];

        for (int i = 0; i < con; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            map[a][b] = map[b][a] = true;
        }
        dfs(1);
        System.out.println(count);

    }
    public static void dfs(int start){
        visited[start] = true;
        for (int i = 1; i <= com ; i++) {
            if(map[start][i] && !visited[i]){
                count++;
                dfs(i);
            }
        }
    }

}
