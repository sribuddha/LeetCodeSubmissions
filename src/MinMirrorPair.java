
//Leetcode: 3761
//Complexity: Med 
import java.util.HashMap;

public class MinMirrorPair {
    class Solution {

        int reverse(int num) {
            if (num < 10)
                return num;

            int result = 0;

            while (num > 0) {
                result *= 10;
                result += num % 10;

                num = num / 10;
            }

            return result;
        }

        int normalize(int num) {
            if (num < 10)
                return num;
            while (num % 10 == 0)
                num /= 10;
            return num;
        }

        class Node {
            int pos;
            int value;
            int actual;

            Node(int pos, int value, int actual) {
                this.pos = pos;
                this.value = value;
                this.actual = actual;
            }

            public String toString() {
                return "pos:" + pos + " value:" + value + " " + actual;
            }
        }

        public int minMirrorPairDistance(int[] nums) {
            // DEBUG=true
            int len = nums.length;
            HashMap<Integer, Node> hmap = new HashMap<Integer, Node>();
            int shortDistance = len + 1;
            for (int i = 0; i < len; i++) {
                // if(DEBUG) System.out.println("starting"+nums[i]);

                // if(DEBUG) System.out.println(hmap);

                int normalizedNum = normalize(nums[i]);
                Node numExist = hmap.get(normalizedNum);
                // if(DEBUG) System.out.println(numExist);

                // if no number exists
                if (numExist == null) {
                    int reverse = reverse(normalizedNum);
                    numExist = new Node(i, reverse, nums[i]);
                    hmap.put(normalizedNum, numExist);
                    Node revExist = hmap.get(reverse);
                    // if(DEBUG) System.out.println("NE");

                    if (revExist != null) {
                        if (revExist.pos == i
                                || (nums[i] != revExist.value)

                        )
                            continue;

                        if (shortDistance > (i - revExist.pos))
                            shortDistance = (i - revExist.pos);
                        // if(DEBUG) System.out.println("NEYR"+" "+i+" "+revExist+" "+shortDistance);
                    }
                    // else {
                    // if(DEBUG) System.out.println("NENR");
                    // }
                } else {

                    int reverse = numExist.value;
                    Node revExist = hmap.get(reverse);

                    if (revExist != null) {

                        // if(DEBUG) System.out.println("S :"+nums[i]+" "+ numExist.actual + "
                        // "+revExist.value);
                        if (numExist.value == revExist.value && nums[i] != revExist.value) {
                            numExist.actual = nums[i];
                            numExist.pos = i;
                            continue;
                        }
                        if (nums[i] != revExist.value)
                            continue;
                        // if(DEBUG) System.out.println("E :"+nums[i]+" "+ numExist.actual + "
                        // "+revExist.value);

                        if (shortDistance > (i - revExist.pos)) {
                            shortDistance = (i - revExist.pos);
                            numExist.pos = i;
                        }
                        // if(DEBUG) System.out.println("YEYR: "+ nums[i]+" "+ revExist.actual +" "+
                        // nums[i]);

                    } else {
                        numExist.pos = i;
                        numExist.actual = nums[i];
                        // if(DEBUG) System.out.println("YENR");
                    }
                }
            }

            return (shortDistance == len + 1) ? -1 : shortDistance;
        }
    }

    // Inefficient solution - timed out on leetcode when nums.len =99999
    class InefficientSolution {

        int reverse(int num) {
            if (num < 10)
                return num;

            int result = 0;

            while (num > 0) {
                result *= 10;
                result += num % 10;

                num = num / 10;
            }

            return result;
        }

        public int minMirrorPairDistance(int[] nums) {

            int len = nums.length;
            int[] rev = new int[len];

            // System.out.println(len);
            HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

            for (int i = 0; i < len; i++) {
                Integer rever = hmap.get(nums[i]);
                if (rever == null) {
                    rev[i] = reverse(nums[i]);
                    hmap.put(nums[i], rev[i]);

                } else
                    rev[i] = rever;
            }

            for (int size = 1; size < len; size++) {
                for (int k = 0; k < len - size; k++) {
                    if (rev[k] == nums[k + size])
                        return size;
                }
            }

            return -1;
        }
    }

    public static void main(String args[]) {

        Solution s = new MinMirrorPair().new Solution();

        // Normalize tests
        int normalized = s.normalize(12);
        assert normalized == 12;
        normalized = s.normalize(7);
        assert normalized == 7;

        normalized = s.normalize(10000);
        assert normalized == 1;
        normalized = s.normalize(70);
        assert normalized == 7;

        // System.out.println(s.normalize(1200));
        // System.out.println(s.normalize(120));

        // System.out.println(s.reverse(2147483647));

        System.out.println("Answer should be 1: " + s.minMirrorPairDistance(new int[] { 12, 21, 45, 33, 54 }));
        System.out.println("Answer should be 2: " + s.minMirrorPairDistance(new int[] { 120, 1, 21 }));
        System.out.println("Answer should be -1: " + s.minMirrorPairDistance(new int[] { 90, 67, 27, 90 }));
        System.out.println("Answer should be -1: " + s.minMirrorPairDistance(new int[] { 25, 9, 2, 90, 17 }));
        System.out.println("Answer should be 1: " + s.minMirrorPairDistance(new int[] { 1000, 100, 1, 100, 10, 1 }));

    }

}
