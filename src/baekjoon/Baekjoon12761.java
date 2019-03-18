package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon12761 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int start,end,a,b;
    public static void main(String[] args) throws IOException {
        readLine();
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        bfs();
    }
    public static void bfs(){
        int[] dx = {-1,1,a,b,-a,-b,a,b};
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(start);
        int time = 0;
        visited[start] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now == end){
                    System.out.println(time);
                    return;
                }
                for (int j = 0; j < 8; j++) {
                    int next;
                    if(j < 6){
                        next = now+dx[j];
                    }else{
                        next = now*dx[j];
                    }
                    if(next < 0 || next > 100000){
                        continue;
                    }
                    if(!visited[next]){
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            time++;
        }

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
