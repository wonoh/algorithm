package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        for (int a = 1; a <= T; a++) {
            String command = br.readLine();
            if(command.split(" ").length > 1){
                int value = Integer.parseInt(command.split(" ")[1]);
                stack.push(value);
            }else {
                switch (command) {
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        if(stack.isEmpty()){
                            System.out.println(1);
                        }else{
                            System.out.println(0);
                        }
                        break;
                    case "top":
                        if(!stack.isEmpty()){
                            System.out.println(stack.peek());
                        }else{
                            System.out.println(-1);
                        }
                        break;
                    case "pop":
                        if(!stack.isEmpty()){
                            System.out.println(stack.pop());
                        }else{
                            System.out.println(-1);
                        }
                        break;
                }
            }
        }
    }

    public static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
    }

}
