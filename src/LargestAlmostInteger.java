//Leetcode: 3471
//Complexity: Easy

import java.util.Arrays;

public class LargestAlmostInteger {
    class Solution {
        public int largestInteger(int[] nums, int k) {
            int max = nums[0];
            if (k == 1) {
                Arrays.sort(nums);
                int prev = -1;
                int reps = 0;
                // reurnn non-repetitive highest number
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (reps == 0) {
                        prev = nums[i];
                        reps++;
                        continue;
                    }
                    if (prev == nums[i]) {
                        reps++;
                        continue;
                    } else {
                        if (reps == 1) {
                            return prev;
                        } else {
                            reps = 0;
                            i++;
                        }

                    }

                }

                // System.out.println("reps:" + reps + " prev:" + prev);

                return (reps == 1) ? prev : -1;

            } else if (k == nums.length) {
                max = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] > max)
                        max = nums[i];
                }

                return max;
            } else {
                int s = nums[0], e = nums[nums.length - 1];

                for (int i = 0; i < nums.length; i++) {
                    int n = nums[i];
                    if (n == s && i != 0)
                        s = -1;
                    if (n == e && i != nums.length - 1)
                        e = -1;
                }

                max = Math.max(s, e);
            }

            return max;

        }
    }

    public static void main(String[] args) {
        Solution s = new LargestAlmostInteger().new Solution();

        // System.out.println("Answer 7 : " + s.largestInteger(new int[] { 3, 9, 2, 1, 7
        // }, 3));
        // System.out.println("Answer 3 : " + s.largestInteger(new int[] { 3, 9, 7, 2,
        // 1, 7 }, 4));
        // System.out.println("Answer 7 : " + s.largestInteger(new int[] { 3, 9, 9, 2,
        // 7, 1, 7 }, 1));

        System.out.println("Answer  3   : " + s.largestInteger(new int[] { 5, 5, 3 }, 1));
        System.out.println("Answer  -1   : " + s.largestInteger(new int[] { 5, 5, 5 }, 1));
        System.out.println("Answer  -1   : " + s.largestInteger(new int[] { 10, 12, 9, 7, 10 }, 3));

        System.out.println("Answer -1 : " + s.largestInteger(new int[] { 0, 0 }, 1));

    }
}
