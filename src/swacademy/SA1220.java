package swacademy;


import java.util.Scanner;

public class SA1220 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int n = scan.nextInt();
			int[][] array = new int[n][n];
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					array[y][x] = scan.nextInt();
				}
			}
			int count = 0;
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n - 1; y++) {
					if (array[x][y] == 1) {
						for (int k = y + 1; k < n; k++) {
							if (array[x][k] == 2) {
								count++;
								array[x][k] = -1;
								y=k;
								break;
							}
						}
					} else if (array[x][y] == 2) {
						if(y!=0) {
							for(int k=y-1;k>=0;k--) {
								if(array[x][k]==-1) {
									break;
								}
								if(array[x][k]==1) {
									count++;
									array[x][k] = -1;
									break;
								}
							}
						}

					}
				}
			}
			System.out.println("#" + i + " " + count);
		}
	}
}
