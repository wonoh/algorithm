package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
 * <p>
 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
 * <p>
 * 입력
 * 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 * <p>
 * 출력
 * 첫째 줄에 답을 출력한다.
 */
public class Baekjoon1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        dp = new int[n];
        int index = 0;
        while (st.hasMoreTokens()) {
            array[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        dp[0]=array[0];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            dp[i+1] = Math.max(dp[i]+array[i+1],array[i+1]); // 연속합을 찾기위한 비교
        }
        System.out.println(Arrays.toString(dp));
        for(int value:dp){
            max = Math.max(max,value);
        }
        System.out.println(max);
    }
}
