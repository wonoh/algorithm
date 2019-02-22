package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] asc = {1,2,3,4,5,6,7,8};
    static int[] desc = {8,7,6,5,4,3,2,1};
    public static void main(String[] args) throws IOException {
        readLine();
        int i = 0;
        boolean isAsc = true;
        boolean isDesc = true;
        while(st.hasMoreTokens()){
            int val = Integer.parseInt(st.nextToken());
            if(asc[i]!=val){
                isAsc = false;
            }
            if(desc[i]!=val){
                isDesc = false;
            }
            i++;
        }
        if(isAsc){
            System.out.println("ascending");
        }else if(isDesc){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
