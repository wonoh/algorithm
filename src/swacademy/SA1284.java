package swacademy;

import java.util.Scanner;

public class SA1284 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			int money = 0;
			int aMoney =0;
			int bMoney = 0;
			int P =scan.nextInt(); //a회사 리터당 요금
 			int Q =scan.nextInt(); // b회사 기본요금
			int R =scan.nextInt(); // b회사 요금초과 기준 리터
			int S =scan.nextInt(); // b회사 초과시 리터당 추가요금
			int W =scan.nextInt(); // 한달간 사용하는 리터
			aMoney = W*P;
			if(W>R) {
				bMoney = (W-R) * S +Q;
			}else {
				bMoney = Q;
			}
			money = Math.min(aMoney,bMoney);
			System.out.println("#"+i+" "+money);	
		}
	}
}
