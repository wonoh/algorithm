package baekjoon;

import java.util.Scanner;


public class Baekjoon1003 {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=1;i<=T;i++) {
			int N = scan.nextInt();
			solution(N);
		}
	}
	public static void solution(int N) {
		dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i=2;i<=N;i++) {
			dp[i][0] = dp[i-2][0] + dp[i-1][0];
			dp[i][1] = dp[i-2][1] + dp[i-1][1];
		}
		System.out.println(dp[N][0]+" "+dp[N][1]);	
	}
}
