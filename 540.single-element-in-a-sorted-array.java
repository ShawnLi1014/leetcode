/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (57.43%)
 * Likes:    810
 * Dislikes: 64
 * Total Accepted:    60.3K
 * Total Submissions: 105K
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * Given a sorted array consisting of only integers where every element appears
 * exactly twice except for one element which appears exactly once. Find this
 * single element that appears only once.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * 
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length;
        int lo = 0, hi = N - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isSingle(nums, mid)) {
                return nums[mid];
            } else {
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                } else {
                    if (nums[mid - 1] == nums[mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
            }

        }
        return nums[lo];
    }

    public boolean isSingle(int[] nums, int i) {
        if (i == 0) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
        } else if (i == nums.length) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
        } else if (nums[i - 1] == nums[i] || nums[i + 1] == nums[i]) {
            return false;
        }
        return true;
    }
}

