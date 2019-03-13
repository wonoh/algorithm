package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2580 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        map = new int[9][9];
        for(int i=0;i<9;i++){
            readLine();
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find();
    }

    public static void find() {
        int x = -1;
        int y = -1;
        loop:for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    if(map[i][j] == 0){
                        x = i;
                        y = j;
                        break loop;
                    }
            }
        }
        if(x==-1){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        for (int i = 1; i <= 9 ; i++) {
            if(!inArea(x,y,i) && !inHorizontal(x,y,i) && !inVertical(x,y,i)){
                map[x][y] = i;
                find();
                map[x][y] = 0;
            }
        }

    }

    public static boolean inVertical(int x,int y,int value){
        boolean isSame = false;
        for (int i = 0; i <9 ; i++) {
            if(i==x){
                continue;
            }
            if(map[i][y] == value){
                isSame = true;
                break;
            }
        }
        return isSame;
    }

    public static boolean inHorizontal(int x,int y,int value){
        boolean isSame = false;
        for (int i = 0; i <9 ; i++) {
            if(i==y){
                continue;
            }
            if(map[x][i] == value){
                isSame = true;
                break;
            }
        }
        return isSame;
    }
    public static boolean inArea(int x,int y,int value){
        boolean isSame = false;
        int from = 0;
        int to = 0;
        if (x < 3) {
            from = 0;
        }else if(x < 6){
            from = 3;
        }else{
            from = 6;
        }
        if(y < 3){
            to = 0;
        }else if(y < 6){
            to = 3;
        }else{
            to = 6;
        }
        loop:
        for (int i = from; i <= from + 2; i++) {
            for (int j = to; j <= to + 2; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if(map[i][j] == value){
                    isSame = true;
                    break loop;
                }
            }
        }
        return isSame;
    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
