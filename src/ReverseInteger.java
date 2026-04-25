//Leetcode: 7 
//Complexity: Med 

public class ReverseInteger {

    class Solution {
        static int MAX = Integer.MAX_VALUE / 10;

        int reversePositive(int num) {
            System.out.println("Hello " + num);

            if (num < 10)
                return num;

            int result = 0;
            System.out.println(result + " " + num + " " + MAX + " " + Integer.MAX_VALUE);

            while (num > 0) {

                result *= 10;
                result += num % 10;
                num = num / 10;
                System.out.println(result + " " + num + " " + MAX + " " + Integer.MAX_VALUE);

                if (result > MAX && num > 0) {
                    System.out.println(result + " " + num + " " + MAX + " " + Integer.MAX_VALUE);
                    result = 0;
                    break;
                }

            }

            return result;
        }

        int reverse(int num) {
            if (num == Integer.MIN_VALUE)
                return 0;
            return (num < 0) ? (-reversePositive(-num)) : reversePositive(num);
        }
    }

    public static void main(String args[]) {

        Solution s = new ReverseInteger().new Solution();

        // System.out.println("Answer should be 321 : " + s.reverse(123));
        // System.out.println("Answer should be -321 : " + s.reverse(-123));
        // System.out.println("Answer should be 21 : " + s.reverse(120));

        System.out.println("Answer should be 0 : " + s.reverse(-2147483648));
        // System.out.println("Answer should be -2143847412 : " +
        // s.reverse(-2147483412));
        // System.out.println("Answer should be 0 : " + s.reverse(1534236469));

        // System.out.println("Answer should be 2143847412 : " + s.reverse(2147483412));

        // System.out.println("Answer should be 2147483641 : " + s.reverse(1463847412));

    }

}
