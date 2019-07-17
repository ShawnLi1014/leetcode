/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (41.30%)
 * Likes:    895
 * Dislikes: 1369
 * Total Accepted:    248.9K
 * Total Submissions: 600.5K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element
 * and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, 
 * or index number 5 where the peak element is 6.
 * 
 * 
 * Note:
 * 
 * Your solution should be in logarithmic complexity.
 * 
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1; 
        return binarySearch(nums, lo, hi);
    }
    
    public int binarySearch(int[] nums, int lo, int hi) {
   
        if (lo == hi) {
            return lo;
        } 
        int mid = lo + (hi - lo) / 2;
        // If mid at a descending slope, then the peak element must be at [lo, mid]
        if (nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, lo, mid);
        } 
        // If mid at a ascending slope, the peak element must be at [mid + 1, hi]
        else {
            return binarySearch(nums, mid + 1, hi);
        }
    } 
}

