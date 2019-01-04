package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2822 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> Slist = new ArrayList<>();
		int[] result = new int[5];
		for(int i=0;i<8;i++) {
			list.add(scan.nextInt());
		}
		Slist = (ArrayList<Integer>) list.clone();
		Collections.sort(Slist);
		int n=0;
		int sum = 0;
		for(int j=7;j>=3;j--) {
			sum+=Slist.get(j);
			result[n] = list.indexOf(Slist.get(j)) + 1;
			n++;
		}
		Arrays.sort(result);
		System.out.println(sum);
		for(int x=0;x<5;x++) {
			System.out.print(result[x]+" ");
		}
	}
}
