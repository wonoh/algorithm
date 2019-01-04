package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1932 {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arrays;
	static int[] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n =Integer.parseInt(br.readLine());
		arrays = new int[n][];
		for(int i=0;i<n;i++) {
			array = new int[i+1];
			String line = br.readLine();
			st = new StringTokenizer(line," ");
			for(int j=0;j<i+1;j++) {
				array[j] = (Integer.parseInt(st.nextToken()));
			}
			arrays[i] = array;
		}
		for(int x=n-2;x>=0;x--) {
			for(int y=0;y<arrays[x].length;y++) {
				int max = Math.max(arrays[x+1][y],arrays[x+1][y+1]);
				arrays[x][y] += max;
			}
		}
		System.out.println(arrays[0][0]);
	}
}
