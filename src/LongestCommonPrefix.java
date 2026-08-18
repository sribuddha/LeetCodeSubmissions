//Leetcode: 14
//Complexity: Easy

public class LongestCommonPrefix {
    class Solution {

        // Uses charArray and hence faster but costs extra arrays creation
        public String longestCommonPrefixChar(String[] strs) {
            if (strs.length == 0)
                return "";
            else if (strs.length == 1)
                return strs[0];

            char[] result = strs[0].toCharArray();
            int resultIndex = result.length;

            for (int i = 1; i < strs.length; i++) {
                char[] next = strs[i].toCharArray();

                int min = (resultIndex > next.length) ? next.length : resultIndex;
                if (resultIndex > min)
                    resultIndex = min;

                for (int j = 0; j < min; j++) {
                    if (result[j] != next[j]) {
                        resultIndex = j;
                        break;
                    }
                }

            }
            return new String(result, 0, resultIndex);
        }

        // Better space complexity but slower than above
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0)
                return "";
            else if (strs.length == 1)
                return strs[0];

            String result = strs[0];
            int resultIndex = result.length();

            for (int i = 1; i < strs.length; i++) {
                String next = strs[i];

                int min = (resultIndex > next.length()) ? next.length() : resultIndex;
                if (resultIndex > min)
                    resultIndex = min;

                for (int j = 0; j < min; j++) {
                    if (result.charAt(j) != next.charAt(j)) {
                        resultIndex = j;
                        break;
                    }
                }

            }
            return result.substring(0, resultIndex);
        }
    }

    public static void main(String[] args) {
        Solution s = new LongestCommonPrefix().new Solution();

        System.out.println("Answer  fl   : " + s.longestCommonPrefix(new String[] { "flow", "flower", "flight" }));
        System.out.println("Answer  a   : " + s.longestCommonPrefix(new String[] { "ab", "a" }));
        System.out.println("Answer  empty   : " + s.longestCommonPrefix(new String[] { "flow", "", "flight" }));

    }
}
