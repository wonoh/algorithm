package swacademy;

import java.util.Scanner;

public class SA1209 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int n = scan.nextInt();
			int[][] array = new int[100][100];
			for(int x=0;x<100;x++) {
				for(int y=0;y<100;y++) {
					array[x][y] = scan.nextInt();
				}
			}
			int rowMax = 0;
			int colMax = 0;
			int fcrossMax = 0;
			for(int x=0;x<100;x++) {
				int rowSum = 0;
				int colSum = 0;
				for(int y=0;y<100;y++) {
					if(x==y) {
						fcrossMax+=array[x][y];
					}
					rowSum+= array[x][y];
					colSum+= array[y][x];
				}
				rowMax = Math.max(rowSum,rowMax);
				colMax = Math.max(colSum,colMax);
			}
			int rowIndex = 0;
			int colIndex = 99;
			int scrossMax=0;
			while(rowIndex<100 && colIndex >=0) {
				scrossMax+=array[rowIndex][colIndex];
				rowIndex++;
				colIndex--;
			}
			int crossMax = Math.max(scrossMax,fcrossMax);
			int result = Math.max(crossMax,Math.max(rowMax,colMax));
			System.out.println("#"+i+" "+result);	
		}

	}

}
