//Leetcode: 3783
//Complexity: Easy 
public class MirrorDistance {

    class Solution {

        int reversePositive(int num) {
            if (num < 10)
                return num;

            int result = 0;

            while (num > 0) {
                result *= 10;
                result += num % 10;

                num = num / 10;
            }

            return result;
        }

        public int mirrorDistance(int n) {
            int rev = reversePositive(n);
            int dist = rev - n;

            return dist > 0 ? dist : -dist;
        }
    }

    public static void main(String args[]) {

        Solution s = new MirrorDistance().new Solution();

        System.out.println("Answer should be 27 : " + s.mirrorDistance(25));
        System.out.println("Answer should be 9 : " + s.mirrorDistance(10));
        System.out.println("Answer should be 0 : " + s.mirrorDistance(7));

    }

}
