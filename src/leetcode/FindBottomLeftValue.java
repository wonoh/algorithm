package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(1);
        System.out.println(t1.toString());
        System.out.println(findLeftValue(t1));


    }
    public static int findLeftValue(TreeNode treeNode){
        int answer = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(treeNode.left == null && treeNode.right == null){
            return treeNode.val;
        }
        queue.add(treeNode);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode now = queue.poll();
                if(i==0){
                    answer = now.val;
                }
                if(now.left != null){
                    queue.add(now.left);
                }
                if(now.right != null){
                    queue.add(now.right);
                }

            }
        }


        return answer;
    }
    public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
