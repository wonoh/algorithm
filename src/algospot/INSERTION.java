package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author wonoh 유명한 정렬 알고리즘인 삽입 정렬은 정렬된 부분 배열을 유지하며 이 배열에 새 원소를 삽입해 나가는 식으로
 *         동작합니다. 주어진 정수 배열 A를 정렬하는 삽입 정렬의 구현은 다음과 같습니다.
 * 
 *         void insertionSort(vector<int>& A) { for(int i = 0; i < A.size();
 *         ++i) { // A[0..i-1] 에 A[i] 를 끼워넣는다 int j = i; while(j > 0 && A[j-1] >
 *         A[j]) { // 불변식 a: A[j+1..i] 의 모든 원소는 A[j] 보다 크다. // 불변식 b: A[0..i]
 *         구간은 A[j] 를 제외하면 정렬되어 있다. swap(A[j-1], A[j]); --j; } } } 삽입 정렬은
 *         A[0..i-1] 이 정렬된 배열일 때, A[i] 를 적절한 위치를 만날 때까지 왼쪽으로 한칸씩 움직입니다. 예를 들어
 *         A={5,1,4,3,2} 의 삽입 정렬은 다음과 같이 이루어집니다.
 * 
 *         A 비고 5 1 4 3 2 초기 상태 1 5 4 3 2 1을 왼쪽으로 1칸 옮김 1 4 5 3 2 4를 왼쪽으로 1칸 옮김
 *         1 3 4 5 2 3을 왼쪽으로 2칸 옮김 1 2 3 4 5 2를 왼쪽으로 3칸 옮김 1부터 N까지의 자연수가 한 번씩
 *         포함된 길이 N 인 수열 A[] 를 삽입 정렬했습니다. 원래 수열은 알 수 없지만, 그 과정에서 각 원소가 왼쪽으로 몇
 *         칸이나 이동했는지를 알고 있습니다. 예를 들어, 위 예제에서 각 위치에 있는 값들이 움직인 칸수를 표현하면
 *         {0,1,1,2,3} 이 됩니다. 이 때 원래 수열을 찾아내는 프로그램을 작성하세요.
 * 
 *         입력 입력의 첫 줄에는 테스트 케이스의 수 C (1 <= C <= 50) 가 주어집니다. 각 테스트 케이스의 첫 줄에는 원
 *         배열의 길이 N (1 <= N <= 50000) 이 주어집니다. 그 다음 줄에 N 개의 정수로 A의 각 위치에 있던 값들이
 *         움직인 칸수가 주어집니다. A 는 1부터 N 까지의 정수를 한 번씩 포함합니다.
 * 
 *         입력의 양이 많으므로 가능한 빠른 입력 함수를 사용하는 것이 좋습니다.
 * 
 *         출력 각 테스트 케이스마다 재구성한 A[] 를 한 줄에 출력합니다.
 */
public class INSERTION {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> originArray;
	static Stack<Integer> stack;
	static int[] move;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int c = Integer.parseInt(br.readLine());
		for (int i = 1; i <= c; i++) {
			n = Integer.parseInt(br.readLine());
			move = new int[n];
			
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			for (int j = 0; j < n; j++) {
				move[j] = Integer.parseInt(st.nextToken());
			}
			
			originArray = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				originArray.add(j + 1);  // 입력된 n만큼 1,2,3 ...n 으로 정렬된값으로 초기화
			}
			stack = new Stack<>();
			for (int k = n - 1; k >= 0; k--) { //move 배열의 끝요소부터 돌면서 이동한 숫자를 찾아 stack 에 넣고 삭제 
				int index = k - move[k]; 
				stack.add(originArray.get(index));
				originArray.remove(index);
			}
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " "); // 뒤부터 넣었기 때문에 pop 하면 뒤집어서 나오게됨.(정렬하기전 요소)
			}
			System.out.println();
		}
	}
}
