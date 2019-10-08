package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> queue;
    static boolean[][] visited;

    public static void main(String[] args) {

        int[][] grid = {{1,1},
                        {0,1},
                        {1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        queue = new LinkedList<>();
        visited = new boolean[grid.length][grid[0].length];
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    answer = Math.max(findConnectedArea(i, j,grid), answer);
                    System.out.println(answer);
                }
                for (int k = 0; k < visited.length; k++) {
                    Arrays.fill(visited[k],false);
                }
            }
        }
        return answer;

    }

    private static int findConnectedArea(int x, int y,int[][] grid) {
        queue.add(new Node(x, y));
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {

            Node now = queue.poll();
            System.out.println(now);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[x].length) {
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                if(grid[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.add(new Node(nx,ny));
                    count++;
                }
            }

        }
        return count;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
