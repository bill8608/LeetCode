/*
2. Add Two Numbers   QuestionEditorial Solution  My Submissions
Total Accepted: 209490
Total Submissions: 813468
Difficulty: Medium
Contributors: Admin
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Hide Company Tags Amazon Microsoft Bloomberg Airbnb Adobe
Hide Tags Linked List Math
Hide Similar Problems (M) Multiply Strings (E) Add Binary (E) Sum of Two Integers (E) Add Strings (M) Add Two Numbers II
*/

/*
            // not right to assign d.val as following
            //d.val = sum % 10;
			// it should be like below
            d.next = new ListNode(sum % 10);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode d = new ListNode(0);
        ListNode res = d;
        int sum = 0;
        while(c1 != null || c2 != null) {
            sum /= 10;
            if(c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if(c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            // not right to assign d.val as following
            //d.val = sum % 10;
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if(sum / 10 == 1) {
            d.next = new ListNode(sum / 10);
        }
        return res.next;
    }
}