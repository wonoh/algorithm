package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author wonoh
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.
 *
 * 출력
 * 첫째 줄에 N!을 출력한다.
 */
public class Baekjoon10872 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n)); //재귀
//        if(n==0){  동적 계획법
//            System.out.println(1);
//        }else{
//            int[] array = new int[n + 1];
//            array[1] = 1;
//            for(int i=1;i<=n;i++){
//                array[i] = array[i-1] * i;
//            }
//            System.out.println(array[n]);
//        }
    }
    private static int factorial(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
