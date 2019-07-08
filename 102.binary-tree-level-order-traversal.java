/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (48.73%)
 * Likes:    1566
 * Dislikes: 43
 * Total Accepted:    394.9K
 * Total Submissions: 804.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        traverse(root, ans, 0);
        return ans;
    }

    public void traverse(TreeNode curr, List<List<Integer>> ans, int level) {
        if (curr == null) {
            return;
        }

        if (ans.size() <= level) {
            List<Integer> res = new ArrayList<>();
            ans.add(res);
        }

        List<Integer> collection = ans.get(level);
        collection.add(curr.val);
        traverse(curr.left, ans, level + 1);
        traverse(curr.right, ans, level + 1);
    }
}

