//Leetcode: 1
//Complexity: Easy 
import java.util.HashMap;


public class TwoSum {

    static HashMap<Integer, Integer> twoSum1(int[] input, int target) {
        HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> sofar = new HashMap<Integer, Integer>();

        for(int i=0;i<input.length;i++){
            if(sofar.containsKey(target-input[i])) {
                results.put(sofar.get(target-input[i]),i);
            }

            sofar.put(input[i], i);
        }


        return results;
    }

    static HashMap<Integer, Integer> twoSum(int[] input, int target) {
        HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++)
            for (int j = i + 1; j < input.length; j++)
                if (input[i] + input[j] == target)
                    results.put(i, j);

        return results;
    }

    static void printResults(HashMap<Integer, Integer> results) {
        if (results.size() == 0) {
            System.out.println("No matches");
            return;
        }

        StringBuffer sbuf = new StringBuffer();
        sbuf.append("Total Results : " + results.size() + ":\n");

        for (int key : results.keySet()) {
            sbuf.append("[" + key + "," + results.get(key) + "]");
        }

        System.out.println(sbuf.toString());
    }

    public static void main(String args[]) {
        int[] arr = { -3, -1, 2, -3, -4, 1 };
        int target = -2;
        printResults(twoSum(arr, target));
    }
}
