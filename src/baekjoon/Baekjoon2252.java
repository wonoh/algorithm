package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wonoh
 * N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
 * <p>
 * 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 N(1≤N≤32,000), M(1≤M≤100,000)이 주어진다. M은 키를 비교한 회수이다. 다음 M개의 줄에는 키를 비교한 두 학생의 번호 A, B가 주어진다. 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.
 * <p>
 * 학생들의 번호는 1번부터 N번이다.
 * <p>
 * 출력
 * 첫째 줄부터 앞에서부터 줄을 세운 결과를 출력한다. 답이 여러 가지인 경우에는 아무거나 출력한다.
 */
public class Baekjoon2252 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
       ArrayList<Integer> [] graph = new ArrayList[N+1];
        int[] indegree = new int[N + 1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end); // 1,3 -> list 1 - 3 값 저장
            indegree[end]++; //차수 저장
        }
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i); //차수가 0일때 큐에 저장
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll(); // 앞에 서도 되는경우기 때문에 하나씩 poll
            result.add(index);
            for(int i=0;i<graph[index].size();i++){
                int next = graph[index].get(i);
                indegree[next]--; // 차수 하나씩 줄임
                if(indegree[next]==0){ // 앞에 서도 되는경우가 되면 큐에 삽입
                    queue.add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
