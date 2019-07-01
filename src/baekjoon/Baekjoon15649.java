package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15649 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static boolean[] selected;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {

        readLine();

        stringBuilder = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        selected = new boolean[N];


        M = Integer.parseInt(st.nextToken());

        find("",0);

        System.out.println(stringBuilder.toString());


    }
    public static void find(String combination,int length){

        if(length == M){
            stringBuilder.append(combination.trim()+"\n");
            return;
        }
        for (int i = 0; i <N ; i++) {

            if(!selected[i]){
                selected[i] = true;
                find(combination+" "+(i+1),length+1);
                selected[i] = false;
            }
        }


    }


    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }



}
