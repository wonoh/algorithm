package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] stairs;
    static int[] dp;
    static boolean[] step;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        int a[] = new int[n+1];
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = a[1];
        if(n >= 2) dp[2] = dp[1]+a[2];

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2]+a[i],dp[i-3]+a[i-1]+a[i]);
        }
        System.out.println(dp[n]);
    }
}
