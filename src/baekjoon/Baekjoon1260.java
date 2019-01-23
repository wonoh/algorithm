package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wonoh
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 *
 * 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */
public class Baekjoon1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static LinkedList<Integer> list[];
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        readLine();
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        list = new LinkedList[nodeNum+1];
        for(int j=0;j<nodeNum+1;j++){ // 인접리스트 초기화
            list[j] = new LinkedList<>();
        }
        for (int i = 0; i < edgeNum; i++) {
            readLine();
            int from = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);  // 양방향 이기 때문에 양쪽다 값을 넣어줌
        }
        boolean[] visited = new boolean[nodeNum+1];
        dfs(startNode,visited);
        System.out.println();
        boolean[] visited2 = new boolean[nodeNum+1];
        queue = new LinkedList<>();
        bfs(startNode,visited2);
    }

    private static void bfs(int v, boolean[] visited2) {
        visited2[v] = true; // 해당정점 방문
        queue.add(v); // 방문한 정점을 큐에 삽입
        while(!queue.isEmpty()){
            int node = queue.poll();  // 방문한 정점을 큐에서 꺼냄
            System.out.print(node+" ");
            Iterator<Integer> i = list[node].listIterator(); // 꺼낸 정점에 연결되어있는 정점들을 가져옴
            while(i.hasNext()){
                int n = i.next();
                if(!visited2[n]){ // 방문하지 않았다면
                    visited2[n]=true;
                    queue.add(n); //방문처리해주고 큐에 삽입 ( 큐 -> 선입 선출 )
                }
            }
        }
    }

    public static void dfs(int v,boolean[] visited){
        visited[v] = true; // 해당 정점 방문 처리
        System.out.print(v+" ");
        Collections.sort(list[v]); // 갈수있는 경로가 여러가지일경우 숫자가 작은 정점으로 가야하기 때문에 정렬해줌
        Iterator<Integer> i = list[v].listIterator(); // 해당정점에 연결된 정점들을 가져옴

        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                dfs(n,visited); //해당정점을 방문하지 않았다면 다시 함수 호출
            }
        }
    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
