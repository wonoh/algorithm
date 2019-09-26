package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l1Next1 = new ListNode(2);
        ListNode liNext2 = new ListNode(4);
        l1Next1.setNext(liNext2);
        l1.setNext(l1Next1);

        ListNode l2 = new ListNode(1);
        ListNode l2Next1 = new ListNode(3);
        ListNode l2Next2 = new ListNode(4);
        l2Next1.setNext(l2Next2);
        l2.setNext(l2Next1);

        System.out.println(mergeTwoLists(l1,l2));


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
