package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1032 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {


        int n = Integer.parseInt(br.readLine());

        String first = br.readLine();
        String[] answer = first.split("");

        for (int i = 1; i < n; i++) {

            String word = br.readLine();
            for (int j = 0; j < first.length(); j++) {
                if(first.charAt(j) != word.charAt(j)){
                    answer[j] = "?";
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }


    }



}
