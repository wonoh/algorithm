package swacademy;

import java.util.Scanner;

public class SA2071 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			double sum = 0;
			for(int j=0;j<10;j++) {
				sum += scan.nextInt();
			}
			System.out.println("#"+i+" "+Math.round(sum/10));	
		}

	}

}
