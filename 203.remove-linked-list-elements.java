/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (35.86%)
 * Likes:    853
 * Dislikes: 51
 * Total Accepted:    230.1K
 * Total Submissions: 640.7K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
       if (head == null) {
           return head;
       }
       // If the first several node.val == val, move head, head = head.next
       while(head.val == val && head != null) {
           head = head.next;
           if (head == null) {
               return head;
           }
       }
       // p.val is not val, start from p.next
       ListNode p = head;
       while (p.next != null) {
           if (p.next.val == val) {
                p.next = p.next.next;
           } else {
                p = p.next;
           }
       }
       return head;
    }
}
// Time complexity O(n), Space complexity O(1)

