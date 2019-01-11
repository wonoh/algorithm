package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 은비는 빵을 좋아한다.
 *
 *
 * “아 빵 먹고 싶다.”
 *
 *
 * 은비는 자주 가는 빵집에서 두 가지 맛의 빵 밖에 먹지 않는다.
 *
 * 하나는 현미 빵으로 하나에 A원에 팔고 있다.
 *
 * 또 다른 하나는 단호박 빵으로 하나에 B원에 팔고 있다.
 *
 * 은비는 지금 C원을 가지고 있으며, 어떤 빵이든 상관 없이 그냥 많은 개수의 빵을 사고 싶다.
 *
 * 두 종류의 개수를 다르게 사도 되고, 한 종류의 빵만 사도 된다.
 *
 *
 * 최대 몇 개의 빵을 살 수 있을까?
 *
 *
 *
 * [입력]
 *
 *
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 *
 *
 * 각 테스트 케이스의 첫 번째 줄에는 세 정수 A, B, C(1 ≤ A, B ≤ 103, 1 ≤ C ≤ 106)가 공백으로 구분되어 주어진다.
 *
 *
 * [출력]
 *
 *
 * 각 테스트 케이스마다 #T를 출력하고 한 칸을 띄운 후, 최대 몇 개의 빵을 살 수 있는지 출력한다.
 */
public class SA5162 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int a=1;a<=T;a++){
            st = new StringTokenizer(br.readLine()," ");
            int bread1 = Integer.parseInt(st.nextToken());
            int bread2 = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            int min = min(bread1,bread2); // 최대한 많이 사려면 가격이 적은 빵을 사야함
            System.out.println("#"+a+" "+money/min); // 가지고있는돈/빵최소가격 -> 살수있는 가격
        }
    }
    public static int min(int a,int b){
        return a < b ? a : b;
    }
}
