package swacademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SA1220Best {
 
    static int Q;
    static int[][] map;
    static final int N = 1;
    static final int S = 2;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc = 1; tc <=10; tc++) {
            Q = Integer.parseInt(br.readLine());
            map = new int[Q][Q];
            for(int i = 0 ; i < Q ; i ++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < Q ; j ++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > 0 ) {
                        queue.add(new Node(i,j));
                    }
                }
            }
            while(!queue.isEmpty()) {
                int size = queue.size();
                 
                 
                for(int i = 0 ; i < size; i ++) {
                    Node u = queue.poll();
                     
                    if(map[u.row][u.col] == N) {
                        int nextRow = u.row + 1;
                        if(nextRow > Q-1) { 
                            map[u.row][u.col] = 0;
                            continue;
                        }
                        if(map[nextRow][u.col] == S) continue;
                        map[u.row][u.col] = 0;
                        map[nextRow][u.col] = N;
                        queue.add(new Node(nextRow, u.col));
                    }
                    else if(map[u.row][u.col] == S) {
                        int nextRow = u.row - 1;
                        if(nextRow < 0 ) {
                            map[u.row][u.col] = 0;
                            continue;
                        }
                        if(map[nextRow][u.col] == N ) continue;
                        map[u.row][u.col] = 0;
                        map[nextRow][u.col] = S;
                        queue.add(new Node(nextRow, u.col));
                    }
                }
                 
            }
            int count = 0;
            for(int i = 0 ; i < Q ; i ++) {
                for(int j = 0 ; j < Q ; j ++) {
                    if(map[i][j] == N && map[i+1][j]==S) {
                        count ++;
                    }
                }
            }
            System.out.println("#"+ tc + " " + count);
             
        }
    }
}

class Node{
    int row;
    int col;
    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
