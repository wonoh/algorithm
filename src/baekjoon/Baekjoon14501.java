package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node> list;
    static int N;
    static int answer = Integer.MIN_VALUE;
    static int sum;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            readLine();
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        answer = 0;
        dfs(1,0);
        System.out.println(answer);
    }

    public static void dfs(int day,int sum) {
        if(day == N+1){
            answer = answer > sum ? answer : sum;
            return;
        }
        Node node = list.get(day-1);
        // 자기자신 선택 안할경우
        if(day <= N){
            dfs(day+1,sum);
        }

        //선택 할 경우
        if(day+node.time <= N+1){
            dfs(day+node.time,sum+node.price);
        }

    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

    static class Node {
        int time;
        int price;

        public Node(int time, int price) {
            this.time = time;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "time=" + time +
                    ", price=" + price +
                    '}';
        }
    }

}
