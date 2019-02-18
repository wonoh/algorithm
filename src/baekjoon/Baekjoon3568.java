package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        readLine();
        String type = st.nextToken();
        while (st.hasMoreTokens()) {
            StringBuilder result = new StringBuilder();
            result.append(type);
            String instance = st.nextToken();
            for (int i = instance.length() - 2; i >= 0; i--) {
                if (instance.charAt(i) == ']') {
                    result.append(instance.substring(i - 1, i + 1));
                    i--;
                } else if (instance.charAt(i) == '*' || instance.charAt(i) == '&') {
                    result.append(instance.substring(i, i + 1));
                }else{
                    result.append(" ");
                    result.append(instance.substring(0,i+1)+";");
                    break;
                }
            }

            System.out.println(result.toString());
        }

    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
