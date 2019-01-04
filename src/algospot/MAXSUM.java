package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * N개의 정수를 담고 있는 배열 A가 주어졌을 때, 여기서 가능한 연속 부분합을 구하는 프로그램을 작성하라.
 *
 * 여기서 연속 합이라는 것은 배열 A = { a1, a2, ..., aN } 에서 아무 값도 선택을 하지 않거나( 이 경우 합은 0 ), 배열의 임의의 i번째 수 부터 j번째 수 까지( ai, ai+1, ..., aj ) ( 1 <= i <= j <= N )를 합한 값을 뜻한다.
 *
 * 입력
 * 입력의 첫번째 줄에는 테스트 케이스의 개수 T가 입력된다.
 * 그리고 그 다음줄 부터 한줄에 하나씩 T개의 테스트 케이스가 입력된다.
 * 테스트 케이스의 첫번째 줄에는 정수 N(1<=N<=105)가 입력된다.
 * 그리고 그 다음줄에는 N개의 배열에 담긴 숫자가 순서대로 입력된다. 숫자의 범위는 -100이상 100이하의 정수다.
 *
 * 출력
 * 한줄에 하나씩 테스트 케이스의 순서대로 각 테스트케이스에 대한 가장 큰 연속 부분합을 출력한다.
 */
public class MAXSUM {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			st = new StringTokenizer(line," ");
			int sumGreedy=0;
			int sumAny=0;
			int max = 0;
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				if(sumGreedy+a >= sumGreedy) {
					sumGreedy +=a;
				}else {
					sumGreedy = 0;
				}
				if(sumAny +a >= 0) {
					sumAny +=a;
				}else {
					sumAny = 0;
				}
				max = Math.max(max,Math.max(sumAny,sumGreedy));
			}
			System.out.println(max);
		}
	}
}
