//Leetcode: 13
//Complexity: Easy 
public class RomanToInteger {
    class Solution {
        public int romanToInt(String s) {
            char[] chars = s.toCharArray();
            int num = 0;

            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case 'M':
                        num += 1000;
                        break;
                    case 'D':
                        num += 500;
                        break;
                    case 'C':
                        if (i != chars.length - 1 && chars[i + 1] == 'D') {
                            num += 400;
                            i++;
                            break;
                        }
                        if (i != chars.length - 1 && chars[i + 1] == 'M') {
                            num += 900;
                            i++;
                            break;
                        }
                        num += 100;
                        break;
                    case 'L':
                        num += 50;
                        break;
                    case 'X':
                        if (i != chars.length - 1 && chars[i + 1] == 'L') {
                            num += 40;
                            i++;
                            break;
                        }
                        if (i != chars.length - 1 && chars[i + 1] == 'C') {
                            num += 90;
                            i++;
                            break;
                        }

                        num += 10;
                        break;
                    case 'V':
                        num += 5;
                        break;
                    case 'I':
                        if (i != chars.length - 1 && chars[i + 1] == 'X') {
                            num += 9;
                            i++;
                            break;
                        }
                        if (i != chars.length - 1 && chars[i + 1] == 'V') {
                            num += 4;
                            i++;
                            break;
                        }
                        num += 1;
                        break;
                }
            }

            return num;
        }
    }

    public static void main(String args[]) {

        Solution s = new RomanToInteger().new Solution();

        System.out.println("Answer  3749  : " + s.romanToInt("MMMDCCXLIX"));
        System.out.println("Answer  58 : " + s.romanToInt("LVIII"));
        System.out.println("Answer  1994  : " + s.romanToInt("MCMXCIV"));
        System.out.println("Answer  1 : " + s.romanToInt("I"));
        System.out.println("Answer  3999 : " + s.romanToInt("MMMCMXCIX"));
        System.out.println("Answer 1884 :" + s.romanToInt("MDCCCLXXXIV"));

    }

}
