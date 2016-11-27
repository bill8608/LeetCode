/*
21. Merge Two Sorted Lists   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 173523
Total Submissions: 461555
Difficulty: Easy
Contributors: Admin
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Hide Company Tags Amazon LinkedIn Apple Microsoft
Hide Tags Linked List
Hide Similar Problems (H) Merge k Sorted Lists (E) Merge Sorted Array (M) Sort List (M) Shortest Word Distance II
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;
        while (l1 != null && l2 != null) {
            /*
            // first implementation
            while (l1 != null && l2 != null && l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } 
            while (l1 != null && l2 != null && l1.val >= l2.val) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
            */
            
            //////////////////////////////////
            // second implementation
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
            //////////////////////////////
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return l.next;
    }
}