package kakao2020;

public class P1 {

    public static void main(String[] args) {

        String s = "aaaabcabcdede";

        System.out.println(s);
        solution(s);

    }

    public static int solution(String s) {
        int answer = 0;

        int len = s.length();

        int min = len;
        int split = 1;

        for (int i = split; i < len/2 ; i++) {

            // 자르는 갯수 i 일때 1부터 길이/2 까지
            for (int j = 0; j < len-1 ; j++) {
                if(s.charAt(j) == s.charAt(j+1)){
                    int sameCount = 1;
                    for (int k = j+1; k < len-1 ; k++) {
                        if(s.charAt(k) != s.charAt(k+1)){
                            break;
                        }
                        sameCount++;
                    }
                    System.out.println(sameCount);
                }
            }
            if(split > 1){
                break;
            }


        }





        return answer;
    }

}
