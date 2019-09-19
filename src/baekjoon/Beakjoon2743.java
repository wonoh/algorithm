package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon2743 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        readLine();
        System.out.println(st.nextToken().length());

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
