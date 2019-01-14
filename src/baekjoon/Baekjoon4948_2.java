package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 * <p>
 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
 * <p>
 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
 * <p>
 * n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하며, 한 줄로 이루어져 있다. (n ≤ 123456)
 * <p>
 * 입력의 마지막에는 0이 주어진다.
 * <p>
 * 출력
 * 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 */
public class Baekjoon4948_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[MAX+1];
        for(int i=2;i<MAX;i++){
            isPrime[i]=true; // 모두 true 로 초기화
        }
        for(int i=2;i<MAX;i++){
            for(int j=i*2;j<MAX;j+=i){ //2부터 늘려가면서 자기의 배수는 소수가아니기 때문
                if(!isPrime[j]) //이미 소수가 아니라면 지나감
                    continue;
                isPrime[j] = false;
            }
        }
       while(true){
           int num = Integer.parseInt(br.readLine());

           if(num==0){
               break; //종료되는 시점
           }
           int count = 0;
           for(int i=num+1;i<=num*2;i++){
                if(isPrime[i]){
                    count++;
                }
           }
           System.out.println(count);

       }

    }
}
