package Programmers_test_2;

/**
 * @author wonoh
 * 빙고는 NxN 크기의 게임 보드 칸에 1부터 NxN까지의 자연수를 중복 없이 하나씩 적은 후 숫자를 하나씩 지워나가는 게임입니다. 이때, 가로, 세로, 대각선 방향으로 한 줄에 적힌 숫자를 모두 지울 경우 빙고를 1개 만들었다고 합니다.
 * 다음은 4X4 크기의 게임 보드를 이용해 게임을 진행한 예시입니다.
 *
 * image
 *
 * 위와 같이 각 칸에 숫자가 적혀 있을 때, 위 게임 보드에서 순서대로 지운 숫자가 [14,3,2,4,13,1,16,11,5,15]인 경우 아래와 같이 빙고 3개가 만들어집니다.
 *
 * image
 *
 * 빙고 게임 보드에 적힌 숫자가 담겨있는 배열 board, 게임 보드에서 순서대로 지운 숫자가 들어있는 배열 nums가 매개변수로 주어질 때, board에서 nums에 들어있는 숫자를 모두 지우면 몇 개의 빙고가 만들어지는지 return하도록 solution함수를 완성해주세요.
 *
 * 제한사항
 * board는 게임 보드 칸에 적힌 숫자를 뜻하는 NxN크기의 2차원 배열이며, N은 2 이상 500이하의 자연수입니다.
 * board의 각 칸에는 1 이상 NxN이하의 자연수가 중복 없이 하나씩 들어있습니다.
 * nums는 board에서 지울 숫자가 들어있는 배열이며, 길이는 1 이상 NxN이하입니다.
 * nums에 들어있는 숫자는 1 이상 NxN이하의 자연수이며, 중복된 수가 들어있지 않습니다.
 */
public class P3 {
    static int size;

    public static void main(String[] args) {
        int[][] board = {{11, 13, 15, 16}, {12, 1, 4, 3}, {10, 2, 7, 8}, {5, 14, 6, 9}};
        int[] nums = {14, 3, 2, 4, 13, 1, 16, 11, 5, 15};
        System.out.println(solution(board, nums));
    }

    public static int solution(int[][] board, int[] nums) {
        size = board.length;
        boolean[][] selected = new boolean[size][size];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (num == board[x][y]) {
                        selected[x][y] = true;
                    }
                }
            }
        }
        int answer = getBingoCount(selected);
        return answer;
    }

    public static int getBingoCount(boolean[][] selected) {
        int bingo = 0;
        for (int i = 0; i < size; i++) {
            int horizontalCount = 0;
            for (int j = 0; j < size; j++) {
                if (!selected[i][j]) {
                    break;
                }
                if (selected[i][j]) {
                    horizontalCount++;
                }
            }
            if (horizontalCount == size) {
                bingo++;
            }
        }
        for(int i=0;i<size;i++){
            int verticalCount = 0;
            for(int j=0;j<size;j++){
                if(!selected[j][i]){
                    break;
                }
                if(selected[j][i]){
                    verticalCount++;
                }
            }
            if (verticalCount == size) {
                bingo++;
            }
        }
        int diagonalCount = 0;

        for (int i = 0; i < size; i++) {
            if(!selected[i][i]){
                break;
            }
            if (selected[i][i]) {
                diagonalCount++;
            }
        }
        int j = size - 1;
        int reverseDiagonalCount = 0;
        for(int k=0;k<size;k++){
            if(!selected[k][j]){
                break;
            }
            if(selected[k][j]){
                reverseDiagonalCount++;
            }
            j--;
        }
        if (diagonalCount == size) {
            bingo++;
        }
        if (reverseDiagonalCount == size) {
            bingo++;
        }
        return bingo;

    }
}
