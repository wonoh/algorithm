package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon7568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        N= Integer.parseInt(br.readLine());
        array = new int[N][2];
        for(int i=0;i<N;i++){
            readLine();
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            int ranking = 1;
            for(int j=0;j<N;j++){
                if(i==j){
                    continue;
                }
                if(array[i][0] < array[j][0] && array[i][1] < array[j][1]){
                    ranking++;
                }
            }
            System.out.print(ranking+" ");
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }


}
