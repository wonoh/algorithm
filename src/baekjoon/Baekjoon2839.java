package baekjoon;


import java.util.Scanner;

public class Baekjoon2839 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int answer = 0;
		while(n > 0) {
			if(n%5==0) {
				n-=5;
				answer++;
			}else if(n%3==0) {
				n-=3;
				answer++;
			}else if(n > 5) {
				n-=5;
				answer++;
			}else {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}
}
