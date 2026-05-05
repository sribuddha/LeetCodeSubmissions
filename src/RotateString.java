//Leetcode: 796
//Complexity: Easy 

public class RotateString {

    class Solution {
        public boolean rotateString(String s, String goal) {

            if (s.length() != goal.length())
                return false;

            return (s + s).contains(goal);
        }
    }

    public static void main(String[] args) {

        Solution sol = new RotateString().new Solution();
        System.out.println("Answer should be true : " + sol.rotateString("abcde", "bcdea"));
        System.out.println("Answer should be false : " + sol.rotateString("abcde", "abced"));
        System.out.println("Answer should be true : " + sol.rotateString("", ""));
    }
}
