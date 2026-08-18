//Leetcode: 21
//Complexity: Easy

public class Merge2Lists {
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

        public String toString() {
            StringBuffer sbuf = new StringBuffer();
            ListNode l = this;
            boolean inserted = false;
            while (l != null) {
                sbuf.append(l.val);
                sbuf.append("->");
                l = l.next;
                inserted = true;
            }
            if (inserted)
                sbuf.delete(sbuf.length() - 2, sbuf.length());
            return sbuf.toString();

        }

    }

    class Solution {

        ListNode fromArray(int[] arr) {
            if (arr == null || arr.length == 0)
                return null;

            ListNode start = new ListNode(arr[0]);
            ListNode curr = start;
            for (int i = 1; i < arr.length; i++) {
                ListNode newnode = new ListNode(arr[i]);
                curr.next = newnode;
                curr = newnode;
            }
            return start;
        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode result = null, start = null, s1 = list1, s2 = list2;
            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;

            if (list1.val > list2.val) {
                start = list2;
                s2 = list2.next;
            } else {
                start = list1;
                s1 = list1.next;
            }

            result = start;

            while (s1 != null && s2 != null) {
                if (s1.val > s2.val) {
                    result.next = s2;
                    result = s2;
                    s2 = s2.next;

                } else {
                    result.next = s1;
                    result = s1;
                    s1 = s1.next;
                }

            }

            if (s1 != null) {
                result.next = s1;
            } else {
                result.next = s2;
            }

            return start;
        }
    }

    public static void main(String[] args) {
        Solution s = new Merge2Lists().new Solution();

        System.out.println("Answer  true   : " + s.mergeTwoLists(s.fromArray(new int[] { 1, 2, 4 }),
                s.fromArray(new int[] { 1, 3, 4 })));

        // System.out.println(s.fromArray(new int[] { 1, 2, 4 }));
        // System.out.println(s.fromArray(new int[] { 1, 3, 4 }));
    }

}
