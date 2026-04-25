//Leetcode: 1
//Complexity: Easy 
import java.util.HashMap;

import java.util.Arrays;

public class FirstTwoSum {

    // Optimized - 2ms
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
            for (int i = 0; i < len; i++) {
                Integer j = a.get(target - nums[i]);
                if (j != null)
                    return new int[] { j.intValue(), i };
                a.put(nums[i], i);
            }
            return new int[] {};
        }
    }

    // Slowest solution - 5ms
    class SlowSolution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            boolean even = target % 2 == 0;

            int[] result = { len, len };

            HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
            for (int i = 0; i < len; i++) {

                Integer j = a.putIfAbsent(nums[i], i);
                if (j != null && even && (nums[i] == target / 2)) {
                    result[0] = j.intValue();
                    result[1] = i;
                }
            }

            // System.out.println(Arrays.toString(result));
            // System.out.println(a);
            for (int i = 0; i < len; i++) {
                Integer j = (a.get(target - nums[i]));
                if (j == null || j == i)
                    continue;

                if (i < result[0])
                    return new int[] { i, j.intValue() };
                return result;
            }
            return new int[] {};

        }
    }

    // Slowest solution - 44ms
    class SlowestSolution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i])
                        return new int[] { i, j };

                }
            }
            return new int[] {};
        }
    }

    public static void main(String args[]) {

        int[] input = { -1, -2, -3, -4, -5 };

        int target = -8;
        Solution s = (new FirstTwoSum()).new Solution();
        System.out.println(Arrays.toString(s.twoSum(input, target)));

        int[] input1 = { 3, 2, 3 };

        target = 6;
        System.out.println(Arrays.toString(s.twoSum(input1, target)));

        int[] input2 = { -3, -1, 2, -3, -4, 1 };
        target = -2;
        System.out.println(Arrays.toString(s.twoSum(input2, target)));

    }

}
