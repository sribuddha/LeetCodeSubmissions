//Leetcode: 322
//Complexity: Med 

import java.util.Arrays;

public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {

            if (amount == 0)
                return 0;

            int[] arr = new int[amount + 1];
            Arrays.fill(arr, Integer.MAX_VALUE);
            arr[0] = 0;
            // coins [1, 2, 5], amount :11
            // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
            // [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6]
            // [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]

            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    if (arr[j - coin] != Integer.MAX_VALUE) {
                        arr[j] = Math.min(arr[j], arr[j - coin] + 1);
                    }
                }

                // System.out.println(Arrays.toString(arr));
            }

            return (arr[amount] == Integer.MAX_VALUE) ? -1 : arr[amount];
        }

    }

    public static void main(String[] args) {

        Solution s = new CoinChange().new Solution();
        System.out.println("Answer should be 3: " +
                s.coinChange(new int[] { 1, 2, 5 }, 11));

        System.out.println("Answer should be -1: " +
                s.coinChange(new int[] { 2 }, 3));

        System.out.println("Answer should be 0: " +
                s.coinChange(new int[] { 1 }, 0));

        System.out.println("Answer should be 20: " +
                s.coinChange(new int[] { 83, 186, 408, 419 }, 6249));

        System.out.println("Answer should be 3: " +
                s.coinChange(new int[] { 1, 3, 4 }, 10));

        System.out.println("Answer should be 2: " +
                s.coinChange(new int[] { 1, 3, 4 }, 6));

    }
}
