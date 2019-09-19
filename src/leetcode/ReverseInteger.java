package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReverseInteger {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        readLine();
        System.out.println(reverse(Integer.parseInt(st.nextToken())));

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

    private static int reverse(int x) {

        StringBuilder answer = new StringBuilder();

        boolean minus = false;

        if(x < 0){
            minus = true;
        }

        String temp = String.valueOf(x);
        String[] arr = temp.split("");

        for (int i = arr.length-1; i >= 0; i--) {

            if(arr[i].equals("0") || arr[i].equals("-")){
                continue;
            }
            answer.append(arr[i]);
        }
        long result = Long.valueOf(answer.toString());
        if(result > Integer.MAX_VALUE){
            return 0;
        }
        if(minus){
            answer.insert(0,"-");
        }
        return Integer.parseInt(answer.toString());
    }
}
