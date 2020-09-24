package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15650 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int m;
    private static boolean[] selected;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] split = s.split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        selected = new boolean[n];
        array = new int[m];
        find(0,0);
    }
    public static void find(int count, int start){
        if(count == m ){
            return;
        }
        for (int i = start; i < n ; i++) {
            if(!selected[i]){
                selected[i] = true;
                find(count+1,start+1);
                selected[i] = false;
            }
        }
    }

}
