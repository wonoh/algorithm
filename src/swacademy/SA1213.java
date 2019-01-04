package swacademy;

import java.util.Scanner;

public class SA1213 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int n = scan.nextInt();
			String str = scan.next();
			StringBuilder sb = new StringBuilder();
			sb.append(scan.next());
			int count=0;
			while(true) {
				int index = sb.indexOf(str);
				if(index > -1) {
					count++;
					sb.delete(index,str.length()+index);
				}else {
					break;
				}
			}
			System.out.println("#"+n+" "+count);		
		}
	}
}
