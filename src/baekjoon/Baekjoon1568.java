package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int time = 1;
        int count = 1;
        while(true) {
            if (n - count <0) {
                count = 1;
                n -=count;
            }else{
                n -= count;
            }
            if(n==0){
                break;
            }
            count++;
            time++;

        }
        System.out.println(time);
    }


}
