package swacademy;

import java.util.Scanner;

public class SA1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cost = new int[1000001];
		int testcase = sc.nextInt();
		for (int i = 1; i <= testcase; i++) {
			int max = 0;
			long maxMargin = 0;
			int N = sc.nextInt();
			for (int j = 0; j < N; j++) {
				cost[j] = sc.nextInt();
			}
			max = cost[N - 1];
			for (int m = N - 2; m >= 0; m--) {
				if (max > cost[m]) {
					maxMargin += max - cost[m];
				} else {
					max = cost[m];
				} 
			}
			System.out.println("#" + i + " " + maxMargin);
		}
	}

}
