//Leetcode: 2423
//Complexity: Easy 

public class RemoveLetterToEqualFreq {

    class Solution {
        public boolean equalFrequency(String word) {
            int alphabet[] = new int[26];
            int max = 0, secondMax = 0;

            for (char c : word.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    alphabet[c - 'a']++;
                }
            }

            for (int val : alphabet) {
                if (val == 0)
                    continue;
                if (val > max && val > secondMax) {
                    secondMax = max;
                    max = val;
                } else if (val != max && val > secondMax)
                    secondMax = val;
            }
            int countMax = 0, countSecondMax = 0; // count number of chars in max or maxMinus1
            for (int i = 0; i < 26; i++) {
                int val = alphabet[i];
                if (val == 0)
                    continue;

                if (val == max)
                    countMax++;
                else if (val == secondMax)
                    countSecondMax++;
                else
                    return false;

            }

            if ((countSecondMax == 1 && countMax == 1 && secondMax == 1) || // aabbc
                    (countSecondMax == 0 && max == 1) || // abc
                    (secondMax == 1 && countSecondMax == 1) || // aaac
                    (countSecondMax == 0 && countMax == 1) || // aaaa
                    ((max == secondMax + 1) && countMax == 1) // cccbbbbddd
            )
                return true;

            return false;
        }

    }

    public static void main(String args[]) {
        Solution s = new RemoveLetterToEqualFreq().new Solution();

        // System.out.println("Answer should be True : " + s.equalFrequency("aaabccc"));
        // System.out.println("Answer should be false : " + s.equalFrequency("aazz"));
        // System.out.println("Answer should be false : " +
        // s.equalFrequency("aaccccdddzz"));
        // System.out.println("Answer should be true : " + s.equalFrequency("abcd"));
        // System.out.println("Answer should be true : " + s.equalFrequency("aaacde"));
        // System.out.println("Answer should be false : " +
        // s.equalFrequency("aaaccde"));
        // System.out.println("Answer should be true : " + s.equalFrequency("aaacc"));
        // System.out.println("Answer should be true : " +
        // s.equalFrequency("cccbbbbddd"));
        // System.out.println("Answer should be true : " + s.equalFrequency("abbcc"));
        // System.out.println("Answer should be true : " + s.equalFrequency("abbcc"));
        // System.out.println("Answer should be false : " + s.equalFrequency("abbccd"));
        System.out.println("Answer should be false : " + s.equalFrequency("cbccd"));
    }

}
