package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon8958 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            String[] splitArray = br.readLine().split("");
            int answer = 0;
            int point = 0;
            boolean flag = false;
            for(int i=0;i<splitArray.length;i++){
                if(splitArray[i].equalsIgnoreCase("O") && flag){
                    point++;
                    answer+=point;
                }else if(splitArray[i].equalsIgnoreCase("O") && !flag){
                    point = 1;
                    flag = true;
                    answer+=point;
                }else{
                    flag = false;
                }
            }
            System.out.println(answer);
        }
    }

}
