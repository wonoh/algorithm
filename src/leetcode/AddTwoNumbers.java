package leetcode;

public class AddTwoNumbers {

    private static int rounding = 0;
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l1Next1 = new ListNode(4);
        ListNode liNext2 = new ListNode(3);
        l1Next1.setNext(liNext2);
        l1.setNext(l1Next1);

        ListNode l2 = new ListNode(5);
        ListNode l2Next1 = new ListNode(6);
        ListNode l2Next2 = new ListNode(4);
        l2Next1.setNext(l2Next2);
        l2.setNext(l2Next1);

        //System.out.println(addTwoNumbers(l1,l2));

        String a ="SYS033";
        System.out.println(a.substring(3));
        int b = Integer.valueOf(a.substring(3));
        System.out.println((int)Math.log10(b)+1);
        b++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3-sb.length() ; i++) {
            sb.append("0");
        }
        System.out.println(sb.append(b).toString());



    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int sum = l1.val+l2.val;
        if(sum >= 10){

        }

        return null;
    }


    public static class ListNode {

      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
