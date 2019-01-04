package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13420 {
	static final String MUL = "*";
	static final String PLUS = "+";
	static final String SUB = "-";
	static final String DIV = "/";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String line = br.readLine();
			StringTokenizer st =  new StringTokenizer(line," ");
			System.out.println(solution(st));	
		}
	}
	public static String solution(StringTokenizer st) {
		String result = "";
		long firstOperand =Long.parseLong(st.nextToken());
		String operator = st.nextToken();
		long secondOperand = Long.parseLong(st.nextToken());
		String equality = st.nextToken();
		long answer = Long.parseLong(st.nextToken());
		long correctAnswer = 0;
		
		switch (operator) {
		
		case MUL:
			correctAnswer = firstOperand * secondOperand;
			break;
		case PLUS:
			correctAnswer = firstOperand + secondOperand;
			break;
		case DIV:
			correctAnswer = firstOperand / secondOperand;
			break;
		case SUB:
			correctAnswer = firstOperand - secondOperand;
			break;
		default:
			break;
		}
		if(answer == correctAnswer) {
			result = "correct";
		}else {
			result = "wrong answer";
		}
		return result;
	}
}
