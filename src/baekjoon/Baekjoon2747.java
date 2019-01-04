package baekjoon;

import java.util.Scanner;

public class Baekjoon2747 {
	static int[] numArray;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		numArray = new int[46];
		numArray[0]=0;
		numArray[1]=1;
		for(int i=2;i<=n;i++) {
			numArray[i] = numArray[i-2]+numArray[i-1];
		}
		System.out.println(numArray[n]);
	}
}
