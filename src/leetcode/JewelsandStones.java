package leetcode;

public class JewelsandStones {

    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbb";
        System.out.println(numJewelsInStones(j,s));

    }
    public static int numJewelsInStones(String J, String S) {
        int answer = 0;

        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);
            for (int k = 0; k < J.length(); k++) {
                char j = J.charAt(k);
                if(s == j){
                    answer++;
                    break;
                }

            }
        }
        return answer;





    }

}
