package algospot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 
 * @author wonoh 위 그림과 같이 자연수들이 다이아몬드 형태대로 배치되어 있다. 이 때, 각 가로줄에서 한 개씩의 숫자를 골라 맨
 *         위에서 맨 아래칸으로 내려오는 경로를 구성하고 싶다. 경로에서 앞뒤에 위치한 숫자들은 서로 인접해 있어야 한다: 예를 들어,
 *         위 그림에서 세 번째 줄의 7 은 그 아랫 줄의 4 또는 1 과만 이어질 수 있다.
 * 
 *         이와 같은 경로 중, 포함된 숫자의 합이 가장 큰 경로를 찾고 해당 숫자의 합을 계산하시오.
 * 
 *         입력 입력의 첫 줄에는 테스트 케이스의 수 C (1 <= C <= 100) 가 주어진다. 각 테스트 케이스의 첫 줄에는
 *         다이아몬드 가운데 줄의 가로 길이 N (1 <= N <= 100) 이 주어진다. 그 후 2*N-1 줄에, 맨 윗 줄부터,
 *         다이아몬드의 각 가로줄에 속한 숫자가 왼쪽부터 순서대로 주어진다. 각 수는 100 이하의 자연수라고 가정해도 좋다.
 * 
 *         출력 각 테스트 케이스마다 한 줄에 숫자들의 합이 가장 큰 경로에 대해 해당 합을 출력한다.
 *
 */
public class DIAMONDPATH {
	static int N;
	static int[][] dp;
	static Vector<Vector<Integer>> arrays;
	static Vector<Integer> array;
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int C = Integer.parseInt(br.readLine());
		for (int i = 1; i <= C; i++) {
			N = Integer.parseInt(br.readLine());
			arrays = new Vector<>();
			for(int row=0;row<(2*N)-1;row++) { // 2차원 vector 에 입력받기
				array = new Vector<>();
				if(row <= N-1) {
					String line = br.readLine();
					StringTokenizer st = new StringTokenizer(line, " ");
					for(int col=0;col<row+1;col++) {
						array.add(Integer.parseInt(st.nextToken()));
					}
				}else {
					String line = br.readLine();
					StringTokenizer st = new StringTokenizer(line, " ");
					for(int col=0;col<arrays.get(row-1).size()-1;col++) {
						array.add(Integer.parseInt(st.nextToken()));
					}
				}
				arrays.add(array);
			}
			dp = new int[2*N-1][N]; // dp배열 초기화
			dp[0][0]=arrays.get(0).get(0);
			dp[1][0]=dp[0][0] + arrays.get(1).get(0);
			dp[1][1]=dp[0][0] + arrays.get(1).get(1); // 비교할 값들이 없어 미리 집어넣음
			
			
			for(int row=2;row<(2*N)-1;row++) {
				if(row <= N-1) { // 다이아몬드 형태이기 때문에 row가 가로 길이일때 까지
					for(int col=0;col<row+1;col++) { 
						if(col==0) {
							dp[row][col] = dp[row-1][col] + arrays.get(row).get(col);
						}
						else {
							dp[row][col] = max(dp[row-1][col-1],dp[row-1][col]) + arrays.get(row).get(col);
						}	
					}
				}
				else { // row가 최대 가로길이부터 줄어드는 경우
					for(int col=arrays.get(row).size()-1;col>=0;col--) {
							dp[row][col] = max(dp[row-1][col],dp[row-1][col+1]) + arrays.get(row).get(col);
					}
				}
			}
			System.out.println(dp[dp.length-1][0]);
		}
	}
	public static int max(int a,int b) {
		return a > b ? a : b;
	}
}
