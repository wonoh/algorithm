package swacademy;


import java.util.Scanner;

public class SA1206 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int n = scan.nextInt();
			int[] array = new int[n+4];
			for(int j=2;j<n+2;j++) {
				array[j]=scan.nextInt();
			}
			int count = 0;
			for(int x=2;x<n+2;x++) {
				if(array[x] > array[x-1] && array[x] > array[x-2] && array[x] > array[x+1] && array[x] > array[x+2]) {
					int max = Math.max(Math.max(array[x-1],array[x-2]),Math.max(array[x+1],array[x+2]));
					count += array[x]-max;
				}
			}
			System.out.println("#"+i+" "+count);
		}
	}
}
