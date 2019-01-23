package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wonoh
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을,
 * 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고,
 * 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * 입력
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 *
 * 출력
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 */
public class Baekjoon2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count;
    static int[][] array;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) { // 2차원 array 초기화
            String[] splitArray = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(splitArray[j]);
            }
        }
        result = new ArrayList<>();
        int community = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] == 1) { // 해당 정점에 집이 있는경우
                    count = 0;
                    count = solution(x, y, visited); // 내주변에 연결되어있는 집을 찾음
                    if(count!=0){ //연결되어있는집이 있을때
                        community++;
                        result.add(count);
                    }


                }
            }
        }
        System.out.println(community);
        Collections.sort(result);
        for(Integer i:result){
            System.out.println(i);
        }
    }

    private static int solution(int x, int y, boolean[][] visited) {
        if(x >= visited.length || y >= visited.length || x < 0 || y < 0){ // array index범위에 벗어났을때
            return 0;
        }
        if (visited[x][y] || array[x][y]==0) { // 이미 방문했거나 해당정점에 집이 없는경우
            return 0;
        }
        visited[x][y] = true; // 해당정점 방문처리
        count++;
        solution(x+1,y,visited); //위
        solution(x-1,y,visited); //아래
        solution(x,y+1,visited); //오른쪽
        solution(x,y-1,visited); //왼쪽
        return count;
    }

}
