//Leetcode: 788 
//Complexity: Med 

public class RotatedDigits {

    class SlowSolution {

        boolean isRotatedValid(int n) {
            // a valid number will contain atleast 1 in group B,
            // as many numbers in group A
            // no numbers from group C
            int groupB = 0;
            int groupC = 0;
            for (; n / 10 > 0; n = n / 10) {
                int digit = n % 10;
                if (digit == 2 || digit == 5 || digit == 6 || digit == 9)
                    groupB++;
                else if (digit == 3 || digit == 4 || digit == 7)
                    groupC++;
            }

            int digit = n % 10;
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9)
                groupB++;
            else if (digit == 3 || digit == 4 || digit == 7)
                groupC++;

            return (groupB >= 1) && (groupC == 0);
        }

        public int rotatedDigits(int n) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (isRotatedValid(i))
                    count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {

        SlowSolution sol = new RotatedDigits().new SlowSolution();
        System.out.println("Answer should be 4 : " + sol.rotatedDigits(10));
        System.out.println("Answer should be 0 : " + sol.rotatedDigits(1));
        System.out.println("Answer should be 1 : " + sol.rotatedDigits(2));

        System.out.println(sol.isRotatedValid(850));
    }
}
