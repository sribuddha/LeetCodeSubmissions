import java.util.Arrays;
//Leetcode: 200
//Complexity: Med 

public class Islands {
    class Solution {

        void checkAndMarkVisited(char[][] arr, int r, int c) {

            if (isInBounds(arr, r, c) && arr[r][c] == '1')
                markVisited(arr, r, c);
        }

        boolean isInBounds(char[][] arr, int r, int c) {
            return !((r < 0 || r >= arr.length) || (c < 0 || c >= arr[0].length));
        }

        // Recursive algorithm but Deque may offer better memory mgmt
        // Deque can be a stack (BFS) or queue (DFS)
        public void markVisited(char[][] arr, int r, int c) {

            if (arr[r][c] == '0')
                return;
            arr[r][c] = '$';

            checkAndMarkVisited(arr, r - 1, c);
            checkAndMarkVisited(arr, r, c + 1);
            checkAndMarkVisited(arr, r + 1, c);
            checkAndMarkVisited(arr, r, c - 1);
        }

        void printGrid(char[][] arr) {
            System.out.println(Arrays.deepToString(arr));

        }

        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        markVisited(grid, i, j);
                        count++;
                    }

                }
            }

            return count;
        }
    }

    // [['-1','-1','0','-1','0'],
    // [ '-1','-1','-1','-1','0'],
    // [ '-1','-1','0','0','0'],
    // [ '0','0','0','0','0']]

    // [['-1','0','0','-1','0'],
    // ['-1','-1','-1','-1','0'],
    // ['-1','-1','0','0','0'],
    // ['0','0','0','0','0']]

    public static void main(String args[]) {
        Solution sol = (new Islands().new Solution());

        // System.out.println("Answer should be 1 : " +
        // sol.numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0',
        // '1', '0' },
        // { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));

        System.out.println("Answer should be 3 : " +
                sol.numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0',
                        '0', '0' },
                        { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
    }

}
