/*
147. Insertion Sort List   QuestionEditorial Solution  My Submissions
Total Accepted: 86801
Total Submissions: 276395
Difficulty: Medium
Contributors: Admin
Sort a linked list using insertion sort.

Hide Tags Linked List Sort
Hide Similar Problems (M) Sort List
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 Hi, friend, you asked a good question about a detail which will confuse some readers at the first glance of this code.
To understand why the author didn't add

helper.next = head
you need to understand what this coding is doing first.
This code is trying to constructed a sorted linked list using nodes from the original list, node by node.
For example:
originally 1->3->2->null
helper: 0->null;
after the first loop:
original list :3->2->null
helper:0->1->null
after the second loop:
original list: 2->null
helper:0->1->3->null
after the third loop:
original list :null
helper:0->1->2->3-> null.

See? it is trying to reconstruct a list node by node, while deleting nodes from the original list.
If you connect the new list to original list by writing

helper.next = head;
at the very beginning, in this example, before the first loop
the helper list looks like : 0->1->3->2->null
no matter you start your insertion from head of head.next, it will be TLE, because you are intertwining this two list together by adding and deleting node at the same time, this process will never end.
It is kind of hard to explain, you can try to modify it and print the process to see.
 */
 //https://discuss.leetcode.com/topic/8570/an-easy-and-clear-way-to-sort-o-1-space
 public class Solution {
     public ListNode insertionSortList(ListNode head) {
    		if( head == null ){
    			return head;
    		}
    		
    		ListNode helper = new ListNode(0); //new starter of the sorted list
    		ListNode cur = head; //the node will be inserted
    		ListNode pre = helper; //insert node between pre and pre.next
    		ListNode next = null; //the next node will be inserted
    		//not the end of input list
    		while( cur != null ){
    			next = cur.next;
    			//find the right place to insert
    			while( pre.next != null && pre.next.val < cur.val ){
    				pre = pre.next;
    			}
    			//insert between pre and pre.next
    			cur.next = pre.next;
    			pre.next = cur;
    			pre = helper;
    			cur = next;
    		}
    		
    		return helper.next;
    	}
}