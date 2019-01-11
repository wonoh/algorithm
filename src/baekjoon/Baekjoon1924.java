package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 빈 칸을 사이에 두고 x(1≤x≤12)와 y(1≤y≤31)이 주어진다. 참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.
 *
 * 출력
 * 첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
 */
public class Baekjoon1924 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] month_count = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i=1;i<month;i++){
            count+=month_count[i-1];
        }
        count += day-1;
        switch (count%7){
            case 0:
                System.out.println("MON");
                break;
            case 1:
                System.out.println("TUE");
                break;
            case 2:
                System.out.println("WED");
                break;
            case 3:
                System.out.println("THU");
                break;
            case 4:
                System.out.println("FRI");
                break;
            case 5:
                System.out.println("SAT");
                break;
            case 6:
                System.out.println("SUN");
                break;
        }
    }

}
