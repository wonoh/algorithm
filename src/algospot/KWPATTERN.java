package algospot;

import java.util.Scanner;

/**
 * 
 * @author wonoh 서기 2222년, cdinside 알고스팟 갤러리에서 WonhaJin은 무패 전설의 키보드 워리어로 유명하다.
 *         WonhaJin은 항상 만년떡밥을 던짐으로써 낚여든 상대방을 무참히 공격하여 굴복시키곤 했다. 이러한 패턴으로 그는 한 번도
 *         키보드 배틀에서 패배한 적이 없다.
 * 
 *         한편, 그동안 그와 대등하게 승부했지만 한 번도 이겨 본 적이 없는 숙명의 라이벌 WookMan은 WonhaJin에게 패배를
 *         안겨주고자 22개월간 WonhaJin의 키보드 배틀 패턴을 파악하고자 노력하였다.
 * 
 *         그러던 도중 2222년 2월 22일 22시 22분 22초에 그가 뻘글을 쓰는 것을 확인하였다. 이는 키보드 워리어에게 있어
 *         치명적인 약점이다. WookMan은 이로부터 그가 성시마다 약점을 보인다는 가설을 세웠다. 성시란 다음과 같다:
 * 
 *         어떤 시각이 24시간제 기준으로 X 년 Y 월 Z 일 A시 B분 C 초이면, 이를 XY ZABC 의 형태로 이어 붙인 것과
 *         그것을 뒤집은 문자열이 서로 같을 때 그 시각은 성시이다. 시각은 그레고리력(양력) 을 따라 4의 배수 해는 2월이
 *         29일까지 있는 윤년이다. 단, 100의 배수 해는 윤년이 아니지만 400의 배수 해는 윤년이다. X는 네 자리에 맞추어
 *         표기하며, 나머지는 두 자리에 맞추어 표기한다. 모자라는 자리는 “0”으로 채운다. 예를 들어 2011년 9월 20일 23시
 *         57분 11초의 경우, 20110920235711인데 이는 이를 뒤집은 11753202901102와 다르기 때문에 성시가
 *         아니다. 한편 2011년 12월 11일 21시 11분 2초의 경우 20111211211102이므로 성시이다.
 * 
 *         이러한 패턴을 이용하여 WonhaJin을 공격하고자 WookMan은 1970년 1월 1일 0시 0분 0초 (이는
 *         프로그래머들에게 있어 현존하는 모든 역사가 시작된 시간이다) 부터 N 번째로 등장하는 성시를 찾는 프로그램을 작성하려고
 *         하였는데, 최근 취업과 육아를 동시에 시작하여 너무 바쁜 나머지 추종자들에게 도움을 요청하였 다.
 * 
 *         WookMan의 꼼꼼함에 반한 추종자인 당신은 이 프로그램을 작성해주어야 한다.
 * 
 *         입력 입력은 여러 개의 테스트 케이스로 구성된다. 입력의 첫 행에는 테스트 케이스의 수 T 가 주어진다.
 * 
 *         각 테스트 케이스는 하나의 행으로 이루어져 있는데, 그 행에는 양의 정수 N (1 ≤ N ≤ 10000)이 주어진다.
 * 
 *         출력 각 테스트 케이스에 대해 N 번째 성시를 한 행에 하나씩 “XXXX-YY-ZZ AA:BB:CC” 의 형식으로 출력한다.
 */
public class KWPATTERN {
	static final String[] DAY = {"11","22"};
	static final String[] MONTH = {"01","02","10","11","12"};
	static final int ALLSAME_PER_YEAR = 10;
	static int START = 2000;
	static int START2 = 2000;
	static int[] YEARS;
	static int N;
	static int YEAR_QUOTIENT;
	static int YEAR_REMAINDER;
	static int MONTH_QUOTIENT;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		initYears();
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			N = scan.nextInt();
			int year = 0;
			year = getYears(N - 1);
			String month = getMonth();
			String day = getDay();
			String result = makeResult(year,month,day);
			System.out.println(result);
		}
	}
	/**
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * 	구한 년도 월 일을 가지고 yyyy-mm-dd hh:mm:ss 형식에 맞추어 대칭이 되도록 뒤집어 결과 생성
	 * @return result 
	 */
	public static String makeResult(int year,String month,String day) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		String sYear = String.valueOf(year);
		String sMonth = month;
		String sDay = day;
		sb2.append(sMonth);
		String hour = sb2.reverse().toString();
		sb2.setLength(0);
		sb2.append(sYear.substring(0,2));
		String second = sb2.reverse().toString();
		sb2.setLength(0);
		sb2.append(sYear.substring(2,4));
		String minute = sb2.reverse().toString();
		sb.append(sYear)
		  .append("-")
		  .append(sMonth)
		  .append("-")
		  .append(sDay)
		  .append(" ")
		  .append(hour)
		  .append(":")
		  .append(minute)
		  .append(":")
		  .append(second);
		
		return sb.toString();
	}
	/**
	 * 
	 * @param num 
	 *  몇번째 성시인지 입력받아 년도를 구함
	 */
	public static int getYears(int num) {
		YEAR_QUOTIENT = num / ALLSAME_PER_YEAR;
		YEAR_REMAINDER = num % ALLSAME_PER_YEAR;
		int year = YEARS[YEAR_QUOTIENT];
		return year;
	}
	/**
	 *  앞서 구한 년도의 몫으로 월을 구함
	 * @return
	 */
	public static String getMonth() {
		MONTH_QUOTIENT = YEAR_REMAINDER / 2;
		String month = MONTH[MONTH_QUOTIENT];
		return month;
	}
	/**
	 *  앞서 구한 년도의 나머지로 일을 구함
	 * @return
	 */
	public static String getDay() {
		int remainder = YEAR_REMAINDER % 2;
		String day = DAY[remainder];
		return day;
	}
	/**
	 * 가능한 모든 year 초기화 시켜주기
	 * 1970년부터 시작하지만 조건에 만족하기위해서는 2000년부터 시작해야함.
	 * 2번째 4번째 자리에 5보다 큰 숫자가 들어갈 경우 각각 1000 과 10을 더해줌.
	 * ex) 2000,2001,2002 ... 2005,2010 ...4463 
	 */
	public static void initYears() {
		YEARS = new int[1000];
		YEARS[0] = START;
		for (int i = 1; i < 1000; i++) {
			String s = String.valueOf(YEARS[i - 1]);
			if (Integer.parseInt(s.split("")[s.length() - 1]) > 5) {
				YEARS[i - 1] = START + 10;
				START = YEARS[i - 1];
			}
			String z = String.valueOf(START);
			if (Integer.parseInt(z.split("")[1]) > 5) {
				YEARS[i - 1] = START2 + 1000;
				START2 = YEARS[i - 1];
				START = START2;
			}
			YEARS[i] = YEARS[i - 1] + 1;
		}
	}
}
