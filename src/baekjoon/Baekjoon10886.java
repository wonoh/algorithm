package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 준희는 자기가 팀에서 귀여움을 담당하고 있다고 생각한다. 하지만 연수가 볼 때 그 의견은 뭔가 좀 잘못된 것 같았다. 그렇기에 설문조사를 하여 준희가 귀여운지 아닌지 알아보기로 했다.
 *
 * 입력
 * 첫 번째 줄에 설문조사를 한 사람의 수 N (1 ≤ N ≤ 101, N은 홀수)가 주어진다.
 *
 * 다음 N개의 줄에는 각 줄마다 각 사람이 설문 조사에 어떤 의견을 표명했는지를 나타내는 정수가 주어진다. 0은 준희가 귀엽지 않다고 했다는 뜻이고, 1은 준희가 귀엽다고 했다는 뜻이다.
 *
 * 출력
 * 준희가 귀엽지 않다는 의견이 더 많을 경우 "Junhee is not cute!"를 출력하고 귀엽다는 의견이 많을 경우 "Junhee is cute!"를 출력하라.
 */
public class Baekjoon10886 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final String CUTE = "Junhee is cute!";
    static final String NOT_CUTE = "Junhee is not cute!";
    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cute = 0;
        int notCute = 0;
        for(int i=0;i<n;i++){
            if(Integer.parseInt(br.readLine())==1){
                cute++;
            }else{
                notCute++;
            }
        }
        System.out.println(cute>notCute?CUTE:NOT_CUTE);
    }
}
