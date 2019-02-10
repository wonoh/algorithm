package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 완전 탐색 예제
 */
public class Baekjoon1065 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0 ;
        if(n > 99){
            for (int i = 100; i <= n; i++) {
                String[] split = String.valueOf(i).split("");
                if(Integer.parseInt(split[1])-Integer.parseInt(split[0]) == Integer.parseInt(split[2])-Integer.parseInt(split[1])){
                    answer++;
                }
            }
        }else{// 1 ~ 99 까지는 모두 등차수열
            System.out.println(n);
            return;
        }
        System.out.println(answer+99);
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
