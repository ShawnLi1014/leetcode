/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 *
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
 *
 * algorithms
 * Hard (22.46%)
 * Likes:    517
 * Dislikes: 13
 * Total Accepted:    14.4K
 * Total Submissions: 64.2K
 * Testcase Example:  '[1]\n1'
 *
 * Return the length of the shortest, non-empty, contiguous subarray of A with
 * sum at least K.
 * 
 * If there is no non-empty subarray with sum at least K, return -1.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1], K = 1
 * Output: 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [1,2], K = 4
 * Output: -1
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] prefix = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N + 1; i++) {
            while (dq.size() > 0 && prefix[i] - prefix[dq.getFirst()] >= K) {
                res = Math.min(res, i - dq.pollFirst());
            }
            while (dq.size() > 0 && prefix[i] <= prefix[dq.getLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        return res == N + 1 ? -1 : res;
    }
}

