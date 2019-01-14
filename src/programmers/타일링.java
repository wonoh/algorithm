package programmers;

import java.io.IOException;
import java.util.Arrays;

public class 타일링 {
    public static void main(String[] args)throws IOException {
        int n =5000;
        System.out.println(solution(n));
    }
    public static long solution(int n) {
        long answer = 0;
        long[] array = new long[n];
        array[0]=1;
        array[1]=2;
        for(int i=2;i<array.length;i++){
            array[i]=array[i-2]%100000007+array[i-1]%100000007;
        }
        System.out.println(Arrays.toString(array));
        answer = array[n-1];
        return answer;
    }

}
