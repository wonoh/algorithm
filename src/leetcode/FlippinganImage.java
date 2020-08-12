package leetcode;

import java.util.Arrays;

public class FlippinganImage {

    public static void main(String[] args) {
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(A)));

    }
    public static int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int start = 0;
            int len = A[i].length;
            int end = len-1;

            while (end - start > 0) {
                int tmp;
                tmp = A[i][start];
                A[i][start] = A[i][end];
                A[i][end] = tmp;
                start++;
                end--;
            }
        }
        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j <A[i].length ; j++) {
                A[i][j] = A[i][j]==0 ? 1 : 0;
            }
        }

        return A;

    }
}
