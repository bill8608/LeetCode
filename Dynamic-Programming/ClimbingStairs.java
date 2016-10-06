
/*70. Climbing Stairs  
Total Accepted: 133371
Total Submissions: 350880
Difficulty: Easy
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Hide Company Tags Adobe Apple
Hide Tags Dynamic Programming
*/
//Solving thought:
//Dynamic Programming Key: Used for Max/Min, Opertimazation, how many ways, and the like
//Look at (Analyze) the problem from end to start and then code to implement it from start to end.

public class Solution {
    public int climbStairs(int n) {
        int [] dp = new int [n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i-1];
            }
            if (i -2 >= 0) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}