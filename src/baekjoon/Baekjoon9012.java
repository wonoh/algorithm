package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon9012 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n ; i++) {
            Stack<Character> stack = new Stack<>();
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(j) == ')'){
                    stack.pop();
                    continue;
                }
                stack.push(s.charAt(j));
            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
    }


}
