/*
283. Move Zeroes   QuestionEditorial Solution  My Submissions
Total Accepted: 135439
Total Submissions: 287181
Difficulty: Easy
Contributors: Admin
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Bloomberg Facebook
Hide Tags Array Two Pointers
Hide Similar Problems (E) Remove Element
*/

/*
https://discuss.leetcode.com/topic/32632/a-95-26-beat-rate-solution/2
There are two thought:
firstly, do not swap, but assign directly.
secondly, keep a nonzero index: j. Put all nonzero element advance first, the remaining is the '0's.

Two pointer: one scan, the other record.
*/
// Best one
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        //move all nonzero element in advance
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        
        for(;j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
/*
public class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0, l = 0, r = nums.length;
        while(l < r) {
            if(nums[l] != 0) {
                int tmp = nums[zero];
                nums[zero++] = nums[l];
                nums[l] = tmp;
            }
            l++;
        }
    }
}
*/

//My solution
/*
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        //Two pointer
        int n = nums.length - 1;
        int left = 0;
        int right = left + 1;
        while(left <= n && right <= n) {
            while(nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
                right++;
                if(right == n && nums[right] == 0) {
                    return;
                }
                if (left > n || right > n) {
                    return;
                }
            }
            while(nums[left] != 0) {
                left++;
                if(left > n) {
                    return;
                }
            }
            right = Math.max(left + 1, right);
            while(right <= n && nums[right] == 0) {
                right++;
                if(right > n) {
                    return;
                }
            }
        }
    }
}
*/