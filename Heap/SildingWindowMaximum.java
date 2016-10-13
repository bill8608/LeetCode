/*
239. Sliding Window Maximum
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window’s size.
Remove redundant elements and the queue should store only elements that need to be considered.
Hide Company Tags Amazon Google Zenefits
Hide Tags Heap
Hide Similar Problems (H) Minimum Window Substring (E) Min Stack (H) Longest Substring with At Most Two Distinct Characters (H) Paint House II
*/
// refer to https://discuss.leetcode.com/topic/19055/java-o-n-solution-using-deque-with-explanation

// The solving thought is at the bottom using the output format.

public class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
			    System.out.format ("The for loop %d: q.peekFirst()= %d i-k+1= %d " + "at 1st while loop %n", i, q.peekFirst(), i - k + 1);
				q.pollFirst();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
			    System.out.format ("The for loop %d: %d " + "at 2nd while loop %n", i, q.peekLast());
				q.pollLast();
			}
			// q contains index... r contains content
			q.offerLast(i);
			System.out.format ("The for loop %d " + "adding %d to deque %n", i, q.peekLast());
			System.out.println ("The deque: " + q);
			if (i >= k - 1) {
				r[ri++] = a[q.peekFirst()];
				System.out.format ("The inde of the maximum: %d%n", q.peekFirst());
			}
			System.out.println("\n");
		}
		return r;
	}
}

/*
Print out:
The for loop 0 adding 0 to deque 
The deque: [0]


The for loop 1: 0 at 2nd while loop 
The for loop 1 adding 1 to deque 
The deque: [1]


The for loop 2 adding 2 to deque 
The deque: [1, 2]
The inde of the maximum: 1


The for loop 3 adding 3 to deque 
The deque: [1, 2, 3]
The inde of the maximum: 1


The for loop 4: q.peekFirst()= 1 i-k+1= 2 at 1st while loop 
The for loop 4: 3 at 2nd while loop 
The for loop 4: 2 at 2nd while loop 
The for loop 4 adding 4 to deque 
The deque: [4]
The inde of the maximum: 4


The for loop 5 adding 5 to deque 
The deque: [4, 5]
The inde of the maximum: 4


The for loop 6: 5 at 2nd while loop 
The for loop 6: 4 at 2nd while loop 
The for loop 6 adding 6 to deque 
The deque: [6]
The inde of the maximum: 6


The for loop 7: 6 at 2nd while loop 
The for loop 7 adding 7 to deque 
The deque: [7]
The inde of the maximum: 7
*/	