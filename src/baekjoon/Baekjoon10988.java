package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10988 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        String word = br.readLine();

        int length = word.length();

        int start = 0;
        int end = length-1;
        int answer = 1;

        while(start < length/2){
            if(word.charAt(start)!=word.charAt(end)){
                answer = 0;
                break;
            }
            start++;
            end--;
        }

        System.out.println(answer);


    }




}
