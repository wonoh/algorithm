package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1≤M≤100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수들의 범위는 int 로 한다.
 * <p>
 * 출력
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 */
public class Baekjoon1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] array;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int index = 0;
        while (st.hasMoreTokens()) {
            array[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        Arrays.sort(array);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int result = binarySearch(array, Integer.parseInt(st.nextToken()));
            if (result >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    public static int binarySearch(int[] array, int value) { // 이진탐색
        int left = 0;
        int right = array.length-1;

        while(left <= right){
            int mid = (left+right) / 2;
            if(array[mid] > value){
                    right = mid - 1;
            }else if(array[mid] < value){
                    left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void selectionSort(int[] array){

    }


}
