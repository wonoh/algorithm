package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author wonoh
 * Misspelling is an art form that students seem to excel at. Write a program that removes the nth
 * character from an input string.
 *
 * 입력
 * The first line of input contains a single integer N, (1 ≤ N ≤ 1000) which is the number of datasets that follow.
 * Each dataset consists of a single line of input containing M, a space, and a single word made up of uppercase letters only. M will be less than or equal to the length of the word. The length of the word is guaranteed to be less than or equal to 80.
 *
 * 출력
 * For each dataset, you should generate one line of output with the following values: The dataset
 * number as a decimal integer (start counting at one), a space, and the misspelled word. The
 * misspelled word is the input word with the indicated character deleted.
 *
 */
public class MISPELL {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
            int N = Integer.parseInt(br.readLine());
            for(int i=1;i<=N;i++){
                result = new StringBuilder();
                String line = br.readLine();
                st = new StringTokenizer(line," ");
                int index = Integer.parseInt(st.nextToken());
                result.append(st.nextToken());
                result.deleteCharAt(index-1); // 단순 문자열 삭제
                System.out.println(i+" "+result.toString());
            }
    }
}
