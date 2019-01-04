package algospot;

import java.util.Scanner;

/**
 * 
 * @author wonoh 왜 항상 결승전은 3판 2선승제 혹은 5판 3선승제일까? 프로야구 포스트 시즌을 보면, 준플레이오프와 플레이오프는
 *         5판 3선승제로 진행되고, 한국시리즈는 7판 4선승제로 진행된다. 다섯 경기를 하는 것과 일곱 경기를 하는 것은 무슨 차이가
 *         있을까?
 * 
 *         S@iNT 그룹의 권회장이 스타크래프트 대회를 주최하려고 한다. 권회장은 강력한 우승 후보인 altertain과
 *         kimyolo가 결승에 진출할 것으로 예상하고 있다. 단판 승부에서 altertain이 kimyolo를 이길 확률이 P%일
 *         때, 2K-1판 K선승제 경기를 하면 altertain이 우승할 확률은 어떻게 변할까?
 * 
 *         입력 첫째 줄에는 테스트 케이스의 개수 T가 주어진다. ( T <= 1010 ) 다음 T줄에 걸쳐 정수 P와 K가 주어진다.
 * 
 *         0 <= P <= 100 1 <= K <= 10 출력 altertain이 우승할 확률을 퍼센트로 출력한다. 소수점 첫째
 *         자리에서 반올림한다. (예를 들어 1/3 이면 답은 33, 2/3 면 67)
 */
public class STARCRAFT {
	static int T;
	static double P;
	static int K;
	static double result;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			P = scan.nextDouble() / 100; //a팀이 이길확률
			K = scan.nextInt();  // K선승제
			result = Math.pow(P, K) * 100; // a팀 한번도 지지않는경우의 확률구하기
			for (int n = 1; n <= K - 1; n++) { // a팀이 1패,2패 ... k-1패 까지 모든 경우의 확률을 구함
				long num = getAvailableCombination(n);
				result += Math.pow(P, K) * Math.pow(1 - P, n) * num * 100; //각 경우확률을 더해줌
			}
			System.out.println(Math.round(result));
		}
	}
	/**
	 * 
	 * @param lose a팀이 진 횟수
	 *  중복가능한 순열의 조합으로 모든 경우의 수를 구함
	 * @return s a팀이 lose 만큼 졌을 모든 경우의 수
	 */
	public static long getAvailableCombination(int lose) {
		int totalCase = K + lose - 1;
		long case1 = factorial(totalCase);
		long case2 = factorial(totalCase - lose) * factorial(lose);
		long s = case1 / case2;
		return s;
	}
	public static long factorial(int n) {
		if (n < 1)
			throw new IllegalArgumentException("n must be greater than zero");
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}
}
