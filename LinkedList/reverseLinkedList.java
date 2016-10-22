/*
206. Reverse Linked List   QuestionEditorial Solution  My Submissions
Total Accepted: 156458
Total Submissions: 368644
Difficulty: Easy
Contributors: Admin
Reverse a singly linked list.

click to show more hints.

Subscribe to see which companies asked this question

Hide Tags Linked List
Hide Similar Problems (M) Reverse Linked List II (M) Binary Tree Upside Down (E) Palindrome Linked List
*/

/*
Plot the graph and it will make thing much easier.
See the attached plot.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre = null;
        ListNode tmp = head.next;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = tmp;
            if (tmp != null) {
                tmp = tmp.next;
            }
        }
        return pre;
    }
}