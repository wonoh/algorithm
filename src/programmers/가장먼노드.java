package programmers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    static ArrayList<Integer> list[];
    static Queue<Node> queue;
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        queue = new LinkedList<>();
        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            int from = edge[i][0];
            int to = edge[i][1];
            list[from].add(to);
            list[to].add(from);
        }
        queue.offer(new Node(1,0));
        visited[1] = true;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(max < now.count){
                max = now.count;
                answer  = 1;
            }else if(max == now.count){
                answer++;
            }
            Iterator<Integer> i = list[now.num].listIterator();
            while(i.hasNext()){
                int node = i.next();
                if(!visited[node]){
                    visited[node] = true;
                    queue.offer(new Node(node,now.count+1));
                }
            }
        }
        return answer;
    }
    static class Node{
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        가장먼노드 s = new 가장먼노드();
        int n = 6;
        int[][] e = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        s.solution(n,e);

    }
}
