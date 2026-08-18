//Leetcode: 11
//Complexity: Medium

public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1, maxArea = -1;
            // Incase you want the start and end wall indices
            // int startWall = i, endWall = j;

            while (r > l) {
                int min = (height[l] > height[r]) ? height[r] : height[l];
                int area = min * (r - l);
                // System.out.println(" i:" + i + " j:" + j + " Area:" + area + " MaxArea:" +
                // maxArea);
                if (area > maxArea) {
                    maxArea = area;
                    // startWall = i;endWall = j;
                }

                // Move the shorter wall inward;
                // moving the taller one cannot increase the current limiting height.
                if (height[l] < height[r])
                    l++;
                else
                    r--;

            }

            return maxArea;
        }
    }

    public static void main(String[] args) {
        Solution s = new ContainerWithMostWater().new Solution();

        System.out.println("Answer  49   : " + s.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

        System.out.println("Answer  1   : " + s.maxArea(new int[] { 1, 1 }));
        System.out.println("Answer 8 : " + s.maxArea(new int[] { 1, 8, 8, 1, 1, 1, 1
        }));
        System.out.println("Answer 16 : " + s.maxArea(new int[] { 2, 1, 8, 1, 8, 1, 2
        }));

    }
}
