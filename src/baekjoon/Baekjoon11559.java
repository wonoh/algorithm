package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] map;
    static ArrayList<Node> list;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        map = new char[12][6];
        for(int i=0;i<12;i++){
            String input = br.readLine();
            for(int j=0;j<6;j++){
                map[i][j] = input.charAt(j);
            }
        }
        int boom = 0;
        while(true){
            boolean isBoom = false;
            visited = new boolean[12][6];
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(map[i][j] != '.' && !visited[i][j]){
                        list = new ArrayList<>();
                        dfs(i,j,map[i][j]);
                        if(list.size() >= 4){
                            isBoom = true;
                            for(Node n:list){
                                map[n.x][n.y] = '.';
                            }
                        }
                    }
                }
            }
            if(isBoom){
                boom++;
                fall();
            }else{
                break;
            }
        }
        System.out.println(boom);

    }

    private static void fall() {
        for(int i=0;i<6;i++){
            int start = -1;
            for(int j=11;j>=0;j--){
                if(map[j][i] == '.' && start == -1){
                    start = j;
                }
                if(map[j][i] != '.' && start != -1){
                    System.out.println(start);
                    char temp = map[j][i];
                    map[j][i] = '.';
                    map[start][i] = temp;
                    i--;
                    break;
                }
            }
        }
    }

    public static void dfs(int x,int y,char c){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6){
                continue;
            }
            if(!visited[nx][ny] && map[nx][ny] == c){
                visited[nx][ny] = true;
                list.add(new Node(nx,ny));
                dfs(nx,ny,map[nx][ny]);
            }
        }

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
    static class Node{
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
