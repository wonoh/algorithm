package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Conference> queue = new PriorityQueue<>(new Comparator<Conference>() {
            @Override
            public int compare(Conference o1, Conference o2) {
                if(o1.end==o2.end){
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
        for(int i=0;i<n;i++){
            readLine();
            queue.add(new Conference(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int  answer = 0;
        int end = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Conference conference = queue.poll();
            if(conference.start >= end){
                answer++;
                end = conference.end;
            }
        }
        System.out.println(answer);
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
class Conference{
    int start;
    int end;

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
