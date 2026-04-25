//Leetcode: 6 
//Complexity: Med 

public class ZigZagConv {

    // Optimized for clarity
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1)
                return s;

            int len = s.length();
            if (len < numRows)
                return s;

            char[] chars = s.toCharArray();
            char[] result = new char[len];

            int gap = 2 * numRows - 2;

            for (int i = 0, k = 0; i < numRows; i++) {
                int longgap = gap - 2 * i;
                int nextgap = gap - longgap;

                for (int j = i; j < len; j += nextgap) {
                    result[k] = chars[j];
                    nextgap = gap - nextgap;
                    if (nextgap != 0)
                        k++;
                }

            }

            return new String(result);
        }

    }

    // Solution works and time is good but complex logic
    class LeetSolution {
        public String convert(String s, int numRows) {
            if (numRows == 1)
                return s;

            int len = s.length();
            if (len < numRows)
                return s;

            char[] chars = s.toCharArray();
            char[] result = new char[len];

            int gap = 2 * numRows - 2;
            int[] ends = new int[numRows];
            int k = 0;
            for (int i = 0; i < numRows; i++) {
                int shortgap = 2 * i;
                int longgap = gap - shortgap;
                for (int j = i; j < len; j += gap, k++) {
                    result[k] = chars[j];

                    if (i != 0 && i != numRows - 1) {
                        if (j + longgap < len) {
                            k++;
                        }
                    }
                }

                int leftover = len % gap;
                leftover = (leftover - numRows) > 0 ? leftover - numRows : 0;

                ends[i] = k + 1;
            }

            for (int i = 1; i < numRows - 1; i++) {
                int p = ends[i - 1];

                int initgap = 2 * numRows - 2 - i;

                for (int j = initgap; j < len; j += gap, p += 2) {
                    result[p] = chars[j];
                }
            }

            return new String(result);
        }

    }

    // Slow Solution - 7ms
    class Solution1 {
        public String convert(String s, int numRows) {

            int len = s.length();
            char[] chars = s.toCharArray();
            char[] result = new char[len];

            int gap = 2 * numRows - 2;
            int[] ends = new int[numRows];
            int k = 0;
            for (int i = 0; i < numRows; i++) {

                for (int j = i; j < len; j += gap, k++) {
                    result[k] = chars[j];
                    if (i != 0 && i != numRows - 1)
                        k++;
                }
                int leftover = len % gap;
                leftover = (leftover - numRows) > 0 ? leftover - numRows : 0;

                if ((i < numRows - 1 - leftover) && (i != 0 && i != numRows - 1))
                    k--;

                ends[i] = k + 1;
            }

            System.out.println("Mid  " + (new String(result)));
            for (int i = 1; i < numRows - 1; i++) {
                int p = ends[i - 1];

                int initgap = 2 * numRows - 2 - i;

                for (int j = initgap; j < len; j += gap, p += 2) {
                    result[p] = chars[j];
                }
            }

            return new String(result);
        }

        public String convert1(String s, int numRows) {
            StringBuilder[] sbuf = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++)
                sbuf[i] = new StringBuilder();

            int len = s.length();
            char[] chars = s.toCharArray();
            int gap = 2 * numRows - 2;

            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < len; j += gap) {
                    sbuf[i].append(chars[j]);
                }
            }

            for (int i = 1; i < numRows - 1; i++) {
                int initgap = 2 * numRows - 2 - i;
                for (int j = initgap, k = 1; j < len; j += gap, k += 2) {
                    sbuf[i].insert(k, chars[j]);
                }
            }

            for (int i = 1; i < numRows; i++)
                sbuf[0].append(sbuf[i]);
            return sbuf[0].toString();
        }

    }

    public static void main(String[] args) {
        Solution s = new ZigZagConv().new Solution();

        System.out.println("Answer should be PAHNAPLSIIGYIR: " + s.convert("PAYPALISHIRING", 3));
        // System.out.println("PAHNAPLSIIGYIR".contentEquals(s.convert("PAYPALISHIRING",
        // 3)));

        System.out.println("Answer should be PINALSIGYAHRPI: " + s.convert("PAYPALISHIRING", 4));
        // System.out.println("PINALSIGYAHRPI".contentEquals(s.convert("PAYPALISHIRING",
        // 4)));

        System.out.println("Answer should be PHASIYIRPLIGAN: " + s.convert("PAYPALISHIRING", 5));
        // System.out.println("PHASIYIRPLIGAN".contentEquals(s.convert("PAYPALISHIRING",
        // 5)));
        System.out.println("Answer should be A: " + s.convert("A", 5));

        System.out.println("Answer should be A: " + s.convert("A", 4));

    }

}
