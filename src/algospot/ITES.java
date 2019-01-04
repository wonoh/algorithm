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
			 signal = (first%10000+1); // 신호 만들기
			 queue.add(signal); // 만들어진 신호 queue add
			 sum+=signal;
			 while(!queue.isEmpty() && sum >=K){ // queue 가 비어있지 않거나 sum 이 k보다 크거나 같을때  sum 에서 queue 요소를 빼주면서
			 									// sum 이 k 와 같아지는 구간을 찾음
			 	if(sum==K){
			 		count++;
				}
			 	sum-=queue.poll();
			 }
			 temp = (long)(first*214013+2531011) % a; // 다음 신호를 만들어내기 위한 저장소
			 first = temp;
		}
		return count;
	}
}
