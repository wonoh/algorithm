package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2864 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {


        readLine();
        String x = st.nextToken();
        String y = st.nextToken();
        int max = Integer.parseInt(x.replace('6','5')) + Integer.parseInt(y.replace('6','5'));
        int min = Integer.parseInt(x.replace('5','6')) + Integer.parseInt(y.replace('5','6'));

        System.out.println(max+" "+min);

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
