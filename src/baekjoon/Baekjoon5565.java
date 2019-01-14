package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args)throws IOException {
        int sumPrice = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=0;i<9;i++){
            sum+=Integer.parseInt(br.readLine());
        }
        System.out.println(sumPrice-sum);
    }
}
