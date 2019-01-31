package programmers;

import java.util.*;

public class 프린터 {
    public static void main(String[] args) {
            int[] a = {1,1,9,1,1,1};
            int loca = 0;
        System.out.println(solution(a,loca));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<node> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(new node(i,priorities[i]));
        }
        int index = 0;
        while(!queue.isEmpty()){
            node no = queue.poll();
            boolean next = false;
            for(int j=0;j<queue.size();j++){
                    if(no.priorities < ((LinkedList<node>) queue).get(j).priorities){
                        next = true;
                    }
            }
            if(next){
                queue.add(no);
            }else{
                if(no.index==location){
                    answer = index;
                    break;
                }
                index++;
            }
            System.out.println(queue.toString());
        }
        return answer+1;
    }
}
class node {
    int index;
    int priorities;

    public node(int index, int priorities) {
        this.index = index;
        this.priorities = priorities;
    }

    @Override
    public String toString() {
        return "node{" +
                "index=" + index +
                ", priorities=" + priorities +
                '}';
    }
}
