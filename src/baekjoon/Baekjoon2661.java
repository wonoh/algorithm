package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2661 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        find("");
    }
    public static void find(String s){
        if(s.length() == N){
            System.out.println(s);
            System.exit(0);
        }
        for (int n = 1; n <= 3 ; n++) {
            boolean flag = true;
            String newString = s+n;
            loop:for (int i = 1; i <= newString.length()/2 ; i++) {
                for (int j = 0; j < newString.length() ; j++) {
                    int end = j+i;
                    if(end+i > newString.length()){
                        break;
                    }
                    if(newString.substring(j,end).equalsIgnoreCase(newString.substring(end,end+i))){
                        flag = false;
                        break loop;
                    }
                }
            }
            if(flag){
                find(newString);
            }
        }

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
