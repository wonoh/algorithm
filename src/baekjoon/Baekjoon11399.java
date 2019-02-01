package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11399 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Human> list = new ArrayList<>();
            readLine();
        for(int i=0;i<n;i++){
            list.add(new Human(i+1,Integer.parseInt(st.nextToken())));
        }
        list.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                if(o1.time==o2.time){
                    return o1.id-o2.id;
                }
                return o1.time-o2.time;
            }
        });
        int[] time = new int[list.size()];
        time[0] = list.get(0).time;
        for(int i=1;i<list.size();i++){
            time[i] = time[i-1] + list.get(i).time;
        }
        int sum = 0;
        for(int val : time){
            sum += val;
        }
        System.out.println(sum);
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
class Human {
    int id;
    int time;

    public Human(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }

}
