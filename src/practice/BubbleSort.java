package practice;

import java.util.Arrays;

/**
 * @author wonoh
 * 버블정렬 구현
 *  버블정렬  -> 매번 연속된 두개 인덱스를 비교하여 정간 기준의 값을 뒤로 넘겨 정렬하는 방식
 */
public class BubbleSort {
    public BubbleSort(int[] array){
        for(int i=0;i<array.length;i++){ // 이 for 문이 한번 이루어질때마다 뒤에서부터 정렬됨.
            for(int j=1;j<array.length-i;j++){ //연속된 두개의 값을 비교하면서 정렬해감
                if(array[j-1] > array[j]){ // 앞의 숫자가 더 큰경우 바꿔줌
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
    public static void main(String[] args) {
        int[] array = {5,3,6,2,9};
        new BubbleSort(array);
    }
}
