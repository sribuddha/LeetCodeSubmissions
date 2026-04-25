//Leetcode: 3
//Complexity: Med 
public class LengthOfLongestSubstring {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();

            int len = chars.length;
            if (len == 0)
                return 0;
            int finalRes = 1;
            int startSeq = 0;

            for (int i = 1; i < len; i++) {

                for (int j = i - 1; j >= startSeq; j--) {
                    if (chars[i] == chars[j]) {
                        if (i - startSeq >= finalRes)
                            finalRes = i - startSeq;

                        startSeq = j + 1;
                    }
                }

            }

            if (len - startSeq > finalRes)
                finalRes = len - startSeq;

            return finalRes;
        }
    }

    public static void main(String args[]) {
        Solution sol = (new LengthOfLongestSubstring().new Solution());

        System.out.println("Answer should be 3 :" + sol.lengthOfLongestSubstring("abcabcbb"));

        System.out.println("Answer should be 4 :" + sol.lengthOfLongestSubstring("absaf"));

        System.out.println("Answer should be 5 :" + sol.lengthOfLongestSubstring("abaabcdafaa"));

    }

}