/*
88. Merge Sorted Array   QuestionEditorial Solution  My Submissions
Total Accepted: 130899
Total Submissions: 420396
Difficulty: Easy
Contributors: Admin
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Hide Company Tags Microsoft Bloomberg Facebook
Hide Tags Array Two Pointers
Hide Similar Problems (E) Merge Two Sorted Lists
*/
// in-space 
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int l = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[l--] = nums1[i--];
            } else {
                nums1[l--] = nums2[j--];
            }
        }
        while(j >= 0) {
            nums1[l--] = nums2[j--];
        }
        return;
    }
}
// O(n) space
/*
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                num[k++] = nums1[i];
                i++;
            } else {
                num[k++] = nums2[j];
                j++;
            }
        }
        while(i < m) {
            num[k++] = nums1[i++];
        }
        while(j < n) {
            num[k++] = nums2[j++];
        }
        int l = 0;
        for(int s : num) {
            nums1[l++] = s;
        }
        return;
    }
}
*/