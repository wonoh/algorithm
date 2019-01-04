package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ITES {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] A;
	static long signal;
	static long temp;
	static long first = (long)1983;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int C = Integer.parseInt(br.readLine());
		for(int i=1;i<=C;i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line," ");
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			long start = System.currentTimeMillis();
			System.out.println(makeSignal(N,K));
			long end = System.currentTimeMillis();
			System.out.println("시간---"+(end-start));
		}
	}
	static int makeSignal(int N,int K) {
		for(int i=0;i<N;i++) {
			 long a = (long) Math.pow(2,32);
			 temp = (long)(first*214013)+2531011 % a;
			 signal = (temp%10000+1);
			 System.out.println(signal);
			 first = temp;
		}
		int count=0;
		
		return count;
	}
}
