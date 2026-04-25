//Leetcode: 2
//Complexity: Medium 
public class AddTwoNumbers {
    class ListNode {
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

        String printList() {
            StringBuffer sbuf = new StringBuffer();
            ListNode l = this;
            while (l != null) {
                sbuf.append(l.val);
                sbuf.append(",");
                l = l.next;
            }
            return sbuf.toString();
        }
    }

    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode start = null;
            ListNode lastNode = start;

            int carry = 0;
            while (l1 != null && l2 != null) {
                int value = l1.val + l2.val + carry;
                if (value > 9) {
                    value -= 10;
                    carry = 1;
                } else
                    carry = 0;

                if (start == null) {
                    start = new ListNode(value);
                    lastNode = start;
                } else {
                    ListNode n = new ListNode(value);
                    lastNode.next = n;
                    lastNode = n;
                }

                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                int value = l1.val + carry;
                if (value > 9) {
                    value -= 10;
                    carry = 1;
                } else
                    carry = 0;
                if (start == null) {
                    start = new ListNode(value);
                    lastNode = start;
                } else {
                    ListNode n = new ListNode(value);
                    lastNode.next = n;
                    lastNode = n;
                }
                l1 = l1.next;
            }
            while (l2 != null) {
                int value = l2.val + carry;
                if (value > 9) {
                    value -= 10;
                    carry = 1;
                } else
                    carry = 0;
                if (start == null) {
                    start = new ListNode(value);
                    lastNode = start;
                } else {
                    ListNode n = new ListNode(value);
                    lastNode.next = n;
                    lastNode = n;
                }
                l2 = l2.next;
            }

            if (carry == 1) {
                ListNode n = new ListNode(carry);
                lastNode.next = n;
                lastNode = n;
            }

            return start;
        }
    }

    public static void main(String args[]) {
        ListNode l1 = new AddTwoNumbers().new ListNode(4);
        l1.next = new AddTwoNumbers().new ListNode(4);
        ListNode l2 = new AddTwoNumbers().new ListNode(3);
        ListNode l3 = new AddTwoNumbers().new Solution().addTwoNumbers(l1, l2);

        System.out.println("Answer should be 7,4 :" + l3.printList());

    }

}
