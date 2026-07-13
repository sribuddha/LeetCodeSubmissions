
//Related to LeetCode 1 but will return the pairs instead of first one.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    class Solution {

        ArrayList<int[]> twoSum(int[] input, int target) {

            HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
            ArrayList<Integer> alist = new ArrayList<Integer>();
            ArrayList<int[]> result = new ArrayList<int[]>();

            for (int i = 0; i < input.length; i++) {
                if (hmap.get(input[i]) != null) {
                    alist.add(hmap.get(input[i]));
                    continue;
                }

                if (hmap.containsKey(target - input[i])) {
                    result.add(new int[] { hmap.get(target - input[i]), i });
                } else
                    hmap.put(input[i], i);

            }

            System.out.println(alist);
            return result;
        }

        String ArrtoString(ArrayList<int[]> arr) {

            StringBuilder sb = new StringBuilder();

            for (int[] pair : arr)
                sb.append(Arrays.toString(pair));

            return sb.toString();
        }
    }

    public static void main(String args[]) {

        int[] input = { -1, -2, -3, -4, -5 };

        int target = -8;
        Solution s = (new TwoSum()).new Solution();
        System.out.println(s.ArrtoString(s.twoSum(input, target)));

        int[] input1 = { 3, 2, 3, 4 };

        target = 6;
        System.out.println(s.ArrtoString(s.twoSum(input1, target)));

        int[] input2 = { -3, -1, 2, -3, -4, 1 };
        target = -2;
        System.out.println(s.ArrtoString(s.twoSum(input2, target)));

    }

}
