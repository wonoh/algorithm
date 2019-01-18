package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wonoh
 * 프로그래밍 언어 C 의 큰 문제점 중 하나는 언어 차원에서 문자열 변수형을 지원하지 않는다는 것입니다. C 에서는 문자 배열로 문자열을 표현하되 \0 (NULL) 로 문자열의 끝을 지정하는데, 이래서는 문자열의 길이를 쉽게 알 수 있는 방법이 없기 때문에 여러 가지 문제가 발생하게 됩니다.
 *
 * void strcat(char* dest, const char* src) {
 *  // dest 의 마지막 위치를 찾는다
 *  while(*dest) ++dest;
 *  // src 를 한 글자씩 dest 에 옮겨 붙인다
 *  while(*src) *(dest++) = *(src++);
 *  // 문자열의 끝을 알리는 \0 을 추가한다
 *  *dest = 0;
 * }
 * 이런 문제 중 하나로 문자열을 조작하는 함수들의 동작 시간이 불필요하게 커진다는 것이 있습니다. 앞에 주어진 함수 strcat() 은 문자열 dest 뒤에 src 를 붙이는 함수인데, 실행 과정에서 반복문을 두 문자열의 길이를 합한 만큼 수행해야 합니다. 이 함수를 사용해 두 개의 문자열을 합치는 비용은 두 문자열의 길이의 합이라고 합시다.
 *
 * 이 함수를 이용해 n 개의 문자열을 순서와 상관없이 합쳐서 한 개의 문자열로 만들고 싶습니다. 순서가 상관 없다는 말은 {al,go,spot} 을 spotalgo 로 합치든 alspotgo 로 합치든 상관 없다는 의미입니다. 그러나 문자열을 합치는 순서에 따라 전체 비용이 달라질 수 있습니다. 예를 들어 먼저 al 과 go 를 합치고 (2+2=4), 이것을 spot 과 합치면 (4+4=8) 총 12 의 비용이 들지만 al 과 spot 을 합치고 (2+4=6) 이것을 다시 go 에 합치면 (6+2=8) 총 14 의 비용이 필요합니다.
 *
 * n 개의 문자열들의 길이가 주어질 때 필요한 최소 비용을 찾는 프로그램을 작성하세요.
 *
 * 입력
 * 입력의 첫 줄에는 테스트 케이스의 수 c (c <= 50) 가 주어집니다. 각 테스트 케이스의 첫 줄에는 문자열의 수 n (1 <= n <= 100) 이 주어지며, 다음 줄에는 n 개의 정수로 각 문자열의 길이가 주어집니다. 각 문자열의 길이는 1,000 이하의 자연수입니다.
 *
 * 출력
 * 각 테스트 케이스마다 한 줄에 모든 문자열을 합칠 때 필요한 최소 비용을 출력합니다.
 */
public class STRJOIN {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args)throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int a=1;a<=T;a++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list); // 적은수 부터 더해가야 하기때문 정렬
            int count =0;
            int answer = 0;
            while(count<n-1){ // 주어진 문자열을 다합칠 경우까지만 반복
                int sum = list.get(0)+list.get(1); // 가장작은 두숫자를 더함
                answer += sum; // 답에 더해주고
                for(int j=0;j<2;j++){ //더한 값을 삭제
                    list.remove(0);
                }
                list.add(sum); //더한값을 리스트에 넣고
                Collections.sort(list); // 다시 정렬
                count++; // 문자열을 합친 횟수를 증가
            }
            System.out.println(answer);
        }
    }

}