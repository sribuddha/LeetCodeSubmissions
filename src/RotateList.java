
//Leetcode: 61
//Complexity: Medium 
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return "(" + this.val + ")";

        }

        String printList() {
            StringBuilder sbuf = new StringBuilder();

            for (ListNode l = this; l != null; l = l.next) {
                if (l != this)
                    sbuf.append("->");

                sbuf.append(l);
            }

            return sbuf.toString();
        }

    }

    class Solution {

        int size(ListNode list) {
            int i = 0;
            for (ListNode l = list; l != null; l = l.next, i++)
                ;
            return i;

        }

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null)
                return head;

            int len = size(head);
            k = k % len;

            if (k == 0)
                return head;

            int i = 0;
            ListNode l = head;
            for (; i < len - k - 1; i++)
                l = l.next;

            ListNode newNode = l;

            for (; i < len - 1; i++)
                l = l.next;

            l.next = head;
            head = newNode.next;
            newNode.next = null;

            return head;
        }

    }

    public static void main(String args[]) {
        RotateList rl = new RotateList();
        Solution s = rl.new Solution();

        ListNode list = rl.new ListNode(1,
                rl.new ListNode(2,
                        rl.new ListNode(3,
                                rl.new ListNode(4, rl.new ListNode(5)))));

        System.out.println(list.printList());
        System.out.println(s.size(list));

        ListNode sol = s.rotateRight(list, 5);
        System.out.println(sol.printList());
        System.out.println(s.size(sol));

        list = rl.new ListNode(0,
                rl.new ListNode(1,
                        rl.new ListNode(2)));
        System.out.println(list.printList());

        sol = s.rotateRight(list, 4);
        System.out.println(sol.printList());

    }

}