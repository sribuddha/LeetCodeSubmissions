//Leetcode: 20
//Complexity: Easy

import java.util.ArrayDeque;

public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            char[] c = s.toCharArray();
            ArrayDeque<Character> dq = new ArrayDeque<Character>();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '(' || c[i] == '[' || c[i] == '{')
                    dq.push(c[i]);
                else if (c[i] == ')') {
                    if (dq.size() == 0)
                        return false;
                    if (dq.peek() == '(')
                        dq.pop();
                    else
                        return false;
                } else if (c[i] == '}') {
                    if (dq.size() == 0)
                        return false;
                    if (dq.peek() == '{')
                        dq.pop();
                    else
                        return false;
                } else if (c[i] == ']') {
                    if (dq.size() == 0)
                        return false;
                    if (dq.peek() == '[')
                        dq.pop();
                    else
                        return false;
                }
            }

            return dq.size() == 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new ValidParentheses().new Solution();

        System.out.println("Answer  true   : " + s.isValid("()"));
        System.out.println("Answer  true   : " + s.isValid("()[]{}"));
        System.out.println("Answer  false  : " + s.isValid("(]"));
        System.out.println("Answer  false  : " + s.isValid("([)]"));
        System.out.println("Answer  true  : " + s.isValid("([])"));

    }

}
