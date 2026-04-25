//Leetcode: 2833
//Complexity: Easy
public class FurthestFromOrigin {

    class Solution {

        // The question was confusing. The moves can L for left, R for right and _ can
        // be either left or right.
        // Given that _ is flexible and others are strict, the maximum value will be if
        // the _ assumes the same
        // value instead of conflicting values.
        // This yields to make solutions between all Left or all right. Find scores
        // between both and return max distance.

        public int furthestDistanceFromOrigin(String moves) {
            char[] chars = moves.toCharArray();

            int lscore = 0, rscore = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'L') {
                    lscore--;
                    rscore--;
                } else if (chars[i] == 'R') {
                    lscore++;
                    rscore++;
                } else {
                    lscore--;
                    rscore++;
                }

            }
            lscore = (lscore > 0) ? lscore : -lscore;
            rscore = (rscore > 0) ? rscore : -rscore;

            return (lscore > rscore) ? lscore : rscore;
        }
    }

    public static void main(String[] args) {
        Solution s = new FurthestFromOrigin().new Solution();

        System.out.println("Answer should be 3 : " + s.furthestDistanceFromOrigin("L_RL__R"));
        System.out.println("Answer should be 5 : " + s.furthestDistanceFromOrigin("_R__LL_"));
        System.out.println("Answer should be 7 : " + s.furthestDistanceFromOrigin("_______"));
    }

}
