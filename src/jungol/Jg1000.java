package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 두 정수 a b를 입력 받는다. (1 <= a, b <= 1,000)
 */
public class Jg1000 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

            readLine();
        System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
