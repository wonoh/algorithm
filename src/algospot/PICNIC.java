package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PICNIC {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int m;
	static boolean[][] friends;
	static boolean[] students;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int C = Integer.parseInt(br.readLine());
		for(int i=1;i<=C;i++) {
			String line = br.readLine();
			st = new StringTokenizer(line," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			students = new boolean[n];
			friends = new boolean[10][10];
			line = br.readLine();
			st = new StringTokenizer(line," ");
			for(int j=0;j<m;j++) {
				friends[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] =true;
			}
			System.out.println(solution());
		}
	}
	static int solution() {
		int index = -10;
		for(int i=0;i<n;i++) {
			if(!students[i]) {
				index = i;
				break;
			}
		}
		if(index == -10) {
			return 1;
		}
		int count = 0;
		for(int j=index+1;j<n;j++) {
			if(!students[j] && friends[index][j]) {
				students[j] = true;
				students[index] = true;
				count += solution();
				students[j] = false;
				students[index] = false;
			}
		}
		return count;
	}

}
