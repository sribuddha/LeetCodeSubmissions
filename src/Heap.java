
// Non LeetCode yet but excerpts can be used.
import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {
    class Solution {

        public void siftUp(int[] heap, int value, int index) {
            heap[index] = value;

            while (index > 0 && heap[(index - 1) / 2] > heap[index]) {
                int temp = heap[(index - 1) / 2];
                heap[(index - 1) / 2] = heap[index];
                heap[index] = temp;

                index = (index - 1) / 2;

            }
        }

        public void siftDown(int[] heap, int value) {
            if (heap[0] > value)
                return;

            heap[0] = value;
            int i = 0;
            while (true) {
                int l = 2 * i + 1;
                int r = 2 * i + 2;
                int smallest = i;

                if (l < heap.length && heap[l] < heap[smallest])
                    smallest = l;
                if (r < heap.length && heap[r] < heap[smallest])
                    smallest = r;

                if (smallest == i)
                    break;

                int tmp = heap[smallest];
                heap[smallest] = heap[i];
                heap[i] = tmp;
                i = smallest;

            }

        }

        public int[] minHeapwithSifts(int[] points, int k) {
            // minHeap for k Largest and maxHeap for k smallest
            int[] result = new int[k];

            for (int i = 0; i < points.length; i++) {
                if (i < k)
                    siftUp(result, points[i], i);
                else
                    siftDown(result, points[i]);
            }
            return result;

        }

        public int[] kClosest(int[] points, int k) {

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

            for (int i = 0; i < points.length; i++) {
                if (i < k)
                    maxHeap.offer(points[i]);
                else if (maxHeap.peek() > points[i]) {
                    // root contains the lowest, replace it
                    maxHeap.poll();
                    maxHeap.offer(points[i]);
                }
            }

            int[] result = new int[k];
            int i = 0;
            for (int val : maxHeap) {
                result[i++] = val;
            }

            return result;

        }

        public int[] kLargest(int[] points, int k) {

            // changed this to default
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i = 0; i < points.length; i++) {
                if (i < k)
                    minHeap.offer(points[i]);
                else if (minHeap.peek() < points[i]) {
                    // root contains the lowest, replace it
                    minHeap.poll();
                    minHeap.offer(points[i]);
                }
            }

            int[] result = new int[k];
            int i = 0;
            for (int val : minHeap) {
                result[i++] = val;
            }

            return result;

        }

    }

    public static void main(String[] args) {

        Solution s = new Heap().new Solution();

        System.out
                .println("Answer  {26,20,25, 30} : "
                        + Arrays.toString(s.kLargest(new int[] { 20, 15, 18, 8, 25, 26, 3, 30 }, 4)));
        System.out.println("Answer  {26,20} : " + Arrays.toString(s.kLargest(new int[] { 18, 26, 20 }, 2)));

        System.out.println(
                "Answer  {1, 2, 3, 4, 7, 8} : " + Arrays.toString(s.kLargest(new int[] { 1, 3, 2, 7, 8, 4 }, 6)));

        System.out
                .println("Answer  {26,20,25, 30} : "
                        + Arrays.toString(s.minHeapwithSifts(new int[] { 20, 15, 18, 8, 25, 26, 3, 30 }, 4)));
        System.out.println("Answer  {26,20} : " + Arrays.toString(s.minHeapwithSifts(new int[] { 18, 26, 20 }, 2)));

        System.out.println(
                "Answer  {1, 2, 3, 4, 7, 8} : "
                        + Arrays.toString(s.minHeapwithSifts(new int[] { 1, 3, 2, 7, 8, 4 }, 6)));

    }

}
