/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (41.94%)
 * Likes:    1021
 * Dislikes: 60
 * Total Accepted:    229.3K
 * Total Submissions: 542.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traverse(root, ans, 0);
        return ans;
    }

    public void traverse(TreeNode curr, List<List<Integer>> ans, int level) {
        if (curr == null) {
            return;
        }
        if (ans.size() <= level) {
            List<Integer> levelList = new ArrayList<>();
            ans.add(levelList);
        }
        List<Integer> collection = ans.get(level);
        if (level % 2 == 0) {
            collection.add(curr.val);
        } else {
            collection.add(0, curr.val);
        }
        traverse(curr.left, ans, level + 1);
        traverse(curr.right, ans, level + 1);
    }
}

