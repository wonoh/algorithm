package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SA2007 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
                String str = br.readLine();
                int index = 0;
                int plus = 1;
                while(true){
                    String prev = str.substring(index,plus);
                    String next = str.substring(plus,plus*2);
                    System.out.println(prev);
                    System.out.println(next);
                    if(prev.equalsIgnoreCase(next)){
                        break;
                    }
                    plus++;
                }

            System.out.println("#"+a+" "+plus);

        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
