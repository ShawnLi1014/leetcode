/*
 * @lc app=leetcode id=969 lang=java
 *
 * [969] Pancake Sorting
 *
 * https://leetcode.com/problems/pancake-sorting/description/
 *
 * algorithms
 * Medium (62.41%)
 * Likes:    149
 * Dislikes: 174
 * Total Accepted:    11.7K
 * Total Submissions: 18.6K
 * Testcase Example:  '[3,2,4,1]'
 *
 * Given an array A, we can perform a pancake flip: We choose some positive
 * integer k <= A.length, then reverse the order of the first k elements of A.
 * We want to perform zero or more pancake flips (doing them one after another
 * in succession) to sort the array A.
 * 
 * Return the k-values corresponding to a sequence of pancake flips that sort
 * A.  Any valid answer that sorts the array within 10 * A.length flips will be
 * judged as correct.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation: 
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k=4): A = [1, 4, 2, 3]
 * After 2nd flip (k=2): A = [4, 1, 2, 3]
 * After 3rd flip (k=4): A = [3, 2, 1, 4]
 * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip
 * anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 100
 * A[i] is a permutation of [1, 2, ..., A.length]
 * 
 * 
 */
class Solution {

    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int pivot = partition(nums, lo, hi);
            if (pivot < kth) {
                lo = pivot + 1;
            }
            if (pivot > kth) {
                hi = pivot - 1;
            }
            if (pivot == kth) {
                return nums[pivot];
            }
        }
        return nums[kth];
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time complexity O(N^2), space complexity O(N)

