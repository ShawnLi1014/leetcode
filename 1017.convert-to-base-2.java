/*
 * @lc app=leetcode id=1017 lang=java
 *
 * [1017] Convert to Base -2
 *
 * https://leetcode.com/problems/convert-to-base-2/description/
 *
 * algorithms
 * Medium (56.56%)
 * Likes:    70
 * Dislikes: 93
 * Total Accepted:    5.8K
 * Total Submissions: 10.2K
 * Testcase Example:  '2'
 *
 * Given a number N, return a string consisting of "0"s and "1"s that
 * represents its value in base -2 (negative two).
 * 
 * The returned string must have no leading zeroes, unless the string is
 * "0".
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: "110"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: "111"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 4
 * Output: "100"
 * Explantion: (-2) ^ 2 = 4
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= N <= 10^9
 * 
 * 
 * 
 * 
 */
class Solution {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            N = -(N >> 1);
        }
        return sb.length() == 0 ? "0": sb.reverse().toString();
    }
}

