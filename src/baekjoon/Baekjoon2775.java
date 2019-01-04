package baekjoon;

import java.util.Scanner;

public class Baekjoon2775 {
	static int[][] array;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i=1;i<=t;i++) {
			array = new int[15][15];
			for(int j=0;j<14;j++) {
				array[0][j] = j+1;
			}
			int k =scan.nextInt();
			int n = scan.nextInt();
			for(int x=1;x<=k;x++) {
				for(int y=0;y<=n;y++) {
					if(y==0) {
						array[x][y] = 1;
						continue;
					}
					array[x][y] = array[x-1][y] +array[x][y-1];
				}
			}
			System.out.println(array[k][n-1]);
		}
	}
}
