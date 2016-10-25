/*
373. Find K Pairs with Smallest Sums   QuestionEditorial Solution  My Submissions
Total Accepted: 14643
Total Submissions: 50930
Difficulty: Medium
Contributors: Admin
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
Credits:
Special thanks to @elmirap and @StefanPochmann for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags Heap
Hide Similar Problems (M) Kth Smallest Element in a Sorted Matrix
*/

/*
    class Pair{
            int [] pair;
            long sum;
            //public void Pair(int n1, int n2) { // dees not work because we must define it as a constructor //instead of class method.
            Pair(int n1, int n2) {
                pair = new int [] {n1, n2};
                sum = (long) n1 + (long) n2;
            }
    }
        
    class cmpPair implements Comparator<Pair> {
            public int compare(Pair p1, Pair p2) {
                
                // max heap
                //return Long.compare(p2.sum, p1.sum);
                //or
                return (int) (p2.sum - p1.sum);
                
                // min heap
                //return Long.compare(p1.sum, p2.sum);
                //or
                //return (int) (p1.sum - p2.sum);
            }
    }
*/
public class Solution {
    class Pair{
            int [] pair;
            long sum;
            //public void Pair(int n1, int n2) { // dees not work because we must define it as a constructor //instead of class method.
            Pair(int n1, int n2) {
                pair = new int [] {n1, n2};
                sum = (long) n1 + (long) n2;
            }
    }
        
    class cmpPair implements Comparator<Pair> {
            public int compare(Pair p1, Pair p2) {
                
                // max heap
                //return Long.compare(p2.sum, p1.sum);
                //or
                return (int) (p2.sum - p1.sum);
                
                // min heap
                //return Long.compare(p1.sum, p2.sum);
                //or
                //return (int) (p1.sum - p2.sum);
            }
    }
        
        
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(k, new cmpPair());
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Pair temp = new Pair(nums1[i], nums2[j]);
                if (maxHeap.size() < k) {
                    maxHeap.offer(temp);
                } else {
                    if (maxHeap.peek().sum > temp.sum) {
                        maxHeap.poll();
                        maxHeap.offer(temp);
                    }
                }
            }
        }
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            res.add(0, maxHeap.poll().pair);
        }
        return res;
    }
}