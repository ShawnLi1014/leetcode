/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (52.98%)
 * Likes:    306
 * Dislikes: 122
 * Total Accepted:    105.1K
 * Total Submissions: 198.2K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    int ans;

    public int totalNQueens(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        ans = 0;
        int[][] board = new int[n][n];
        backtrack(board, 0);
        return ans;

    }

    public void backtrack(int[][] board, int row) {
        if (row == board.length) {
            ans += 1;
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 1;
                backtrack(board, row + 1);
                board[row][i] = 0;
            }
        }
    }

    private boolean isValid(int[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
            for (int j = 0; j < board[0].length; j++) {
                if (Math.abs(i - row) == Math.abs(j - col)) {
                    if (board[i][j] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

