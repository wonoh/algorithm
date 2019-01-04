package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1159 {
	static int[] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		char a='a';
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		array = new int[30];
		StringBuilder result = new StringBuilder();
		for(int i=0;i<n;i++) {
			 array[br.readLine().charAt(0)-97]++;
		}
		System.out.println(Arrays.toString(array));
		for(int i=0;i<array.length;i++) {
			if(array[i]>=5) {
				result.append((char)(i+97));
			}
		}
		if(result.length()==0) {
			System.out.println("PREDAJA");
		}else {
			System.out.println(result.toString());			
		}
	}
}
