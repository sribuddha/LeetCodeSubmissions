//Leetcode: 9
//Complexity: Easy 
public class PalindromeNumber {

    int getCardinality(int x) {
        int i = 10;

        if (x < 10)
            return 1;
        for (; i < Integer.MAX_VALUE; i *= 10)
            if (x / i < 10)
                return i;

        return i;
    }

    public boolean isPal(int x, int card) {
        if (card == 1)
            return true;
        if (card == 10)
            return x % 10 == x / 10;
        if (x / card != x % 10)
            return false;

        return isPal(x % card / 10, card / 100);
    }

    public boolean isPalindrome1(int x) {
        if (x < 0)
            return false;
        int card = getCardinality(x);

        return isPal(x, card);
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        int result = 0, card = 1, var = x;
        while (var / 10 > 0) {
            result = result * 10 + var % 10;
            var = var / 10;
            card++;
        }
        result = result * 10 + var % 10;

        // System.out.println(x + " " + result + " " + card);

        return x == result;

    }

    public static void main(String[] args) {
        int input = 10201;

        PalindromeNumber p = new PalindromeNumber();
        System.out.println((int) Math.log10(Math.abs(input)) + 1);
        System.out.println("Answer should be true :" + p.isPalindrome(input));

        input = 177707771;

        p = new PalindromeNumber();
        System.out.println((int) Math.log10(Math.abs(input)) + 1);
        System.out.println("Answer should be true :" + p.isPalindrome(input));

    }
}
