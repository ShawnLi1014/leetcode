/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (38.79%)
 * Likes:    1896
 * Dislikes: 115
 * Total Accepted:    173.3K
 * Total Submissions: 445.8K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty
 * array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peek() > i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }
        return res;
    }
}

