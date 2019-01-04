package swacademy;

import java.util.Scanner;

public class SA1215 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 1;
		for (int i = 1; i <= T; i++) {
			int palinNum = scan.nextInt();
			StringBuilder sb3= new StringBuilder();
			char[][] array = new char[8][8];
			for(int x=0;x<8;x++) {
				String str = scan.next();
				for(int y=0;y<8;y++) {
					array[x][y]=str.charAt(y);
				}
			}
			int count = 0;
			for(int row=0;row<8;row++) {
				StringBuilder sb= new StringBuilder();
				StringBuilder sb2= new StringBuilder();
				for(int col=0;col<8;col++) {
					sb.append(array[row][col]);
					sb2.append(array[col][row]);
				}
				if(row==0) {
					System.out.println(sb.toString());
					System.out.println(sb2.toString());					
				}
				for(int n=0;n<=sb.length()-palinNum;n++) {
					sb3.append(sb.substring(n,palinNum+n));
					System.out.println("짜른값"+sb3.toString());
					if(sb3.toString().equalsIgnoreCase((sb3.reverse().toString()))) {
						count++;
					}
					sb3.setLength(0);				
				}
				for(int j=0;j<=sb2.length()-palinNum;j++) {
					sb3.append(sb2.substring(j,palinNum+j));
					if(sb3.toString().equalsIgnoreCase((sb3.reverse().toString()))) {
						count++;
					}
					sb3.setLength(0);
				}
			}
			System.out.println("#"+i+" "+count);
		}
	}
}
