package leetcode;

public class StrStr {


    public static void main(String[] args) {

        System.out.println(strStr("mississippi","issip"));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
