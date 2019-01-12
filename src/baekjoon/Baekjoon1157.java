package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author wonoh
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 * <p>
 * 입력
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 * <p>
 * 출력
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */
public class Baekjoon1157 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] array = new int[26];
        String word = br.readLine();
        String upperWord = word.toUpperCase();
        for (int i = 0; i < upperWord.length(); i++) {
            array[upperWord.charAt(i) - 'A']++;
        }
        int max = 0;
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
                flag = false;
            }else if(max == array[i]){
                flag = true;
            }

        }

        if (flag) {
            System.out.println("?");
        } else {
            System.out.println((char)(index+'A'));
        }
    }
}
