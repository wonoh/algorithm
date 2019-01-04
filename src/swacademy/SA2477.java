package swacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class SA2477 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			int N=scan.nextInt(); // 접수 창구 개수
			int M=scan.nextInt(); // 정비 창구 개수
			int K=scan.nextInt(); // 방문한 사람수
			int A=scan.nextInt(); // 지갑두고간 사람이 이용한 접수창고 번호 
			int B=scan.nextInt(); // 지갑두고간 사람이 이용한 정비창고 번호
			int[] a=new int[N];
			for(int j=0;j<N;j++) {
				a[j]=scan.nextInt();
			}
			int[] b=new int[M];
			for(int j=0;j<M;j++) {
				b[j]=scan.nextInt();
			}
			int[] time=new int[K];
			for(int j=0;j<K;j++) {
				time[j]=scan.nextInt();
			}
			int result = 0;
			if(N==1 && M==1) {
				for(int j=1;j<=K;j++) {
					result+=i;
				}
			}
			Queue<Integer> Nholding = new LinkedList<>(); 
			Queue<Integer> Mholding = new LinkedList<>(); 
			Vector<Vector<Integer>> history = new Vector<>();
			int first = time[0];
			for(int t=0;t<20000;t++) {
				
			}
			
		}

	}

}
