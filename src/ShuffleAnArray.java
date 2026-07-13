//Leetcode: 384 
//Complexity: Med 

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleAnArray {
    class Solution {
        int[] nums;

        Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return Arrays.copyOf(nums, nums.length);
        }

        public int[] BruteforceShuffle() {
            int[] sol = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {

                int newPos = (int) (Math.random() * (nums.length));
                while (sol[newPos] != 0) {
                    newPos = (int) (Math.random() * (nums.length));
                }
                sol[newPos] = nums[i];

            }

            return sol;
        }

        public int[] shuffle() {
            int[] sol = Arrays.copyOf(nums, nums.length);

            for (int i = 0; i < nums.length; i++) {

                int newPos = (int) (ThreadLocalRandom.current().nextInt(nums.length - i));
                int tmp = sol[i + newPos];
                sol[i + newPos] = sol[i];
                sol[i] = tmp;
            }

            return sol;
        }
    }

    public static void main(String args[]) {

        int[] nums = new int[] { 1, 2, 3 };
        String instructions[] = new String[] { "Solution", "shuffle", "reset", "shuffle" };
        Solution s = null;
        int[][] sol = new int[instructions.length][];
        for (int i = 0; i < instructions.length; i++) {
            if ("Solution".equals(instructions[i])) {
                s = new ShuffleAnArray().new Solution(nums);
                sol[i] = null;
            } else if ("reset".equals(instructions[i])) {
                sol[i] = s.reset();
            } else if ("shuffle".equals(instructions[i])) {
                sol[i] = s.shuffle();
            }

        }

        System.out.println(Arrays.deepToString(sol));
    }
}
