/*
public class Solution {
    public int searchInsert(int[] nums, int target) {
        //Binary Search
        if(target <= nums[0]) {
            return 0;
        }
        if(target > nums[nums.length -1]) {
            return nums.length;
        }
        
        
        //opertimizaion
        int l = 0, r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
                if (r >= 0) {
                    if (nums[r] < target) {
                        return r + 1;
                    }
                } else {
                    return 0;
                }
            } else if (nums[m] < target) {
                l = m + 1;
                if (l < nums.length) {
                    if (nums[l] > target) {
                        return l;
                    } 
                } else {
                        return nums.length;
                }
            } else {
                break;
            }
        }
        return m;
    }
}

// beat 70%
//https://discuss.leetcode.com/topic/7874/my-8-line-java-solution/2
*/
public class Solution {
  public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
        
/*
public class Solution {
    public int searchInsert(int[] nums, int target) {
        //Binary Search
        if(target <= nums[0]) {
            return 0;
        }
        if(target > nums[nums.length -1]) {
            return nums.length;
        }
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(nums[start] == target) {
            return start;
        }
        if(nums[end] == target) {
            return end;
        }
        return (start + end + 1) / 2;
        
    }
}
*/