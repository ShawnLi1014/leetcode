/*
 * @lc app=leetcode id=816 lang=java
 *
 * [816] Ambiguous Coordinates
 *
 * https://leetcode.com/problems/ambiguous-coordinates/description/
 *
 * algorithms
 * Medium (44.19%)
 * Likes:    80
 * Dislikes: 166
 * Total Accepted:    7K
 * Total Submissions: 15.8K
 * Testcase Example:  '"(123)"'
 *
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then,
 * we removed all commas, decimal points, and spaces, and ended up with the
 * string S.  Return a list of strings representing all possibilities for what
 * our original coordinates could have been.
 * 
 * Our original representation never had extraneous zeroes, so we never started
 * with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other
 * number that can be represented with less digits.  Also, a decimal point
 * within a number never occurs without at least one digit occuring before it,
 * so we never started with numbers like ".1".
 * 
 * The final answer list can be returned in any order.  Also note that all
 * coordinates in the final answer have exactly one space between them
 * (occurring after the comma.)
 * 
 * 
 * Example 1:
 * Input: "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 
 * 
 * 
 * Example 2:
 * Input: "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation: 
 * 0.0, 00, 0001 or 00.01 are not allowed.
 * 
 * 
 * 
 * Example 3:
 * Input: "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)",
 * "(0.12, 3)"]
 * 
 * 
 * 
 * Example 4:
 * Input: "(100)"
 * Output: [(10, 0)]
 * Explanation: 
 * 1.0 is not allowed.
 * 
 * 
 * 
 * 
 * Note: 
 * 
 * 
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", and the other elements in S are
 * digits.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        // Base case
        if (S == T) {
            return 0;
        }

        ArrayList<Integer>[] graph = new ArrayList[routes.length];
        for (int i = 0; i < routes.length; i++) {
            Arrays.sort(routes[i]);
            graph[i] = new ArrayList<>();
        }

        // Build the graph
        for (int i = 0; i < routes.length; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                if (intercept(routes, i, j)) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> targets = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        // Determin start and end bus
        for (int i = 0; i < routes.length; i++) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                q.add(new int[] { i, 0 });
                seen.add(i);
            }
            if (Arrays.binarySearch(routes[i], T) >= 0) {
                targets.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] busInfo = q.remove();
            int bus = busInfo[0];
            int depth = busInfo[1];
            if (targets.contains(bus)) {
                return depth + 1;
            }
            for (int b : graph[bus]) {
                if (!seen.contains(b)) {
                    q.add(new int[] { b, depth + 1 });
                    seen.add(b);
                }
            }
        }
        return -1;
    }

    // Helper method to find if two bus are connected
    public boolean intercept(int[][] routes, int x, int y) {
        int i = 0, j = 0;
        while (i < routes[x].length && j < routes[y].length) {
            if (routes[x][i] == routes[y][j]) {
                return true;
            } else if (routes[x][i] < routes[y][j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}

