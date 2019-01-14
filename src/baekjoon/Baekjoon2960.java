package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
 *
 * 이 알고리즘은 다음과 같다.
 *
 * 2부터 N까지 모든 정수를 적는다.
 * 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
 * P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
 * 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
 * N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(2, K) < N ≤ 1000)
 *
 * 출력
 * 첫째 줄에 K번째 지워진 수를 출력한다.
 */
public class Baekjoon2960 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] isPrime;
    static final int MAX=1000;
    static int[] array;
    public static void main(String[] args)throws IOException {
        getPrimeArray();
        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        initArray(n);
        int count =0;
        loop:while(true){
            for(int i=0;i<array.length;i++){
                if(array[i]==-1){
                    continue;
                }
                if(isPrime[array[i]]){ //소수라면
                    int num =array[i];
                    for(int j=i;j<array.length;j+=num){
                        if(array[j]==-1){
                            continue;
                        }
                        if(count+1==k){
                            System.out.println(array[j]);
                            break loop;
                        }
                        array[j]=-1;
                        count++;
                    }
                }
            }
        }
    }
    public static void getPrimeArray(){
        isPrime = new boolean[MAX+1];
        for(int i=2;i<=MAX;i++){
            isPrime[i]=true;
        }
        for(int i=2;i<=MAX;i++){
            for(int j=i*2;j<=MAX;j+=i){
                if(!isPrime[j])
                    continue;
                isPrime[j]=false;
            }
        }
    }
    public static void initArray(int n){
        array = new int[n-1];
        int index = 0;
        for(int i=2;i<=n;i++){
            array[index]=i;
            index++;
        }
    }
}
