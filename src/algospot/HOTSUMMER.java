package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HOTSUMMER {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            int usage = Integer.parseInt(br.readLine());
            int sum = 0;
            readLine();
            for(int i=0;i<9;i++){
                sum += Integer.parseInt(st.nextToken());
            }
            StringBuilder result = new StringBuilder();
            if(sum <= usage){
                result.append("YES");
            }else{
                result.append("NO");
            }
            System.out.println(result.toString());
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
