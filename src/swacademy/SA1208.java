package swacademy;

import java.util.Arrays;
import java.util.Scanner;

public class SA1208 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int n = scan.nextInt();
			int[] array = new int[100];
			for(int j=0;j<100;j++) {
				array[j]=scan.nextInt();
			}
			while(true) {
				Arrays.sort(array);
				array[99]-=1;
				array[0]+=1;
				n--;
				if(n==0) {
					break;
				}
			}
			Arrays.sort(array);
			int dif = array[array.length-1]-array[0];
			System.out.println("#"+i+" "+dif);	
		}
	}
}
