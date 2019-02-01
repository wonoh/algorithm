package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5585 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] COIN = {500,100,50,10,5,1};
    public static void main(String[] args) throws IOException {
        int payMoney = 1000-Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0;i<COIN.length;i++){
            int quotient = payMoney/COIN[i];
            System.out.println(quotient);
            if(quotient > 0){
                answer += quotient;
                payMoney -= COIN[i]*quotient;
            }
        }
        System.out.println(answer);
    }


}
