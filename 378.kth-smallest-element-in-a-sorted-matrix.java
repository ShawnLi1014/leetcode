/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (49.60%)
 * Likes:    1294
 * Dislikes: 87
 * Total Accepted:    117.7K
 * Total Submissions: 234.9K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (enough(matrix, k, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }
        return lo;
    }

    public boolean enough(int[][] matrix, int k, int x) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix[0].length - 1;
            while (j >= 0 && matrix[i][j] > x) {
                j--;
            }
            count += (j + 1);
        }

        return count >= k;
    }
}

