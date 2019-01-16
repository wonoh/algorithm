package practice;

import java.util.Arrays;

/**
 * @author wonoh
 * 선택정렬 구현
 * 선택정렬 -> 자신의 인덱스에 맞는 값을 찾아 인덱스에 넣어줌
 */
public class SelectionSort {
    public SelectionSort(int[] array){
        for(int i=0;i<array.length;i++){
            int value = array[i];
            int index = Integer.MAX_VALUE;
            for(int j=i+1;j<array.length;j++){
                if(value > array[j]){
                    value = array[j]; //최소값 갱신
                    index = j; //인덱스 갱신
                }
            }
            if(index == Integer.MAX_VALUE){ //인덱스가 초기값이라면 현재 자기 자리에 정렬되어있는것이므로 지나감
                continue;
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp; // 현재 위치 i 를 가지고 구해놓은 index 값과 바꿔줌
            System.out.println(Arrays.toString(array));
        }

    }
    public static void main(String[] args) {
        int[] array = {9,1,6,8,4,3,2,0};
        new SelectionSort(array);

    }
    public static int min(int a,int b){
        return a < b ? a : b;
    }

}
