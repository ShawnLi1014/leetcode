/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (36.66%)
 * Likes:    1211
 * Dislikes: 256
 * Total Accepted:    189.9K
 * Total Submissions: 515.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode start = head;
        ListNode then = head.next;
        ListNode test = start;
        while (start != null) {
            for (int i = 1; i < k; i++) {
                test = test.next;
                if (test == null) {
                    return dummy.next;
                }
            }
            for (int i = 1; i < k; i++) {
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
                then = start.next;
            }
            prev = start;
            start = start.next;
            if (start != null) {
                then = start.next;
                test = start;
            }
        }
        return dummy.next;
    }
}
// Time complexity: O(n), space complexity O(1)

