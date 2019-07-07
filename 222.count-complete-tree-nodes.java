/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (34.02%)
 * Likes:    1022
 * Dislikes: 140
 * Total Accepted:    126.9K
 * Total Submissions: 367.1K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * Output: 6
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
    public int countNodes(TreeNode root) {
        int depth = depth(root);
        if (depth == 0) {
            return 0;
        }
        if (depth(root.right) == depth - 1) {
            return (1 << depth - 1) + countNodes(root.right);
        } else {
            return (1 << depth - 2) + countNodes(root.left);
        }
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + depth(root.left);
    }
}

// Time Complexity O(log((n)^2)), Space complexity 

