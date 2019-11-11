package leetcode;

import java.time.LocalDateTime;
import java.util.*;

public class FindLargestValueinEachTreeRow {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        t1.left.right = new TreeNode(3);
        t1.right.right = new TreeNode(9);
        //System.out.println(largestValues(t1));

        String a=  "2019-11-02T04:23:20+09:00";
        LocalDateTime b = LocalDateTime.parse(a.substring(0,19));
        System.out.println(b.plusHours(9));



    }
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size =  queue.size();
            int prev = Integer.MIN_VALUE;
            int max = 0;
            for (int i = 0; i < size ; i++) {
                TreeNode now = queue.poll();
                max = Math.max(prev,now.val);
                prev = max;
                if(now.left != null){
                    queue.add(now.left);
                }
                if(now.right != null){
                    queue.add(now.right);
                }
            }
            answer.add(max);
        }
        return answer;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public enum TEST{
        A,B
    }
}
