package swacademy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wonoh
 * 장훈이는 서점을 운영하고 있다.
 * <p>
 * 서점에는 높이가 B인 선반이 하나 있는데 장훈이는 키가 매우 크기 때문에, 선반 위의 물건을 자유롭게 사용할 수 있다.
 * <p>
 * 어느 날 장훈이는 자리를 비웠고, 이 서점에 있는 N명의 점원들이 장훈이가 선반 위에 올려놓은 물건을 사용해야 하는 일이 생겼다.
 * <p>
 * 각 점원의 키는 Hi로 나타나는데, 점원들은 탑을 쌓아서 선반 위의 물건을 사용하기로 하였다.
 * <p>
 * 점원들이 쌓는 탑은 점원 1명 이상으로 이루어져 있다.
 * <p>
 * 탑의 높이는 점원이 1명일 경우 그 점원의 키와 같고, 2명 이상일 경우 탑을 만든 모든 점원의 키의 합과 같다.
 * <p>
 * 탑의 높이가 B 이상인 경우 선반 위의 물건을 사용할 수 있는데 탑의 높이가 높을수록 더 위험하므로 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑을 알아내려고 한다.
 * <p>
 * <p>
 * [입력]
 * <p>
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 * <p>
 * 각 테스트 케이스의 첫 번째 줄에는 두 정수 N, B(1 ≤ N ≤ 20, 1 ≤ B ≤ S)가 공백으로 구분되어 주어진다.
 * <p>
 * S는 두 번째 줄에서 주어지는 점원들 키의 합이다.
 * <p>
 * 두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며, 각 정수는 각 점원의 키 Hi (1 ≤ Hi ≤ 10,000)을 나타낸다.
 * <p>
 * <p>
 * [출력]
 * <p>
 * 각 테스트 케이스마다 첫 번째 줄에는 ‘#t’(t는 테스트 케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 만들 수 있는 높이가 B 이상인 탑 중에서 탑의 높이와 B의 차이가 가장 작은 것을 출력한다.
 * <p>
 * <p>
 * [예제 풀이]
 * <p>
 * 테스트 케이스의 경우 키가 3, 3, 5, 6인 점원이 탑을 만들면 높이가 17(3 + 3 + 5 + 6)이 된다.
 * <p>
 * 높이가 16인 탑은 만들 수 없으므로 높이가 17인 탑이 문제에서 구하려는 탑의 높이이다. 따라서 17 – 16 = 1이 답이 된다.
 */
public class SA1486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] height;
    static int shelfHeight;
    static int asdasd =  Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            shelfHeight = Integer.parseInt(st.nextToken());
            height = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            find(0,0);
            System.out.println("#"+a+" "+asdasd);
            asdasd = Integer.MAX_VALUE;
        }
    }

    /**
     *
     * @param a
     * @param sum
     * 모든 부분 수열의 합을 찾는다.
     */
    public static void find(int a,int sum){
        if(sum>=shelfHeight){ // 합이 높이보다 크거나 같을때
            asdasd = Math.min(asdasd, sum-shelfHeight); //차이의 최소값을 저장
            return;
        }
        if(a>=height.length ){
            return;
        }
        find(a+1,sum+height[a]);
        find(a+1,sum);
    }
}
