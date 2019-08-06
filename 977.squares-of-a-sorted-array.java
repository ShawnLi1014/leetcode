/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (71.92%)
 * Likes:    412
 * Dislikes: 45
 * Total Accepted:    91.6K
 * Total Submissions: 127.5K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 * 
 * 
 * 
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int l = 0, r = A.length - 1;
        int i = A.length - 1;
        while (i >= 0) {
            if (Math.abs(A[r]) > Math.abs(A[l])) {
                res[i] = A[r] * A[r];
                r--;
            } else {
                res[i] = A[l] * A[l];
                l++;
            }
            i--;
        }
        return res;
    }
}

