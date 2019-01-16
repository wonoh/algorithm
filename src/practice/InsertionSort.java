package practice;



import java.util.Arrays;

/**
 * @author wonoh
 * 삽입정렬 구현
 * 삽입정렬 -> 이미 정렬된 부분과 비교하여 자신의 위치를 찾아 삽입
 */
public class InsertionSort {
    public InsertionSort(int[] array){
        for(int i=1;i<array.length;i++){ // 배열의 첫번째요소는 정렬되어있다고 가정하고 두번째요소부터 전과 비교하여 자신의 위치를 찾음
            int index = i; // 자신보다 큰 값을 여러번 만났을때 갱신할 인덱스
            for(int j=i-1;j>=0;j--){ // i 이전 배열을 돌면서
                if(array[index]<array[j]){ //자기보다 클때
                    int temp = array[index];
                    array[index] = array[j];
                    array[j] = temp; //값을 바꾸어주고
                    index = j; // 바뀐 인덱스 갱신
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
    public static void main(String[] args) {
        int[] array = {31,25,12,22,11};
        new InsertionSort(array);
    }
    public static int min(int a,int b){
        return a < b ? a : b;
    }

}
