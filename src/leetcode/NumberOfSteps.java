package leetcode;

public class NumberOfSteps {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps (int num) {
        int step = 0;
        while (num != 0){
            System.out.println(num);
            step++;
            num = num % 2 == 0 ? num/2 : num-1;
        }
        return step;
    }
}
