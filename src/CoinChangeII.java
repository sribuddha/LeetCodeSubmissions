//Leetcode: 518
//Complexity: Med 

public class CoinChangeII {
    class Solution {
        public int change(int amount, int[] coins) {

            if (amount == 0)
                return 1;

            int[] arr = new int[amount + 1];
            arr[0] = 1;
            // coins [2, 3, 5], amount :12
            // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
            // [0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1] coins = [2]
            // [0, 0, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 3] coins = [2,3]
            // [0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5] coins = [2,3,5]

            // coins [1, 2, 5], amount :5
            // 0, 1, 2, 3, 4, 5
            // [0, 1, 1, 1, 1, 1] coins = [1]
            // [0, 1, 2, 2, 3, 3] coins = [1, 2]
            // [0, 1, 2, 2, 3, 4] coins = [1, 2,5]

            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    arr[j] = arr[j] + arr[j - coin];
                }

                // System.out.println(java.util.Arrays.toString(arr));
            }

            return arr[amount];
        }

    }

    public static void main(String[] args) {

        Solution s = new CoinChangeII().new Solution();
        System.out.println("Answer should be 4: " +
                s.change(5, new int[] { 1, 2, 5 }));

        System.out.println("Answer should be 0: " +
                s.change(3, new int[] { 2 }));

        System.out.println("Answer should be 1: " +
                s.change(10, new int[] { 10 }));

        System.out.println("Answer should be 1: " +
                s.change(0, new int[] { 10 }));

    }
}
