package naver2020;

public class P3 {

    static int k = 11;
    static int[] num = {0,1,2,3,4,5,6,7,8,9};
    static int[] val = {6,2,5,5,4,5,6,3,7,6};
    static int result = 0;
    public static void main(String[] args) {
        int k = 6;
        find(0,0,"");
        System.out.println(result);

    }
    public static void find(int index,int count,String v){
        if(count == k){
            System.out.println("정답"+v);
            result++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(count+val[i] <= k){
                find(index+1,count+val[i],v+ i);
            }
        }

    }

}
