/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (56.90%)
 * Likes:    1702
 * Dislikes: 72
 * Total Accepted:    479.2K
 * Total Submissions: 838K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
// Recursive Time Complexity O(n), space complextiy O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeValues = new ArrayList<Integer>();
        inorder(nodeValues, root);
        return nodeValues;
    }

    private void inorder(List<Integer> nodeValues, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(nodeValues, root.left);
        }
        nodeValues.add(root.val);
        if (root.right != null) {
            inorder(nodeValues, root.right);
        }
    }
}

// Iterative Time Complexity O(n), Space complexity O(n);
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

