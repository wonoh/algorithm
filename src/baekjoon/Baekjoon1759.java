package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,C;
    static String[] array;
    public static void main(String[] args) throws IOException {
        readLine();
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        array = new String[C];
        array = br.readLine().split(" ");
        Arrays.sort(array);
        find(0,0,0,0,"");

    }
    public static void find(int index,int count,int consonant,int collection,String s){
        if(count == N && consonant >= 2 && collection >=1){
            System.out.println(s);
            return;
        }
        if(index >= C){
            return;
        }
        if(array[index].equalsIgnoreCase("a") || array[index].equalsIgnoreCase("e") || array[index].equalsIgnoreCase("i")
            || array[index].equalsIgnoreCase("o") || array[index].equalsIgnoreCase("u")
        ){
            find(index+1,count+1,consonant,collection+1,s+array[index]);
        }else{
            find(index+1,count+1,consonant+1,collection,s+array[index]);

        }
        find(index+1,count,consonant,collection,s);
    }
    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
}
