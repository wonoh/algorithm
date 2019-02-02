package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wonoh
 * 3 6 9 게임을 프로그램으로 제작중이다. 게임 규칙은 다음과 같다.
 * <p>
 * <p>
 * <p>
 * 1. 숫자 1부터 순서대로 차례대로 말하되, “3” “6” “9” 가 들어가 있는 수는 말하지 않는다.
 * <p>
 * 1 2 3 4 5 6 7 8 9…
 * <p>
 * 2. "3" "6" "9"가 들어가 있는 수를 말하지 않는대신, 박수를 친다. 이 때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다.
 * 예를 들어 숫자 35의 경우 박수 한 번, 숫자 36의 경우 박수를 두번 쳐야 한다.
 * <p>
 * <p>
 * 입력으로 정수 N 이 주어졌을 때, 1~N 까지의 숫자를
 * <p>
 * 게임 규칙에 맞게 출력하는 프로그램을 작성하라.
 * <p>
 * 박수를 치는 부분은 숫자 대신, 박수 횟수에 맞게 “-“ 를 출력한다.
 * <p>
 * 여기서 주의해야 할 것은 박수 한 번 칠 때는 - 이며, 박수를 두 번 칠 때는 - - 가 아닌 -- 이다.
 * <p>
 * <p>
 * [제약사항]
 * <p>
 * N은 10이상 1,000이하의 정수이다. (10 ≤ N ≤ 1,000)
 * <p>
 * <p>
 * <p>
 * [입력]
 * <p>
 * 입력으로 정수 N 이 주어진다.
 * <p>
 * <p>
 * [출력]
 * <p>
 * 1 ~ N까지의 숫자를 게임 규칙에 맞게 출력한다.
 */
public class SA1926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<String> numberList = new ArrayList<>();
        for (int i = 3; i <= 9; i += 3) {
            numberList.add(String.valueOf(i));
        }
        StringBuilder result = new StringBuilder();
        for (int num = 1; num <= n; num++) {
            String[] splitArray = String.valueOf(num).split("");
            int count = 0;
            for (int i = 0; i < splitArray.length; i++) {
                if (numberList.contains(splitArray[i])) {
                    count++;
                }
            }
            if(count ==0){
                result.append(num+" ");
                continue;
            }
            result.append(makeClap(count).toString());
        }
        System.out.println(result.toString());
    }
    public static StringBuilder makeClap(int count){
        StringBuilder clap = new StringBuilder();
        for(int i=0;i<count;i++){
            clap.append("-");
        }
        return clap.append(" ");
    }

}
