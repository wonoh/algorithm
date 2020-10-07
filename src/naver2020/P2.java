package naver2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2 {


    public static void main(String[] args) {

        int n = 9;
        int[][] edges = {{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}};
        int[][] node = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            node[edges[i][0]][edges[i][1]] = node[edges[i][1]][edges[i][0]] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            for (int j = i+1; j < edges.length ; j++) {
                node[edges[i][0]][edges[i][1]] = node[edges[i][1]][edges[i][0]] = 0;
                node[edges[j][0]][edges[j][1]] = node[edges[j][1]][edges[j][0]] = 0;
                boolean[][] visited = new boolean[node.length][node.length];
                int count = 0;
                for (int k= 0; k < node.length; k++) {
                    for (int h = k+1; h < node.length ; h++) {
                        if(node[k][h] == 1 && !visited[k][h]){
                            bfs(k, visited,node);
                            count++;
                        }
                    }
                }
                if(count == 3){
                    System.out.println(i+"  "+j);
                }
                node[edges[i][0]][edges[i][1]] = node[edges[i][1]][edges[i][0]] = 1;
                node[edges[j][0]][edges[j][1]] = node[edges[j][1]][edges[j][0]] = 1;
            }
        }
    }
    public static void bfs(int start, boolean[][] visited, int[][] node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int x = queue.poll();

            for (int i = 0; i < visited.length; i++) {
                if(node[x][i] == 1 && !visited[x][i]){
                    visited[x][i] = true;
                    queue.offer(x);
                }
            }
        }
    }

}
