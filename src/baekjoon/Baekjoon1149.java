package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1149 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] homeArray;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		solution(N);
		
	}
	public static void solution(int N) throws IOException {
		homeArray = new int[N][3];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			st = new StringTokenizer(line," ");
			homeArray[i][0] = Integer.parseInt(st.nextToken());
			homeArray[i][1] = Integer.parseInt(st.nextToken());
			homeArray[i][2] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][3];
		dp[0][0] = homeArray[0][0];
		dp[0][1] = homeArray[0][1];
		dp[0][2] = homeArray[0][2];
		
		for(int i=1;i<N;i++) {
			dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + homeArray[i][0];
			dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + homeArray[i][1];
			dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + homeArray[i][2];
		}
		Arrays.sort(dp[N-1]);
		System.out.println(dp[N-1][0]);
	}
	public static int min(int a,int b) {
		return a < b ? a: b;
	}
}
