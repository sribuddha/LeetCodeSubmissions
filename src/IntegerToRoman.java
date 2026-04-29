public class IntegerToRoman {

    class Solution {

        public int romanize(StringBuilder sbuf, int num, int base, String roman) {
            while (num / base > 0) {
                sbuf.append(roman);
                num -= base;
            }

            return num;

        }

        public String intToRoman(int num) {

            StringBuilder s = new StringBuilder();
            num = romanize(s, num, 1000, "M");
            num = romanize(s, num, 900, "CM");
            num = romanize(s, num, 500, "D");
            num = romanize(s, num, 400, "CD");
            num = romanize(s, num, 100, "C");
            num = romanize(s, num, 90, "XC");
            num = romanize(s, num, 50, "L");
            num = romanize(s, num, 40, "XL");
            num = romanize(s, num, 10, "X");
            num = romanize(s, num, 9, "IX");
            num = romanize(s, num, 5, "V");
            num = romanize(s, num, 4, "IV");
            num = romanize(s, num, 1, "I");

            return s.toString();
        }

    }

    class Solution1 {

        public String intToRoman(int num) {

            StringBuffer s = new StringBuffer();
            while (num / 1000 > 0) {
                s.append('M');
                num -= 1000;

            }
            while (num / 900 > 0) {
                s.append("CM");
                num -= 900;

            }
            while (num / 500 > 0) {
                s.append('D');
                num -= 500;
            }
            while (num / 400 > 0) {
                s.append("CD");
                num -= 400;
            }

            while (num / 100 > 0) {
                s.append('C');
                num -= 100;
            }
            while (num / 90 > 0) {
                s.append("XC");
                num -= 90;
            }
            while (num / 50 > 0) {
                s.append('L');
                num -= 50;
            }
            while (num / 40 > 0) {
                s.append("XL");
                num -= 40;
            }

            while (num / 10 > 0) {
                s.append('X');
                num -= 10;
            }
            while (num / 9 > 0) {
                s.append("IX");
                num -= 9;
            }
            while (num / 5 > 0) {
                s.append('V');
                num -= 5;
            }
            while (num / 4 > 0) {
                s.append("IV");
                num -= 4;
            }

            while (num > 0) {
                s.append('I');
                num -= 1;
            }

            return s.toString();
        }

    }

    public static void main(String args[]) {

        Solution s = new IntegerToRoman().new Solution();

        System.out.println("Answer  MMMDCCXLIX : " + s.intToRoman(3749));
        System.out.println("Answer  LVIII : " + s.intToRoman(58));
        System.out.println("Answer  MCMXCIV : " + s.intToRoman(1994));
        System.out.println("Answer  I : " + s.intToRoman(1));
        System.out.println("Answer  I : " + s.intToRoman(3999));

    }
}
