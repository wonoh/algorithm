package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 *
 *
 * [입력]
 *
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 *
 * 각 테스트 케이스의 첫 번째 줄에는 2개의 자연수 N(1 ≤ N ≤ 20)과 K(1 ≤ K ≤ 1000)가 주어진다.
 *
 * 두 번째 줄에는 N개의 자연수 수열 A가 주어진다. 수열의 원소인 N개의 자연수는 공백을 사이에 두고 주어지며, 1 이상 100 이하임이 보장된다.
 *
 *
 * [출력]
 *
 * 각 테스트 케이스마다 ‘#x ’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 부분 수열의 합이 K가 되는 경우의 수를 출력한다.
 */
//다시 풀어봐야ㅕ함
public class SA2817 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int count;
    static int m;
    static int[] array;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++){
            st = new StringTokenizer(br.readLine()," ");
            int length = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            count = 0;
            array = new int[length];
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<length;j++){
                int number = Integer.parseInt(st.nextToken());
                array[j]=number;
            }
            find(0,0);
            System.out.println("#"+i+" "+count);
        }
    }
    public static void find(int index,int sum){
        if(sum>m || index>=array.length){
            if(sum==m){
                count++;
            }
            return;
        }
        find(index+1,sum+array[index]);
        find(index+1,sum);
    }
}
