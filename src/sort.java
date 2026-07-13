
// Non LeetCode yet but excerpts can be used.
import java.util.Arrays;

public class sort {

    int[] bubbleSort(int[] in) {
        int[] input = Arrays.copyOf(in, in.length);
        int len = input.length;

        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }

        return input;
    }

    int[] selectSort(int[] in) {
        int[] input = Arrays.copyOf(in, in.length);
        int len = input.length;

        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }

        return input;
    }

    public static void main(String args[]) {

        int[] input = { 21, 10, 23, 45, 24, 9, 3, 12 };

        sort s = new sort();
        System.out.println("Input Array   " + Arrays.toString(input));
        System.out.println("Select Sorted " + Arrays.toString(s.selectSort(input)));
        System.out.println("Bubble Sorted " + Arrays.toString(s.bubbleSort(input)));

    }
}
