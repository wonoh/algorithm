package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.
 * <p>
 * 출력
 * 총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.
 */
public class Baekjoon11403 {
    static int[][] array;
    static int[][] resultArray;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        resultArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            find(i);
            for (int j = 1; j <= n; j++) {
                if (visited[j - 1]) {
                    resultArray[i - 1][j - 1] = 1;
                } else {
                    resultArray[i - 1][j - 1] = 0;
                }
            }
            Arrays.fill(visited, false);
        }
        StringBuilder result = new StringBuilder();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                result.append(resultArray[x][y] + " ");
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }

    public static void find(int startNode) {
        for (int i = 0; i < array.length; i++) {
            if (array[startNode - 1][i] == 1 && !visited[i]) {
                visited[i] = true;
                find(i + 1);
            }
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
