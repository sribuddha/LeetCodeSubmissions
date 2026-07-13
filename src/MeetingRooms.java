
//Leetcode: 252, 253
//Complexity: Easy, Medium
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    class Solution {
        boolean personCanAttend(int[][] array) {
            Arrays.sort(array, Comparator.comparing((int[] x) -> x[0]).thenComparing(x -> x[1]));

            for (int i = 1; i < array.length; i++) {
                if (array[i][0] < array[i - 1][1])
                    return false;
            }
            return true;
        }

        int numberOfRooms(int[][] array) {

            int[] starts = Arrays.stream(array).mapToInt((int[] x) -> x[0]).sorted().toArray();
            int[] ends = Arrays.stream(array).mapToInt(x -> x[1]).sorted().toArray();

            int s = 0, e = 0, count = 0, maxCount = 0;

            while (s < starts.length) {
                // If end of one meeting cannot overlap to next, change this to <=
                if (starts[s] < ends[e]) {
                    s++;
                    count++;

                    if (count > maxCount)
                        maxCount = count;
                } else {
                    e++;
                    count--;
                }

            }

            return maxCount;
        }

        // Heap Method
        // what's the smallest active end right now" dynamically every iteration; the
        // two-pointer already knows the full sorted order of all ends in advance, so it
        // just consumes that list linearly
        int numberOfRoomsMethod1(int[][] array) {

            Arrays.sort(array, Comparator.comparing((int[] x) -> x[0]).thenComparing(x -> x[1]));
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            int count = 0, maxCount = 0;
            // System.out.println(Arrays.deepToString(array) + " " + heap);

            for (int i = 0; i < array.length; i++) {
                if (!(heap.size() == 0 || (array[i][0]) < heap.peek())) {
                    heap.poll();
                    count--;

                }
                {
                    count++;
                    heap.add(array[i][1]);
                    if (count > maxCount)
                        maxCount = count;
                }

                System.out.println(Arrays.toString(array[i]) + " " + heap);
            }
            return maxCount;
        }

        boolean[] canSchedule(int[][] existingMeetings, int rooms, int[][] newMeetings) {
            boolean[] result = new boolean[newMeetings.length];
            int[][] totalMeetings = new int[existingMeetings.length + 1][];
            System.arraycopy(existingMeetings, 0, totalMeetings, 0, existingMeetings.length);

            for (int i = 0; i < newMeetings.length; i++) {
                totalMeetings[existingMeetings.length] = new int[] { newMeetings[i][0], newMeetings[i][1] };

                result[i] = (numberOfRooms(totalMeetings) == rooms);

            }

            return result;
        }

    }

    public static void main(String[] args) {
        Solution s = new MeetingRooms().new Solution();

        int[][] a = new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(Arrays.deepToString(a) + "\n expect false: " +
                s.personCanAttend(a)
                + "\n expect 2: " + s.numberOfRooms(a));

        a = new int[][] { { 5, 8 }, { 9, 15 } };
        System.out.println(Arrays.deepToString(a) + "\n expect true: " +
                s.personCanAttend(a)
                + "\n expect 1: " + s.numberOfRooms(a));

        a = new int[][] { { 5, 8 }, { 9, 15 }, { 1, 3 } };
        System.out.println(Arrays.deepToString(a) + "\n expect true: " +
                s.personCanAttend(a)
                + "\n expect 1: " + s.numberOfRooms(a));

        a = new int[][] { { 9, 10 }, { 4, 9 }, { 4, 17 }, { 4, 9 } };
        System.out.println(Arrays.deepToString(a) + "\n  expect false: " + s.personCanAttend(a)
                + "\n expect 3: " + s.numberOfRooms(a));

        // a = new int[][] { { 1, 3 }, { 3, 5 }, { 5, 17 } };
        // System.out.println(Arrays.deepToString(a) + "\n expect true: " +
        // s.personCanAttend(a)
        // + "\n expect 1: " + s.numberOfRooms(a));

        // a = new int[][] { { 1, 2 }, { 4, 5 }, { 8, 10 } };
        // int[][] b = new int[][] { { 2, 3 }, { 3, 4 } };
        // System.out.println(Arrays.deepToString(a) + " " + Arrays.deepToString(b)
        // + Arrays.toString(s.canSchedule(a, 1, b)));

        // b = new int[][] { { 4, 5 }, { 5, 6 } };
        // System.out.println(Arrays.deepToString(a) + " " + Arrays.deepToString(b)
        // + Arrays.toString(s.canSchedule(a, 1, b)));

    }
}
