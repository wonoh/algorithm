package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SA4261 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Character> list[];
    static int N;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        initList();
        for (int a = 1; a <= T; a++) {
            readLine();
            String[] S = st.nextToken().split("");
            N = Integer.parseInt(st.nextToken());
            readLine();
            int answer = 0;
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                if(word.length() > S.length){
                    continue;
                }
                boolean flag = true;
                for(int i=0;i<S.length;i++){
                    int index = Integer.parseInt(S[i]);
                    if(!list[index].contains(word.charAt(i))){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    answer++;
                }
            }
            System.out.println("#"+a+" "+answer);
        }
    }

    private static void initList() {
        list = new ArrayList[10];
        for(int i=2;i<10;i++){
            list[i] = new ArrayList<>();
        }
        list[2].add('a');
        list[2].add('b');
        list[2].add('c');
        list[3].add('d');
        list[3].add('e');
        list[3].add('f');
        list[4].add('g');
        list[4].add('h');
        list[4].add('i');
        list[5].add('j');
        list[5].add('k');
        list[5].add('l');
        list[6].add('m');
        list[6].add('n');
        list[6].add('o');
        list[7].add('p');
        list[7].add('q');
        list[7].add('r');
        list[7].add('s');
        list[8].add('t');
        list[8].add('u');
        list[8].add('v');
        list[9].add('w');
        list[9].add('x');
        list[9].add('y');
        list[9].add('z');
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
