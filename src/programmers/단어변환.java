package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    static boolean[] visited;
    static Queue<Node> queue;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        queue = new LinkedList<>();
        visited = new boolean[words.length];
        queue.offer(new Node(begin,0));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.word.equalsIgnoreCase(target)){
                answer = now.count;
                break;
            }
            for(int i=0;i<words.length;i++){
                boolean isPosible = true;
                int inCorrect = 0;
                for(int j=0;j<words[i].length();j++){
                    if(now.word.charAt(j) != words[i].charAt(j)){
                        inCorrect++;
                    }
                }
                if(inCorrect > 1){
                    isPosible = false;
                }
                if(isPosible && !visited[i]){
                    visited[i] = true;
                    queue.offer(new Node(words[i],now.count+1));
                }
            }
        }
        return answer;
    }
    static class Node{
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        단어변환 d = new 단어변환();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(d.solution(begin,target,words));

    }
}
