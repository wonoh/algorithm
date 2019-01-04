package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author wonoh
 *
 *         2차원의 행렬이 주어졌을 때, 행렬의 숫자를 1 x 1 이상의 부분 행렬의 원소들의 합 중에 최대가 되는 경우를 찾는
 *         프로그램을 작성하라.
 * 
 *         0 -2 -7 0 9 2 -6 2 -4 1 -4 1 -1 8 0 2 위의 경우 최대 부분 행렬의 합은 짙은 글씨 부분을
 *         선택한 경우 이며, 이 경우 답은 15다.
 * 
 *         입력 입력의 첫번쨰 줄에는 테스트 케이스의 개수 T가 입력된다. 그 다음 줄 부터 T개의 테스트 케이스가 입력된다. 테스트
 *         케이스의 첫번째 줄은 N(1<=N<=200)이 입력된다. 그리고 N개의 줄에 N개의 정수가 입력되며, 이는 우리가 직사각형
 *         합의 최대를 찾기위한 행렬이다. 행렬에 입력되는 원소의 크기는 -127이상 127이하의 정수다.
 * 
 *         출력 최대 사각형의 합을 테스트 케이스의 순서대로 한줄에 하나씩 출력한다.
 */
public class MAXMAT {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] array;
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		solution(N);

	}
   static void solution(int N) throws IOException {
	   array = new int[N][N];
	   for(int x=0;x<N;x++) {
		 st = new StringTokenizer(br.readLine());
		 for(int y=0;y<N;y++) {
			 array[x][y] = Integer.parseInt(st.nextToken());
		 }
	   }
	   int[][] sum = new int[N + 1][N + 1];
       int max = Integer.MIN_VALUE;
       
       for(int i = 0; i < N; i++) {
           for(int j = 0; j < N; j++) {
               sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
               sum[i + 1][j + 1] += array[i][j];
           }
           System.out.println(Arrays.toString(sum[i]));
       }
       
   }

}
