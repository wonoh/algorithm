package algospot;

import java.util.Scanner;

public class CSBASEBALL {
	static int Ascore;
	static int Bscore;
	static int hits;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			Ascore = scan.nextInt();
			Bscore = scan.nextInt();
			if(Ascore>Bscore) {
				hits=0;
			}else {
				hits=(Bscore-Ascore+1)+3;
			}
			System.out.println(hits);
		}
	}
}
