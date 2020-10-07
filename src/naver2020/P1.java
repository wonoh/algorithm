package naver2020;

import java.util.Arrays;
import java.util.OptionalDouble;

public class P1 {

    public static void main(String[] args) {
        int n = 7;
        int[] p = {6,2,1,0,2,4,3};
        int[] c = {3,6,6,2,3,7,6};
        System.out.println(solution(n,p,c));
    }

    public static String solution(int n ,int[] p,int[] c){
        boolean[] satisfied = new boolean[n];
        int[] sales = new int[n];
        int remainBall = 0;
        int days = n;
        for (int i = 0; i < n; i++) {
            int makeAmount = p[i];
            int orderAmount = c[i];

            System.out.print(i+1+" 째날 남아있는공"+remainBall);
            System.out.print("orderAmount = " + orderAmount);
            System.out.print("makeAmount = " + makeAmount);
            System.out.println();

            if((makeAmount+remainBall) >= orderAmount){
                satisfied[i] = true;
                remainBall = (makeAmount+remainBall) - orderAmount;
                System.out.println("거래!");
            }else{
                System.out.println("거래 위반");
                remainBall = makeAmount + remainBall;
                System.out.println(remainBall);
            }
            if(satisfied[i]){
                Count count = getCount(i, satisfied);
                System.out.println(i+1+" 거래때 가격"+count.price);
                if(count.price == 0){
                    days = i;
                    break;
                }
                sales[i] = orderAmount * count.price;
            }
        }
        double sum = 0;
        for (int sale : sales) {
            System.out.print(sale+ "  ");
            sum += sale;
        }
        double result = sum / days;
        String.format("%.2f", result);




        return String.format("%.2f", result);

    }
    public static Count getCount(int n,boolean[] satisfied){
        int count  = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(satisfied[i]){
                break;
            }
            if(!satisfied[i]){
                count++;
            }
        }
        return Count.countOf(count);
    }
    enum Count {
        NONE(0,100),
        ONE(1,50),
        TWO(2,25),
        THREE(3,0),
        FOUR(4,0);

        private final int count;
        private final int price;

        Count(int count, int price) {
            this.count = count;
            this.price = price;
        }

        public static Count countOf(int count){
            return Arrays.stream(values())
                    .filter(value -> value.count == count)
                    .findFirst().orElseThrow();
        }
    }


}

