/*
4. Median of Two Sorted Arrays   QuestionEditorial Solution  My Submissions
Total Accepted: 128404
Total Submissions: 627989
Difficulty: Hard
Contributors: Admin
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
Hide Company Tags Google Zenefits Microsoft Apple Yahoo Dropbox Adobe
Hide Tags Binary Search Array Divide and Conquer
*/

/*
https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/113
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        int maxOfLeft = 0;
        int minOfRight = 0;
        int i = 0;
        int j = 0;
        while(iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = halfLen - i;
            if(i < m && j > 0 && nums2[j - 1] > nums1[i]) {
                // i is too small, must increase it
                iMin = i + 1;
            } else if(i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                // i is too big, must decrease it
                iMax = i - 1;
            } else {
                break;
            }
        }
        // i is perfect
        if(i == 0) {
            maxOfLeft = nums2[j - 1];
        } else if(j == 0) {
            maxOfLeft = nums1[i - 1];
        } else {
            maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        
        if((m + n) % 2 == 1) {
            System.out.println("unbalanced");
            return (double) maxOfLeft;
        }
        
        if(i == m && j < n) {
            minOfRight = nums2[j];
        } else if(j == n && i < m) {
            minOfRight = nums1[i];
        } else if(i < m && j < n){
            minOfRight = Math.min(nums1[i], nums2[j]);
        }
        return (maxOfLeft + minOfRight) / 2.0;
    }
}