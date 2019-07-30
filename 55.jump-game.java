/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (32.00%)
 * Likes:    2144
 * Dislikes: 211
 * Total Accepted:    284.9K
 * Total Submissions: 882.3K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    int max;

    public boolean canJump(int[] nums) {
        max = Integer.MIN_VALUE;
        return jump(nums, 0);
    }

    public boolean jump(int[] nums, int i) {
        int maxCurr = i + nums[i];
        if (maxCurr <= max) {
            return false;
        }
        if (maxCurr >= nums.length - 1) {
            return true;
        }
        max = maxCurr;
        for (int j = 1; j <= nums[i]; j++) {
            if (jump(nums, i + j)) {
                return true;
            }
        }
        return false;
    }
}

