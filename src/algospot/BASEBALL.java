package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BASEBALL {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[] teamArray;
	static int[][] scoreArray;
	static double[] winRateArray;
	static String likeTeam;
	static int remaingGameNumber;
	static String[][] remaingGameArray;
	public static void main(String[] args) throws NumberFormatException, IOException {
		double asd = 129/77;
		System.out.println(asd);
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			System.out.println(solution());
		}

	}
	public static String solution() throws IOException {
		teamArray = new String[8];
		scoreArray = new int[8][3];
		winRateArray = new double[8];
		String result = "";
		for(int i=0;i<8;i++) {
			String line = br.readLine();
			st = new StringTokenizer(line," ");
			
			teamArray[i] = st.nextToken();
			
			int win = Integer.parseInt(st.nextToken());
			int draw = Integer.parseInt(st.nextToken());
			int lose = Integer.parseInt(st.nextToken());
			
			scoreArray[i][0] = win;
			scoreArray[i][1] = draw;
			scoreArray[i][2] = lose;
			
			double winRate = (double)win / (double)(win+draw+lose);	
			winRateArray[i] = winRate;
		}
		likeTeam = br.readLine();
		remaingGameNumber = Integer.parseInt(br.readLine());
		
		remaingGameArray = new String[remaingGameNumber][2];
		for(int i=0;i<remaingGameNumber;i++) {
			String line = br.readLine();
			st = new StringTokenizer(line," ");		
			remaingGameArray[i][0] = st.nextToken(); 
			remaingGameArray[i][1] = st.nextToken(); 
		}
		System.out.println(Arrays.toString(teamArray));
		System.out.println(Arrays.deepToString(scoreArray));
		System.out.println(Arrays.toString(winRateArray));
		System.out.println(Arrays.deepToString(remaingGameArray));
		
		
		return result;
	}

}
