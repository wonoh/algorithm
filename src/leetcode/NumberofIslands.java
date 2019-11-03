package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) {

        char[][] grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        if(grid.length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length ; j++) {

                if(!visited[i][j] && grid[i][j] == '1'){
                    findLand(visited,queue,i,j,grid);
                    answer++;
                }

            }
        }
        return answer;

    }
    private static void findLand(boolean[][] visited,Queue<Node> queue,int x,int y,char[][] grid){

        visited[x][y] = true;
        queue.add(new Node(x,y));

        while(!queue.isEmpty()){

            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= visited.length || ny >= visited.length ){
                    continue;
                }
                if(!visited[nx][ny] && grid[nx][ny] == '1'){
                    visited[nx][ny] = true;
                    queue.add(new Node(nx,ny));
                }

            }


        }



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
