package swacademy;

import java.util.Scanner;
import java.util.Vector;

public class PrisonBreak {
	static int Nsize;
	static int Msize;
	static Vector<Integer> N; // 톨게이트 통과한 차량수
	static int[] M; // 가능한 색상 수
	static Vector<Integer> match;
	static int result = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			Nsize = scan.nextInt();
			Msize = scan.nextInt();
			N = new Vector<>();
			M = new int[Msize];
			for (int j = 0; j < Msize; j++) {
				M[j] = scan.nextInt();
			}
			for (int j = 0; j < Nsize; j++) {
				N.add(scan.nextInt());
			}
			match = new Vector<>();
			for (int n = 0; n < Msize; n++) {
				if (M[n] > 0) {
					while (M[n] > 0) {
						match.add(n + 1);
						M[n] -= 1;
					}
				}
			}
			for (int x = 0; x <= Nsize - match.size(); x++) {
				Vector<Integer> v = (Vector<Integer>) match.clone();
				if (match.contains(N.get(x))) {
					int index = v.indexOf(N.get(x));
					if(index > 0) {
						v.remove(index);						
						for (int y = x + 1; y < x+match.size(); y++) {
							System.out.println("yy"+y);
							if(match.contains(N.get(y))) {
								int rindex = v.indexOf(N.get(y));
								if(rindex > 0) {
									v.remove(rindex);									
								}else {
									break;
								}
							}else {	
								break;
							}
						}
					}
				}
				if(v.size()==0) {
					result = x+1;
					break;
				}
			}
			System.out.println(result);
			System.out.println(match.toString());
			System.out.println(N.toString());
		}

	}

}
