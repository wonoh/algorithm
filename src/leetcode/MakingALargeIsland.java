package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MakingALargeIsland {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> queue;
    static boolean[][] visited;

    public static void main(String[] args) {

        int[][] grid ={{0,0,0,0,0,0,0}
                      ,{0,1,1,1,1,0,0}
                      ,{0,1,0,0,1,0,0}
                      ,{1,0,1,0,1,0,0}
                      ,{0,1,0,0,1,0,0}
                      ,{0,1,0,0,1,0,0}
                      ,{0,1,1,1,1,0,0}};
        System.out.println(largestIsland(grid));

    }
    public static int largestIsland(int[][] grid) {
        queue = new LinkedList<>();
        visited = new boolean[grid.length][grid[0].length];

        boolean notZero = true;
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if(grid[i][j] == 0){
                    answer = Math.max(answer,findConnectedArea(i,j,grid));
                    notZero = false;

                    for (boolean[] booleans : visited) {
                        Arrays.fill(booleans, false);
                    }
                }

            }
        }
        if(notZero){
            return grid.length*grid[0].length;
        }
        return answer;

    }
    private static int findConnectedArea(int x,int y,int[][] grid){

        visited[x][y] = true;
        queue.add(new Node(x,y));
        int count = 1;

        while(!queue.isEmpty()){

            Node now =  queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length ){
                    continue;
                }
                if(!visited[nx][ny] && grid[nx][ny] == 1){
                    count++;
                    queue.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }

        }
        return count;

    }
    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
