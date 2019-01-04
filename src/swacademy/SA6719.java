package swacademy;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class SA6719 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		Vector<Vector<Integer>> levelList = new Vector<>();
		int[][] course = new int[s][2];
		for(int i=0;i<s;i++) {
			course[i][0] = scan.nextInt();
			course[i][1] = scan.nextInt();
			Vector<Integer> level = new Vector<>();
			for(int j=0;j<course[i][0];j++) {
				level.add(scan.nextInt());
			}
			Collections.sort(level);				
			
			levelList.add(level);
		}
		for(int x=0;x<s;x++) {
			Float A = (float) 0;
			for(int y=course[x][0]-course[x][1];y<levelList.get(x).size();y++) {
				A = (A + levelList.get(x).get(y)) / 2; 
			}
			System.out.println("#"+(x+1)+" "+A);
		}
	}

}
