/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 *
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (42.47%)
 * Likes:    801
 * Dislikes: 44
 * Total Accepted:    46.4K
 * Total Submissions: 108.8K
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an
 * algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 * Note:
 * If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * 
 * 
 * Examples: 
 * 
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * 
 * 
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        if (m == 1) {
            return sum;
        }

        long lo = max, hi = sum;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (!valid(nums, mid, m)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return (int) lo;
    }

    public boolean valid(int[] nums, long target, int m) {
        int count = 1;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                count++;
                sum = num;
            }
        }
        return count <= m;
    }
}

// Time complexity O(NlogN), space complexity O(1)

