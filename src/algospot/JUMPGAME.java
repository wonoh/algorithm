package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 땅따먹기를 하다 질린 재하와 영훈이는 땅따먹기의 변종인 새로운 게임을 하기로 했습니다. 이 게임은 그림과 같이 n*n 크기의 격자에 각 1부터 9 사이의 정수를 쓴 상태로 시작합니다. 각 차례인 사람은 맨 왼쪽 윗 칸에서 시작해 외발로 뛰어서 오른쪽 아래 칸으로 내려가야 합니다. 이 때 각 칸에 적혀 있는 숫자만큼 오른쪽이나 아래 칸으로 움직일 수 있으며, 중간에 게임판 밖으로 벗어나면 안 됩니다.
 *
 * 균형을 잃어서 다른 발로 서거나 넘어져도 게임에서 집니다만, 재하와 영훈이는 젊고 활기차기 때문에 외발로 뛰어다니는 것은 아무것도 아닙니다. 다만 걱정되는 것은 주어진 게임판에 시작점에서 끝점으로 가는 방법이 존재하지 않을 수도 있다는 것입니다. 예를 들어 그림 (a)의 게임판에서는 사각형으로 표시된 칸들을 통해 끝에 도달할 수 있지만, 숫자가 하나 바뀐 그림 (b)에서는 그럴 수가 없습니다.
 *
 * 게임판이 주어질 때 왼쪽 위의 시작점에서 오른쪽 아래의 시작점에 도달할 수 있는 방법이 있는지 확인하는 프로그램을 작성하세요.
 *
 * 입력
 * 입력의 첫 줄에는 테스트 케이스의 수 C(C <= 50)가 주어집니다. 각 테스트 케이스의 첫 줄에는 격자의 크기 n(2 <= n <= 100)이 주어지고, 그 후 n줄에 각 n개의 숫자로 왼쪽 위부터 각 칸에 쓰인 숫자들이 주어집니다. 오른쪽 아래 있는 끝 점 위치에는 0이 주어집니다.
 *
 * 출력
 * 각 테스트 케이스마다 한 줄로, 시작점에서 끝 점으로 도달할 수 있을 경우 "YES"를, 아닐 경우 "NO"를 출력합니다. (따옴표 제외)
 */
public class JUMPGAME {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] array;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        int C = Integer.parseInt(br.readLine());
        while(C-- > 0){
            n = Integer.parseInt(br.readLine());
            array = new int[n][n];
            visited = new boolean[n][n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<n;j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean result = solution(0,0);
            System.out.println(result?"YES":"NO");
        }
    }
    public static boolean solution(int x,int y){
        if(x >=n || y >=n){ //array 범위를 벗어난 경우
            return false;
        }
        if(x==n-1 && y==n-1){ //끝지점에 다다랐을때
            return true;
        }
        if(visited[x][y]){ //한번 방문한 곳은 다시방문하지 않기위함
            return false;
        }else{
            visited[x][y] = true;
        }
        int jump = array[x][y];
        return solution(x+jump,y) || solution(x,y+jump);

    }
}
