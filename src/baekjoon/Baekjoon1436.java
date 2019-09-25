package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1436 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());



        int answer = 666;
        int i = 1;

        while(n != i){

            answer++;
            if(String.valueOf(answer).contains("666")){
                i++;
            }

        }
        System.out.println(answer);

    }

}
