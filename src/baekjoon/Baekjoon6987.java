package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon6987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] win;
    static int[] draw;
    static int[] lose;
    static boolean[] result;

    public static void main(String[] args) throws IOException {
        win = new int[6];
        draw = new int[6];
        lose = new int[6];
        result = new boolean[4];
        for (int t = 0; t < 4; t++) {
            readLine();
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                win[i] = Integer.parseInt(st.nextToken());
                draw[i] = Integer.parseInt(st.nextToken());
                lose[i] = Integer.parseInt(st.nextToken());
                sum += win[i];
                sum += draw[i];
                sum += lose[i];
            }
            if (sum != 30) {
                result[t] = false;
            } else {
                find(t, 0, 1);
            }
        }
        for(boolean flag : result){
            if(flag){
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
    }

    public static void find(int testCase, int a, int b) {

        /*System.out.println("a -- "+a+"  b -- "+b);
        System.out.println(Arrays.toString(win));
        System.out.println(Arrays.toString(draw));
        System.out.println(Arrays.toString(lose));*/
        if (a == 6) {
            result[testCase] = true;
        } else if (b == 6) {
            find(testCase, a + 1, a + 2);
        } else {
            if (win[a] > 0 && lose[b] > 0) {
                win[a]--;
                lose[b]--;
                find(testCase, a, b + 1);
                win[a]++;
                lose[b]++;
            }
            if (draw[a] > 0 && draw[b] > 0) {
                draw[a]--;
                draw[b]--;
                find(testCase, a, b + 1);
                draw[a]++;
                draw[b]++;
            }
            if (lose[a] > 0 && win[b] > 0) {
                lose[a]--;
                win[b]--;
                find(testCase, a, b + 1);
                lose[a]++;
                win[b]++;
            }
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
