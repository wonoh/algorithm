package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jg3334 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean stopFlag = false;

    public static void main(String[] args) throws IOException {

        String a = "summuas";

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if(isPalindrome(temp)){
                System.out.println(0);
            }else{
                StringBuilder stringBuffer = new StringBuilder(temp);
                for (int j = 0; j <temp.length() ; j++) {
                    stringBuffer.delete(j,j+1);
                    if(j==temp.length()-1){
                        stopFlag = true;
                        if(similarPalindrome(stringBuffer.toString())==2){
                            System.out.println(2);
                        }
                    }
                    if(similarPalindrome(stringBuffer.toString())== 1){
                        System.out.println(1);
                        break;
                    }
                    stringBuffer.insert(j,temp.charAt(j));
                }
            }
        }

    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }
    public static int similarPalindrome(String word){

        if(isPalindrome(word)){
            return 1;
        }

        if(stopFlag){
            return 2;
        }

        return 0;
    }

    public static boolean isPalindrome(String word) {

        return new StringBuilder(word).reverse().toString().equals(word);

    }

}
