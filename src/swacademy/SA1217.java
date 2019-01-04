package swacademy;

import java.util.Scanner;

public class SA1217 {
	static int result = 1;
	public static int pow(int n,int m) {
		 if(m>1) {
			 result*=n;
			 m--;
			 pow(n,m);
		 }		
         return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 2;
		for (int i = 1; i <= T; i++) {
			int testNum = scan.nextInt();
			int n =scan.nextInt();
			int m =scan.nextInt();
			result = n;
			int result = pow(n,m);
			System.out.println("#"+i+" "+result);
		}
	}
}
