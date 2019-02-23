package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1325 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static List<Integer> list[];
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        readLine();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            readLine();
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            list[from].add(to);
        }

        int[] temp = new int[N+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            temp[i] = bfs(i);
            max  = Math.max(max,temp[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=N;i++){
            if(temp[i]==max){
                result.add(i);
            }
        }
        Collections.sort(result);
        for(int val:result){
            System.out.print(val+" ");
        }



    }
    public static int bfs(int start){
        queue = new LinkedList<>();
        int hacking = 0;
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            Iterator<Integer> i = list[node].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                    hacking++;
                }
            }

        }
        return hacking;

    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
