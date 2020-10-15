package kakakomelon;

import java.util.Arrays;
import java.util.List;

public class P2 {

    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList(7,2,3,10,2,1,9)));

    }

    public static int solution(List<Integer> arr) {
        // Write your code here
        int maxDifference = -1;
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int currentValue = arr.get(i);
            if(currentValue > min){
                maxDifference = Math.max(maxDifference, currentValue - min);
            }else{
                min = currentValue;
            }
        }
        return maxDifference;

    }
}
