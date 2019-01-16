package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * 출력
 * 주어진 수들 중 소수의 개수를 출력한다.
 */
public class Baekjoon1978 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] isPrime = new boolean[1001];
    public static void main(String[] args)throws IOException {
        for(int i=2;i<isPrime.length;i++){
            isPrime[i]=true;
        }
        for(int i=2;i<isPrime.length;i++){ //2부터 들어올수 있는 입력의 최대값까지 자신의 배수에 false 이미 false 라면 지나감
            for(int j=i*2;j<isPrime.length;j+=i){
                if(!isPrime[j])
                    continue;
                isPrime[j]=false;
            }
        }
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," " );
        int primeCount = 0;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(isPrime[num]){
                primeCount++;
            }
        }
        System.out.println(primeCount);

    }

}
