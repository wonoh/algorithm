package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 *
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
 *
 * 출력
 * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 */
public class Baekjoon9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] array = new int[12];
    public static void main(String[] args)throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int a=1;a<=T;a++){
            int n = Integer.parseInt(br.readLine());
            array = new int[n];
            if(n==1){
                System.out.println(1);
                continue;
            }
            if(n==2){
                System.out.println(2);
                continue;
            }
            array[0]=1;
            array[1]=2;
            array[2]=4;
            for(int i=3;i<n;i++){
                array[i]=array[i-3]+array[i-2]+array[i-1];
            }
            System.out.println(array[n-1]);
        }
    }
}
