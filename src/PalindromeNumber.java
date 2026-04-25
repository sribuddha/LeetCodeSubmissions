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

        // System.out.println(x+" "+result+" "+card);

        for (int i = 0; i < card / 2 + 1; i++) {
            if (x % 10 != result % 10)
                return false;
            x = x / 10;
            result = result / 10;
        }
        return true;

    }

    public static void main(String[] args) {
        int input = 10201;

        PalindromeNumber p = new PalindromeNumber();
        System.out.println("Answer should be true :" + p.isPalindrome(input));

    }
}
