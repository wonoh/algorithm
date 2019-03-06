package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1789 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long N,result;
    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        result = 0;
        long sum = 0;
        for(int i=1;i<=N;i++){
            sum += i;
            result++;
            if(sum > N){
                result--;
                break;
            }
        }
        System.out.println(result);

    }



    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
