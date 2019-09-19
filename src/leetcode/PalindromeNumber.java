package leetcode;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(5843485));

    }

    public static boolean isPalindrome(int x){


        boolean answer = true;
        String s = String.valueOf(x);
        System.out.println(s);
        int start = 0;
        int end = s.length()-1;

        while(start < s.length()/2){

            if(s.charAt(start) != s.charAt(end)){
                answer = false;
                break;
            }
            start++;
            end--;

        }




       return answer;
    }
}
