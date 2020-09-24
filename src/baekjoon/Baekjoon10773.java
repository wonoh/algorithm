package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10773 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int v = scanner.nextInt();
            if(v == 0){
                stack.pop();
                continue;
            }
            stack.push(v);
        }
        System.out.println(stack.stream().mapToInt(value -> value).sum());

    }


}
