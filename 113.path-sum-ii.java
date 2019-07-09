/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (40.86%)
 * Likes:    942
 * Dislikes: 35
 * Total Accepted:    239.6K
 * Total Submissions: 582K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currResult = new ArrayList<>();
        dfs(root, sum, currResult, ans);
        return ans;

    }

    public void dfs(TreeNode root, int sum, List<Integer> currResult, List<List<Integer>> ans) {
        if (root == null) {
            return;
        } 
        currResult.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList(currResult));
        } else {
            dfs(root.left, sum - root.val, currResult, ans);
            dfs(root.right, sum - root.val, currResult, ans);
        }
        currResult.remove(currResult.size() - 1);
    }
}
// Time Complexity O(n), since we visit each node once
// Space Complexity O(n)

