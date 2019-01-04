package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SUSHI {
	static int n;
	static int m;
	static int[][] array;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for(int i=1;i<=c;i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			m /= 100;
			array = new int[n][2];
			for(int j=0;j<n;j++) {
				String line2 = br.readLine();
				StringTokenizer st2 = new StringTokenizer(line2, " ");
				array[j][0]=Integer.parseInt(st2.nextToken());
				array[j][1]=Integer.parseInt(st2.nextToken());
				array[j][0] /= 100;
			}
			dp = new int[201];
			for(int x=0;x<m;x++) {
				for(int y=0;y<n;y++) {
		                dp[(x + array[y][0]) % 201] = Math.max(dp[x % 201] + array[y][1] , dp[(x + array[y][0]) % 201]); 
				}
			}
			System.out.println(dp[m%201]);
		}
	}
}
