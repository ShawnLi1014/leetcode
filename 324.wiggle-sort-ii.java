/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (28.03%)
 * Likes:    645
 * Dislikes: 360
 * Total Accepted:    62.3K
 * Total Submissions: 220.8K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int median = (nums.length - 1) / 2;
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int[] tempArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[median]) {
                tempArray[odd] = nums[i];
                odd += 2;
                continue;
            }
            if (nums[i] < nums[median]) {
                tempArray[even] = nums[i];
                even -= 2;
                continue;
            }
        }
        while (odd <= nums.length - 1) {
            tempArray[odd] = nums[median];
            odd += 2;
        }
        while (even >= 0) {
            tempArray[even] = nums[median];
            even -= 2;
        }
        System.arraycopy(tempArray, 0, nums, 0, nums.length);
    }
}

