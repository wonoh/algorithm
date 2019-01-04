package swacademy;

import java.util.Scanner;

public class SA6718 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		n = scan.nextInt();
		double[] array = new double[n];
		int[] result = new int[n];
		for(int i=0;i<n;i++) {
			array[i]=scan.nextDouble();
		}
		for(int j=0;j<n;j++) {
			double k = array[j]/1000;
			if(k < 0.1) {
				result[j] = 0;
			}else if(k >= 0.1 && k < 1){
				result[j]=1;
			}else if(k >= 1 && k < 10) {
				result[j]=2;
			}else if(k >=10 && k < 100) {
				result[j]=3;
			}else if(k >=100 && k < 1000) {
				result[j]=4;
			}else {
				result[j]=5;
			}
		}
		for(int x=0;x<n;x++) {
			System.out.println("#"+(x+1)+" "+result[x]);
		}

	}

}
