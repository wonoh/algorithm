package leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        String s = "{{}[][[[]]]}";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {


        int length = s.length();
        if(length == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length ; i++) {

            if(i == 0 && (s.charAt(i) == ']'
            || s.charAt(i) == ')'
            || s.charAt(i) == '}')){
                return false;
            }

            if(i > 0){
                if(!stack.isEmpty()) {
                    if (stack.peek() == '(' && s.charAt(i) == ')' ||
                            stack.peek() == '[' && s.charAt(i) == ']' ||
                            stack.peek() == '{' && s.charAt(i) == '}') {
                        stack.pop();
                        continue;
                    }
                }
            }

            stack.push(s.charAt(i));

            if(i == length-1 && (s.charAt(i) == '['
            || s.charAt(i) == '('
            || s.charAt(i) == '{')){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
