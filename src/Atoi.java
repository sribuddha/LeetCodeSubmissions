//Leetcode: 8 
//Complexity: Med 
public class Atoi {
    class Solution {

        public int myAtoi(String s) {
            char[] chars = s.toCharArray();
            long result = 0;
            boolean seqStart = false;
            int MAX = Integer.MAX_VALUE / 10;
            boolean negative = false;

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                if (!seqStart && c == ' ')
                    continue;

                if (!seqStart && ((c == '-') || (c == '+'))) {
                    seqStart = true;
                    if (c == '-')
                        negative = true;
                    continue;
                }

                if (!(c >= '0' && c <= '9'))
                    break;
                if (!seqStart && (c >= '0' && c <= '9')) {
                    seqStart = true;
                    result = c - '0';

                    continue;
                }

                // Boundary cases cases: check for numbers at Integer.MAX and Integer.MIN
                if (seqStart && (c >= '0' && c <= '9')) {

                    // This should cover most except the 2147483647 to 2147483649
                    if (result >= MAX) {
                        if ((result == MAX && negative && c > '8') || (negative && result > MAX)) {
                            return Integer.MIN_VALUE;
                        }
                        if ((!negative && c > '7') || (result > MAX && !negative)) {
                            return Integer.MAX_VALUE;
                        }

                    }

                    result = result * 10 + ((c - '0'));
                }

            }

            return (int) ((negative) ? -1 * result : result);
        }

    }

    public static void main(String args[]) {

        Solution s = new Atoi().new Solution();

        // System.out.println("Answer 42: "+s.myAtoi("42"));
        // System.out.println("Answer -42: "+s.myAtoi("-42"));
        // System.out.println("Answer -42: "+s.myAtoi(" -42"));
        // System.out.println("Answer -23: "+s.myAtoi(" -23bc"));
        // System.out.println("Answer 0 : "+s.myAtoi(" 0-1"));
        // System.out.println("Answer 2 : "+s.myAtoi(" 2-3"));
        // System.out.println("Answer 0 : "+s.myAtoi("words and 987"));
        // System.out.println("Answer 0 : "+s.myAtoi(" -+3"));
        // System.out.println("Answer 2147483647 : "+s.myAtoi(" 2147483647"));
        // System.out.println("Answer 2147483647 : "+s.myAtoi(" 2147483648"));
        System.out.println("Answer -2147483648 : " + s.myAtoi("  -21474836482"));
        // System.out.println("Answer -2147483648 : "+s.myAtoi(" -91283472332"));

    }
}
