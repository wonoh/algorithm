package baekjoon;

import java.util.*;

public class lotto {
 
    public static void main(String[] args) {
 
    	lotto lotto = new lotto();
        Scanner sc = new Scanner(System.in);
 
        System.out.print("로또번호 추출 개수 입력: ");
        int gameCnt = sc.nextInt();
 
        for (int i = 1; i <= gameCnt; i++) {
            System.out
                    .println(i + "번째 로또번호: " + lotto.lottoNumbers());
        }
    }
 
    String lottoNumbers() {
 
        Set<Integer> set = new HashSet<Integer>();
        while( set.size() < 6){
            Double d = Math.random() * 45 + 1;
            set.add(d.intValue()); 
        }
         
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
         
        return list.toString();
    }
}


