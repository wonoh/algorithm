package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ITES {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] A;
	static long signal;
	static long temp;
	static long first;
	static Queue<Long> queue;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int C = Integer.parseInt(br.readLine());
		for(int i=1;i<=C;i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line," ");
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			System.out.println(makeSignal(N,K));
		}
	}
	static int makeSignal(int N,int K) {
		queue = new LinkedList<>();
		first = (long)1983;
		sum = 0;
		int count=0;
		for(int i=0;i<N;i++) {
			 long a = (long) Math.pow(2,32);
			 signal = (first%10000+1);
			 queue.add(signal);
			 sum+=signal;
			 while(!queue.isEmpty() && sum >=K){
			 	if(sum==K){
			 		count++;
				}
			 	sum-=queue.poll();
			 }
			 temp = (long)(first*214013+2531011) % a;
			 first = temp;
		}
		return count;
	}
}
