package algospot;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * @author wonoh 위 형태와 같이 삼각형 모양으로 배치된 자연수들이 있습니다. 맨 위의 숫자에서 시작해, 한 번에 한 칸씩 아래로
 *         내려가 맨 아래 줄로 내려가는 경로를 만들려고 합니다. 경로는 아래 줄로 내려갈 때마다 바로 아래 숫자, 혹은 오른쪽 아래
 *         숫자로 내려갈 수 있습니다. 이 때 모든 경로 중 포함된 숫자의 최대 합을 찾는 프로그램을 작성하세요.
 * 
 *         입력 입력의 첫 줄에는 테스트 케이스의 수 C(C <= 50)가 주어집니다. 각 테스트 케이스의 첫 줄에는 삼각형의 크기
 *         n(2 <= n <= 100)이 주어지고, 그 후 n줄에는 각 1개~n개의 숫자로 삼각형 각 가로줄에 있는 숫자가 왼쪽부터
 *         주어집니다. 각 숫자는 1 이상 100000 이하의 자연수입니다.
 * 
 *         출력 각 테스트 케이스마다 한 줄에 최대 경로의 숫자 합을 출력합니다.
 */
public class TRIANGLEPATH {
	static Vector<Vector<Integer>> vectors; // 입력받을 배열
	static Vector<Integer> vector; 
	static int[][] dp; // dp 배열
	static int n; // 삼각형 길이

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			n = scan.nextInt();
			vectors = new Vector<>();
			for (int row = 0; row < n; row++) { // 삼각형 전체 데이터를 vector로 입력받기
				vector = new Vector<>();
				for (int col = 0; col < row + 1; col++) {
					vector.add(scan.nextInt());
				}
				vectors.add(vector);
			}
			dp = new int[n][n];
			dp[0][0] = vectors.get(0).get(0);
			dp[1][0] = dp[0][0] + vectors.get(1).get(0);
			dp[1][1] = dp[0][0] + vectors.get(1).get(1); // 비교할 대상이 없는경우기 때문에 미리 채워놓음
			for (int row = 2; row < vectors.size(); row++) { // 삼각형 형태로 값을 채워나가면서 값 비교 
				for (int col = 0; col < vectors.get(row).size(); col++) {
					if (col == 0) {
						dp[row][col] = dp[row - 1][col] + vectors.get(row).get(col);
					} else {
						int max = Math.max(dp[row - 1][col - 1], dp[row - 1][col]);
						dp[row][col] = max + vectors.get(row).get(col);
					}
				}
			}
			int[] result = new int[n];
			result = dp[n - 1];
			Arrays.sort(result);
			System.out.println(result[n - 1]);
		}
	}

}
