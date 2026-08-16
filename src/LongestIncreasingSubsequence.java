//Leetcode: 300
//Complexity: Med 

public class LongestIncreasingSubsequence {
    class Solution {

        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len <= 1)
                return len;

            int[] longest = new int[nums.length];
            // Arrays.fill(longest, 1);

            int maxLen = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && longest[j] + 1 > longest[i]) {
                        longest[i] = longest[j] + 1;
                        if (longest[i] > maxLen)
                            maxLen = longest[i];
                    }

                }
                // System.out.println("Array state Longest until " + i + " is " +
                // Arrays.toString(longest));

            }

            return maxLen + 1;
        }
    }

    public static void main(String args[]) {
        Solution sol = (new LongestIncreasingSubsequence().new Solution());

        System.out.println("Answer should be 4 : " +
                sol.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

        System.out.println("Answer should be 4 : " +
                sol.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));

        System.out.println("Answer should be 1 : " +
                sol.lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));
        System.out.println("Answer should be 1 : " +
                sol.lengthOfLIS(new int[] { 7 }));
        System.out.println("Answer should be 0 : " + sol.lengthOfLIS(new int[] {}));

        System.out.println("Answer should be 5 : " + sol.lengthOfLIS(new int[] {
                1, 2, 3, 4, 5 }));

    }

}
