package leetcode;

public class GoatLatin {
    public static void main(String[] args) {

        String S = "I speak Goat Latin";
        System.out.println(toGoatLatin(S));
    }

    public static String toGoatLatin(String S) {
        StringBuilder answer = new StringBuilder();
        String[] array = S.split(" ");
        int length = array.length;
        String[] tmp = array;
        for (int i = 0; i < length; i++) {
            String s = array[i].toLowerCase();
            if (s.startsWith("a") || s.startsWith("e") || s.startsWith("i")
                    || s.startsWith("o") || s.startsWith("u")) {
                array[i] = vowel(array[i]);
            }else{
                array[i] = switchAndAdd(array[i]);
            }
            array[i] = addA(array[i], i + 1);
            answer.append(array[i]);
            if(i!= length-1){
                answer.append(" ");
            }

        }


        return answer.toString();

    }

    private static String vowel(String s) {
        return s + "ma";
    }

    private static String addA(String s, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append("a");
        }
        return s + sb.toString();
    }
    private static String switchAndAdd(String s){
        StringBuilder sb = new StringBuilder(s);
        char c = s.charAt(0);
        sb.deleteCharAt(0);
        sb.append(c);
        return sb.toString()+"ma";

    }

}
