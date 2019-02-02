package programmers;

import java.util.HashMap;

public class 위장 {
    public static void main(String[] args) {
        String[][] cl = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(cl));
    }
    public static int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                int count = map.get(clothes[i][1]);
                map.put(clothes[i][1],count+1);
                continue;
            }
            map.put(clothes[i][1],1);
        }
        if(map.size()==1){
            return clothes.length;
        }
        int value = 1;
        for(String key:map.keySet()){
            value *= map.get(key)+1;
        }
        return value-1;
    }
}
