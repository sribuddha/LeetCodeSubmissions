
//Leetcode: 5 
//Complexity: Med 
import java.util.ArrayList;
import java.util.BitSet;

// There is a better solution called Manachers algo - which is not implemented here
public class LongestPalindrome {

    // Fastest Solution - 44ms
    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int evenSize = 2;
            int oddSize = 3;

            ArrayList<Integer> evenList = new ArrayList<Integer>();
            ArrayList<Integer> oddList = new ArrayList<Integer>();
            for (int i = 0; i < chars.length - 1; i++) {
                // oddList.add(i);
                if (i >= 1 && chars[i - 1] == chars[i + 1])
                    oddList.add(i - 1);

                if (chars[i] == chars[i + 1]) {
                    evenList.add(i);
                }
            }
            // System.out.println(evenSize + " " + oddSize + " " + evenList + " " +
            // oddList);

            // oddList.add(chars.length - 1);
            if (!evenList.isEmpty())
                evenSize += 2;
            if (!oddList.isEmpty())
                oddSize += 2;
            if (evenList.isEmpty() && oddList.isEmpty())
                return Character.toString(chars[0]);

            // System.out.println("BI " + evenSize + " " + oddSize + " " + evenList + " " +
            // oddList);

            for (int i = 0; i < chars.length - 1; i++) {
                ArrayList<Integer> tmpOdd = new ArrayList<Integer>();
                ArrayList<Integer> tmpEven = new ArrayList<Integer>();
                for (int oi : oddList) {
                    if (oi - 1 >= 0 && oi + oddSize - 2 < chars.length && chars[oi - 1] == chars[oi + oddSize - 2]) {
                        tmpOdd.add(oi - 1);

                    }
                }

                // Iterate through evenList
                for (int ei : evenList) {
                    if (ei - 1 >= 0 && ei + evenSize - 2 < chars.length && chars[ei - 1] == chars[ei + evenSize - 2]) {
                        tmpEven.add(ei - 1);

                    }
                }

                // System.out.println("I" + evenSize + " " + oddSize + " " + tmpEven + " " +
                // tmpOdd);

                if (!tmpOdd.isEmpty() && !tmpEven.isEmpty()) {
                    oddSize += 2;
                    evenSize += 2;
                    oddList = tmpOdd;
                    evenList = tmpEven;
                } else if (!tmpOdd.isEmpty()) {
                    oddSize += 2;
                    oddList = tmpOdd;
                    evenList = tmpEven;
                } else if (!tmpEven.isEmpty()) {
                    evenSize += 2;
                    oddList = tmpOdd;
                    evenList = tmpEven;
                } else
                    break;
            }

            // System.out.println(evenSize + " " + oddSize + " " + evenList + " " +
            // oddList);
            int startIndex = ((evenSize < oddSize)) ? oddList.get(0) : evenList.get(0);
            int endIndex = ((evenSize < oddSize)) ? oddSize - 2 + startIndex : evenSize - 2 + startIndex;

            return s.substring(startIndex, endIndex);

        }
    }

    // Slower - 57ms
    // Bitset was slower than ArrayList
    class Solution1 {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            int evenSize = 2;
            int oddSize = 3;

            BitSet evenList = new BitSet(len);
            BitSet oddList = new BitSet(len);

            for (int i = 0; i < chars.length - 1; i++) {
                // oddList.add(i);
                if (i >= 1 && chars[i - 1] == chars[i + 1])
                    oddList.set(i - 1);

                if (chars[i] == chars[i + 1]) {
                    evenList.set(i);
                }
            }

            if (!evenList.isEmpty())
                evenSize += 2;
            if (!oddList.isEmpty())
                oddSize += 2;
            if (evenList.isEmpty() && oddList.isEmpty())
                return Character.toString(chars[0]);

            for (int i = 0; i < chars.length - 1; i++) {
                BitSet tmpOdd = new BitSet(len);
                BitSet tmpEven = new BitSet(len);

                for (int oi = oddList.nextSetBit(0); oi >= 0; oi = oddList.nextSetBit(oi + 1)) {
                    if (oi - 1 >= 0 && oi + oddSize - 2 < chars.length && chars[oi - 1] == chars[oi + oddSize - 2]) {
                        tmpOdd.set(oi - 1);

                    }
                }

                // Iterate through evenList
                for (int ei = evenList.nextSetBit(0); ei >= 0; ei = evenList.nextSetBit(ei + 1)) {
                    if (ei - 1 >= 0 && ei + evenSize - 2 < chars.length && chars[ei - 1] == chars[ei + evenSize - 2]) {
                        tmpEven.set(ei - 1);

                    }
                }

                // System.out.println("I" + evenSize + " " + oddSize + " " + tmpEven + " " +
                // tmpOdd);

                if (!tmpOdd.isEmpty() && !tmpEven.isEmpty()) {
                    oddSize += 2;
                    evenSize += 2;
                    oddList = tmpOdd;
                    evenList = tmpEven;
                } else if (!tmpOdd.isEmpty()) {
                    oddSize += 2;
                    oddList = tmpOdd;
                    evenList = tmpEven;
                } else if (!tmpEven.isEmpty()) {
                    evenSize += 2;
                    oddList = tmpOdd;
                    evenList = tmpEven;
                } else
                    break;
            }

            int startIndex = ((evenSize < oddSize)) ? oddList.nextSetBit(0) : evenList.nextSetBit(0);
            int endIndex = ((evenSize < oddSize)) ? oddSize - 2 + startIndex : evenSize - 2 + startIndex;

            return s.substring(startIndex, endIndex);
        }
    }

    public static void main(String args[]) {
        Solution sol = new LongestPalindrome().new Solution();
        System.out.println("bab is the answe: " + sol.longestPalindrome("babad"));
        System.out.println("bbbb is the answer: " + sol.longestPalindrome("cbbbbddddeee"));
        System.out.println("bbb is the answer: " + sol.longestPalindrome("bbb"));
        System.out.println("c is the answer: " + sol.longestPalindrome("c"));

    }
}
