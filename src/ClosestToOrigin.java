
//Leetcode: 973
//Complexity: Medium
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestToOrigin {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {

            Comparator<int[]> distDesc = (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(distDesc);

            for (int i = 0; i < points.length; i++) {
                if (i < k) {
                    maxHeap.offer(points[i]);
                } else if (distDesc.compare(maxHeap.peek(), points[i]) < 0) {
                    maxHeap.poll();
                    maxHeap.offer(points[i]);
                }
            }

            return maxHeap.toArray(new int[k][2]);
        }
    }

    public static void main(String[] args) {

        Solution s = new ClosestToOrigin().new Solution();

        System.out.println(
                "Answer  {{-2,2}} : " + Arrays.deepToString(s.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)));

        System.out.println(
                "Answer  {{3,3}, {-2,4}} : "
                        + Arrays.deepToString(s.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)));

    }

}
