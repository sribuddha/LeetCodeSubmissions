//Leetcode: 207
//Complexity: Med 

import java.util.ArrayList;

public class Courses {

    class Solution {

        void printStatus(ArrayList<Integer>[] deps, byte[] visited) {
            StringBuilder sbud = new StringBuilder();
            for (int i = 0; i < deps.length; i++) {
                sbud.append("(");
                sbud.append(deps[i]);
                sbud.append(",");
                sbud.append(visited[i] + ")");
            }

            System.out.println(sbud);
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>[] deps = new ArrayList[numCourses];
            byte[] visited = new byte[numCourses];

            for (int[] dep : prerequisites) {
                if (deps[dep[0]] == null)
                    deps[dep[0]] = new ArrayList<Integer>();
                deps[dep[0]].add(dep[1]);
            }

            for (int i = 0; i < deps.length; i++) {
                if (deps[i] == null)
                    visited[i] = -1;
            }

            // printStatus(deps, visited);

            for (int i = 0; i < deps.length; i++) {
                if (!evaluate(i, deps, visited))
                    return false;
            }

            return true;
        }

        boolean evaluate(int parent, ArrayList<Integer>[] deps, byte[] visited) {
            if (visited[parent] == -1)
                return true;
            if (visited[parent] == 1)
                return false;

            visited[parent] = 1;
            for (int c : deps[parent]) {
                if (evaluate(c, deps, visited) == false)
                    return false;
            }

            visited[parent] = -1;

            return true;
        }

    }

    public static void main(String[] args) {

        Solution s = new Courses().new Solution();
        System.out.println("Answer should be true: " +
                s.canFinish(3, new int[][] { { 1, 0 }, { 2, 0 } }));
        System.out.println("Answer should be false: " +
                s.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
        System.out.println("Answer should be true: " +
                s.canFinish(3, new int[][] { { 1, 0 }, { 2, 0 }, { 2, 1 } }));

    }
}
