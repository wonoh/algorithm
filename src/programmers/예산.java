package programmers;

import java.util.Arrays;

/**
 * @author wonoh
 * 국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것입니다. 국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있습니다. 그래서 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정합니다.
 *
 * 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정합니다.
 * 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정합니다.
 *    상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정합니다.
 * 예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150일 때, 상한액을 127로 잡으면 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고 그 합이 484로 가능한 최대가 됩니다.
 * 각 지방에서 요청하는 예산이 담긴 배열 budgets과 총 예산 M이 매개변수로 주어질 때, 위의 조건을 모두 만족하는 상한액을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * 지방의 수는 3 이상 10,000 이하인 자연수입니다.
 * 각 지방에서 요청하는 예산은 1 이상 100,000 이하인 자연수입니다.
 * 총 예산은 지방의 수 이상 1,000,000,000 이하인 자연수입니다.
 */
public class 예산 {
    static int min_m;
    static int max_m;
    public static void main(String[] args) {
        int[] budgets = {10,20,30};
        int m = 485;
        System.out.println(solution(budgets,m));
    }

    private static int solution(int[] budgets, int m) {
        int answer = 0;
        min_m = 1;
        for(int i=0;i<budgets.length;i++){
            max_m += budgets[i];
        }
        if( max_m < m){
            Arrays.sort(budgets);
            return budgets[budgets.length-1];
        }
        for(int i=min_m;i<max_m;i++){
            int sum = 0;
            for(int j=0;j<budgets.length;j++){
                if(budgets[j] > i){
                    sum+=i;
                    continue;
                }
                sum+=budgets[j];
            }
            if(sum > m){
                answer = i-1;
                break;
            }
        }
        return answer;
    }
}
