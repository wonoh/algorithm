package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jg3333 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = arr[n - 1];

        int answer = 0;
        int temp = max;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > temp && arr[i] > max) {
                answer++;
                temp = arr[i];
            }
        }
        System.out.println(answer + 1);


    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
