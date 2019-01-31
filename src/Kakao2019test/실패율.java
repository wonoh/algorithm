package Kakao2019test;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        int n =8;
        int[] stages = {3,5,1,2,3,5,7};
        solution(n,stages);
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<node> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            double player = 0;
            double notClearPlayer = 0;
            for(int j=0;j<stages.length;j++){
                if(stages[j] >= i+1){
                    player++;
                }
                if(stages[j]==i+1){
                    notClearPlayer++;
                }
            }
            double fail = notClearPlayer/player;
            if(player==0){
                fail = 0;
            }
            list.add(new node(i+1,fail));
        }
        Collections.sort(list, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                if(o1.fail==o2.fail){
                    return o1.stage-o2.stage;
                }
                return Double.compare(o2.fail,o1.fail);
            }
        });
        for(int i=0;i<N;i++){
            System.out.println(list.get(i).toString());
            answer[i] = list.get(i).stage;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
class node {
    int stage;
    double fail;
    public node(int stage,double fail){
        this.stage = stage;
        this.fail = fail;
    }
    @Override
    public String toString() {
        return "node{" +
                "stage=" + stage +
                ", fail=" + fail +
                '}';
    }
}
