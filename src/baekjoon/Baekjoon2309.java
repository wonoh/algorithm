package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> height;
    static int sum;
    public static void main(String[] args) throws IOException {
        height = new ArrayList<>();
        sum = 0;
        for(int i=0;i<9;i++){
            height.add(Integer.parseInt(br.readLine()));
            sum += height.get(i);
        }
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                if( sum - (height.get(i)+height.get(j)) == 100){
                    height.remove(j);
                    height.remove(i);
                }
            }
        }
        Collections.sort(height);
        for(int val : height){
            System.out.println(val);
        }



    }



}
