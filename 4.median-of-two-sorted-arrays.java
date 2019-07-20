/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (26.50%)
 * Likes:    4627
 * Dislikes: 646
 * Total Accepted:    465.8K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin < iMax) {
            int i = iMin + (iMax - iMin) / 2;
            int j = halfLen - i;
            if (nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else {
                iMax = i;
            }
        }
        int i = iMin;
        int j = halfLen - i;

        // The candidates of median is min(nums1[i - 1], nums2[j - 1]), max
        int maxLeft = Math.max(i <= 0 ? Integer.MIN_VALUE : nums1[i - 1], j <= 0 ? Integer.MIN_VALUE : nums2[j - 1]);

        if ((m + n) % 2 == 1) {
            return maxLeft;
        }

        int minRight = Math.min(i >= m ? Integer.MAX_VALUE : nums1[i], j >= n ? Integer.MAX_VALUE : nums2[j]);

        return (maxLeft + minRight) / 2.0;
    }
}

