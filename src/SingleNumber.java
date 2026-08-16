//Leetcode: 136
//Complexity: Easy
public class SingleNumber {
    class Solution {

        public int singleNumber(int[] nums) {
            int value = 0;
            for (int num : nums)
                value = value ^ num;

            return value;
        }
    }

    public static void main(String args[]) {
        Solution s = new SingleNumber().new Solution();
        System.out.println("Should be 1: " + s.singleNumber(new int[] { 2, 2, 1 }));
        System.out.println("Should be 4: " + s.singleNumber(new int[] { 4, 2, 2, 1, 1 }));
        System.out.println("Should be 1: " + s.singleNumber(new int[] { 4, 4, 2, 1, 2 }));

        System.out.println("Should be 4: " + s.singleNumber(new int[] { 4, 1, 2, 1, 2 }));
        System.out.println("Should be 4: " + s.singleNumber(new int[] { 4, 1, 2, 1, 2, 3, 3 }));

        System.out.println("Should be 1: " + s.singleNumber(new int[] { 1 }));

    }

}
