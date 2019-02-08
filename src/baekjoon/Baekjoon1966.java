package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            queue = new LinkedList<>();
            readLine();
            int n = Integer.parseInt(st.nextToken());
            int[] work = new int[n];
            int m = Integer.parseInt(st.nextToken());
            readLine();
            int index = 0;
            while (st.hasMoreTokens()) {
                queue.add(new Node(index, Integer.parseInt(st.nextToken())));
                index++;
            }
            int i=0;
            while (!queue.isEmpty()) {
                Node topNode = queue.peek();
                boolean flag = false;
                for (Node node : queue) {
                    if (node.importance > topNode.importance) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    queue.poll();
                    queue.add(topNode);
                }else{
                    work[i] = queue.poll().num;
                    i++;
                }
            }
            for(int j=0;j<work.length;j++){
                if(work[j]==m){
                    System.out.println(j+1);
                }
            }

        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}

class Node {
    int num;
    int importance;

    public Node(int num, int importance) {
        this.num = num;
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", importance=" + importance +
                '}';
    }
}
