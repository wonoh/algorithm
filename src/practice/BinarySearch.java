package practice;

/**
 * @author wonoh
 * 이진 탐색
 * 이진탐색 -> 배열이 정렬되어있을때 특정한 값을 찾음음 */
public class BinarySearch {
    public static int BinarySearch(int[] array,int value){
        int low = 0;
        int high = array.length-1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(array[mid] > value){
                high = mid - 1;
            }else if(array[mid] < value){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {1,2,8,10,60,90,123};
        int result = BinarySearch(array,123);
        System.out.println(result);
    }
}
