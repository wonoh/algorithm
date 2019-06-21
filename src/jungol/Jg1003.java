package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Jg1003 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {


        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        int[] re = new int[size];

        readLine();

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <size ; i++) {
            re[i] = i+1;
            if(arr[i] > 0){
                int temp = re[i];
                for (int j = i; j > i-arr[i]; j--) {
                    re[j] = re[j-1];
                }
                re[i-arr[i]] = temp;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(re[i]+" ");
        }

    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
