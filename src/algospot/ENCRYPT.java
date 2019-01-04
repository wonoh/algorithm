package algospot;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author wonoh 특정 메시지를 암호화 하는 방법은 오랫 동안 다양하게 연구되었다.
 * 
 *         그러한 방법들 중에서 가장 간단한 방법을 생각해보자.
 * 
 *         특정 문자열을 입력받는다. 편의상 문자열에 공백은 없으며, 영문 대소문자가 입력으로 들어온다. 그러한 다음 문자열의 각
 *         문자에 맨 왼쪽부터 하나씩 0, 1, 2, 3, ... 과 같이 번호를 매긴다.
 * 
 *         만약 암호화 하려고 하는 문자열이 `HelloWorld' 가 들어왔을 경우, 다음과 같이 번호가 붙게 된다. 그 다음 짝수
 *         번호(2로 나눠 떨어지는 숫자, 0도 짝수에 포함한다.) 가 붙은 문자들을 번호가 빠른 순으로 다음과 같이 붙이고, 그 다음
 *         홀수 번호가 가 붙은 문자들을 번호가 빠른 순으로 그 뒤에붙인다. 위의 `HelloWorld'에 적용할 경우 결과는 다음과
 *         같다.
 * 
 *         HloolelWrd 문자열을 입력받은 다음, 위에 소개한 암호화를 수행하는 프로그램을 작성하라.
 * 
 *         입력 입력의 첫번째 줄에는 테스트 케이스의 개수 T(1<=T<= 10)이 입력된다.
 * 
 *         그 다음 줄 부터 T개의 줄에는 암호화를 하고자 하는 문자열이 입력된다. 문자열에는 공백이 포함되지 않으며, 문자열의 길이는
 *         100자를 넘지 않는다.
 * 
 *         출력 각 테스트 케이스의 순서대로 문자열을 암호화 한 결과를 한줄에 하나씩 출력한다.
 */
public class ENCRYPT {
	static String str;
	static Queue<Character> firstQueue; // 짝수번호 문자를 저장할 큐
	static Queue<Character> secondQueue; // 홀수번호 문자를 저장할 큐
	static StringBuilder sb; // 결과값을 출력할 StringBuilder

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			str = scan.next();
			firstQueue = new LinkedList<>();
			secondQueue = new LinkedList<>();  // 변수 초기화
 			for (int j = 0; j < str.length(); j++) {
				if (j % 2 == 0) {
					firstQueue.add(str.charAt(j)); // 짝수번호 add
				} else {
					secondQueue.add(str.charAt(j)); // 홀수번호 add
				}
			}
			sb = new StringBuilder();
			while (!firstQueue.isEmpty()) { // 큐가 비어있을때 까지 짝수부터 더함
				sb.append(firstQueue.poll()); 
			}
			while (!secondQueue.isEmpty()) { // 나머지경우 ( 홀수 ) 더함
				sb.append(secondQueue.poll());
			}
			System.out.println(sb.toString());
		}
	}
}
