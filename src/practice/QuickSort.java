package practice;

import java.util.Arrays;

/**
 * @author wonoh
 * 퀵 정렬
 * 퀵 정렬 ->
 */
public class QuickSort {

    public static void quickSort(int begin,int end,int[] array){
            if(begin < end){
                int partiotionIndex = partition(begin,end,array);
                quickSort(begin,partiotionIndex-1,array);
                quickSort(partiotionIndex+1,end,array);
            }
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        int[] array = {5,3,6,2,9,1,4};
        quickSort(0,array.length-1,array);

    }

    /**
     * @authow wonoh
     * @param begin
     * @param end
     * @param array
     * @return
     *  피벗을 기준으로 함수가 한번 실행될때마다 피벗보다 작은수는 왼쪽 큰수는 오른쪽으로 정렬된다.
     */
    public static int partition(int begin,int end,int[] array){
        int pivot = array[(begin+end) / 2];

        while(begin < end){
            while(array[begin] < pivot && begin < end){
                begin++;
            }
            while(array[end] > pivot && begin < end){
                end--;
            }
            if(begin < end){
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
        return begin;
    }
}
