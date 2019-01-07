package algospot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wonoh N 가지의 할 일이 있습니다. 이들 간에는 서로 의존 관계가 있는데, 이들은 특정 작업을 하기 전에는 다른 작업을
 * 할 수 없다는 것을 나타냅니다. 작업간의 의존 관계가 주어질 때, 이들을 어떤 순서대로 수행해야 모든 작업을 마칠 수
 * 있는지를 계산하는 프로그램을 작성하세요.
 * <p>
 * 항상 모든 작업을 수행할 수 있다고 가정합니다.
 * <p>
 * 입력 입력의 첫 줄에는 테스트 케이스의 수 C (<= 50) 이 주어집니다. 각 테스트 케이스의 첫 줄에는 작업의 개수 (1
 * <= N <= 26) 과 의존 관계의 수 (1 <= M <= 100) 이 주어집니다. 이 때, 각 작업은 알파벳 대문자 A
 * 이후 글자를 써서 각각 표현됩니다. (예를 들어, N=3 이라면, 세 작업의 이름은 각각 A, B, 그리고 C 가 됩니다.)
 * 그 후 줄에 하나씩 의존 관계가 주어집니다. 각 의존 관계는 ab 의 형태로 주어지며, 이 문자열은 작업 b 이전에 작업 a
 * 를 해야만 한다는 것을 나타냅니다.
 * <p>
 * 출력 각 테스트 케이스마다 작업을 수행할 수 있는 순서를 한 줄에 출력합니다. 만약 이 순서가 여러 가지 있다면, 이 중
 * 사전순으로 가장 앞에 있는 것을 출력합니다.
 */
public class ORDERING {
    static int N; // 작업의 개수
    static int M; // 의존성의 개수
    static int[][] array;
    static int[] indegree;
    static PriorityQueue<Integer> pq;
    static StringBuilder result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 1; i <= T; i++) {
            result = new StringBuilder();
            N = scan.nextInt();
            M = scan.nextInt();
            array = new int[N][N];
            indegree = new int[N];
            pq = new PriorityQueue<>(new Comparator<Integer>() { //우선순위큐 정렬 기준 설정
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for (int j = 0; j < M; j++) {
                String depend = scan.next();
                char start = depend.charAt(0);
                char end = depend.charAt(1);
                array[start - 'A'][end - 'A'] = 1;
                indegree[end - 'A']++;
            }
            for (int j = 0; j < indegree.length; j++) {
                if (indegree[j] == 0) {
                    pq.add(j); // 차수가 0인 노드들을 우선순위 큐에 삽입
                }
            }
            while (!pq.isEmpty()) {
                int index = pq.poll();
                result.append((char) (index + 'A'));
                for (int k = 0; k < N; k++) {
                    if(array[index][k] > 0) { //연결되어있는 정점이라면
                        indegree[k]--; //차수를 지움 ( 해야할 일을 하나씩 지움 )
                        if (indegree[k] == 0) {
                            pq.add(k); //차수가 0이되었다면 다시 우선순위 큐에 삽입
                        }
                    }
                }
            }
            System.out.println(result.toString());
        }
    }
}
