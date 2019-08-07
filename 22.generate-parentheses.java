/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (56.17%)
 * Likes:    3055
 * Dislikes: 190
 * Total Accepted:    370.5K
 * Total Submissions: 659.1K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        backtrack(res, "", n, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, String cur, int n, int left, int right) {
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if (left < n) {
            backtrack(res, cur + "(", n, left + 1, right);
        }
        if (right < left) {
            backtrack(res, cur + ")", n, left, right + 1);
        }
    }
}

