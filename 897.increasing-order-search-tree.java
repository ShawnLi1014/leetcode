/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
 *
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 *
 * algorithms
 * Easy (64.69%)
 * Likes:    280
 * Dislikes: 305
 * Total Accepted:    33.5K
 * Total Submissions: 51.5K
 * Testcase Example:  '[5,3,6,2,4,null,8,1,null,null,null,7,9]'
 *
 * Given a binary search tree, rearrange the tree in in-order so that the
 * leftmost node in the tree is now the root of the tree, and every node has no
 * left child and only 1 right child.
 * 
 * 
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 
 * ⁠      5
 * ⁠     / \
 * ⁠   3    6
 * ⁠  / \    \
 * ⁠ 2   4    8
 * /        / \ 
 * 1        7   9
 * 
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 
 * ⁠1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * ⁠                9  
 * 
 * Note:
 * 
 * 
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
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
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(0);
        curr = result;
        inorder(root);
        return result.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        node.left = null;
        curr.right = node;
        curr = node;
        inorder(node.right);
    }
}

