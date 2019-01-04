package algospot;

import java.util.Scanner;

public class HELLOWORLD {
	static int C;
	static String[] array;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		C = scan.nextInt();
		array = new String[C];
		for(int i=0;i<C;i++) {
			array[i] = scan.next();
		}
		for(String s:array) {
			System.out.println("Hello,"+" "+s+"!");
		}
	}
}
