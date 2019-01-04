package baekjoon;

import java.util.Scanner;

public class Beakjoon3040 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = new int[9];
		for(int i=0;i<9;i++) {
			array[i]=scan.nextInt();
		}
		int sum = 0;
		for(int v:array){
			sum+=v;
		}
		int f=0;
		int s=0;
		for(int x=0;x<array.length;x++) {
			for(int y=x+1;y<array.length;y++) {
				int first =array[x];
				int second = array[y];
				if(sum-(first+second)==100) {
					f=x;
					s=y;
				}
			}
		}
		for(int k=0;k<array.length;k++) {
			if(k!=f && k!=s) {
				System.out.println(array[k]);
			}
		}
	}
}
