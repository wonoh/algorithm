package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1094 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int START = 64;

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(START);
        readLine();
        int x = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int val : list) {
            sum += val;
        }
        if (x == 64) {
            System.out.println(1);
        } else {
            while (true) {
                int index = -1;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < list.size(); i++) {
                    if (min > list.get(i)) {
                        index = i;
                        min = list.get(i);
                    }
                }
                int mid = list.get(index) / 2;
                list.remove(index);
                for (int i = 0; i < 2; i++) {
                    list.add(mid);
                    int sumExpectOneRod = 0;
                    if (i == 0) {
                        for (int val : list) {
                            sumExpectOneRod += val;
                        }
                    }
                    if (sumExpectOneRod >= x) {
                        break;
                    }
                }

                sum = 0;
                for (int val : list) {
                    sum += val;
                }
                if (sum == x) {
                    break;
                }
            }
            System.out.println(list.toString());
            System.out.println(list.size());
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
