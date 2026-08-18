//Leetcode: 268
//Complexity: Easy

public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            boolean[] numbersPresent = new boolean[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                numbersPresent[nums[i]] = true;
            }

            for (int i = 0; i < numbersPresent.length; i++) {
                if (!numbersPresent[i])
                    return i;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new MissingNumber().new Solution();

        System.out.println("Answer  2   : " + s.missingNumber(new int[] { 3, 0, 1 }));
        System.out.println("Answer  2   : " + s.missingNumber(new int[] { 0, 1 }));
        System.out.println("Answer  8   : " + s.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));

    }
}
