package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
