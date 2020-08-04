package leetcode;

import java.util.Arrays;

public class RotateImage {

    /**
     *  [7,4,1],
     *  [8,5,2],
     *  [9,6,3]
     *  0,0 -> 0,2  0,1 -> 1,2 0,2 -> 2,2
     *  1,0 -> 0,1 1,1 -> 1,1 1,2 -> 2,1
     *  2,0 -> 0,0 2,1 -> 1,0 2,2 -> 2,0
     */
    public static void main(String[] args) {
        int[][] m = {{1,2,3},
                    {4,5,6},
                    {7,8,9}};
        rotate(m);

    }
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] tmp = new int[matrix.length][matrix.length];
        int y = 0;
        for (int i = 0; i < length; i++) {
            int x = length-1;
            for (int j = 0; j < length; j++) {
                tmp[i][j] = matrix[x][y];
                x--;
            }
            y++;
        }
        System.arraycopy(tmp,0,matrix,0,tmp.length);


    }

}
