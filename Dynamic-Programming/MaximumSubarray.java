/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

Hide Company Tags LinkedIn Bloomberg Microsoft
Hide Tags Array Dynamic Programming Divide and Conquer
Hide Similar Problems (E) Best Time to Buy and Sell Stock (M) Maximum Product Subarray
*/
*/
            //DP thought: Think about in atom angle
            //Think about this problem at atom perspective: at nums[i], how can we deal with it?
            //1. the consecutive subarray ending i -1 is negative/zero, so recount the subarray from i
            //2. it is postive, append nums[i] to the subarray
            
            // Tranverse all the nums[i] in two scenarios: including the local in i - 1 or not.
            //local means the max sum including nums[i]
            // so we need to consider whether we include the max in i - 1 or not
            // Compare each nums[i] with the maximum sum including nums[i - 1]
            // Store the max of these two to the local
            local = Math.max(local + nums[i], nums[i]);
            // Compare locally max with globally max and store the max to global
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int global = nums[0];
        int local = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            //DP thought: Think about in atom angle
            //Think about this problem at atom perspective: at nums[i], how can we deal with it?
            //1. the consecutive subarray ending i -1 is negative/zero, so recount the subarray from i
            //2. it is postive, append nums[i] to the subarray
            
            // Tranverse all the nums[i] in two scenarios: including the local in i - 1 or not.
            //local means the max sum including nums[i]
            // so we need to consider whether we include the max in i - 1 or not
            // Compare each nums[i] with the maximum sum including nums[i - 1]
            // Store the max of these two to the local
            local = Math.max(local + nums[i], nums[i]);
            // Compare locally max with globally max and store the max to global
            global = Math.max(global, local);
        }
        return global;
    }
}