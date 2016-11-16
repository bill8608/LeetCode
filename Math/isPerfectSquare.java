/*
367. Valid Perfect Square   QuestionEditorial Solution  My Submissions
Total Accepted: 22870
Total Submissions: 61913
Difficulty: Medium
Contributors: Admin
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Hide Company Tags LinkedIn
Hide Tags Binary Search Math
Hide Similar Problems (M) Sqrt(x)
*/


//https://discuss.leetcode.com/topic/49325/a-square-number-is-1-3-5-7-java-code


//A square number is 1+3+5+7+
public class Solution {
    public boolean isPerfectSquare(int num) {
         int i = 1;
         while (num > 0) {
             num -= i;
             i += 2;
         }
         return num == 0;
     }
}

/*
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        long g = num;
        while(g*g > num) {
            g = (g + num/g) / 2;
        }
        return g * g == num;
    }
}
*/

/*
public class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 0, end = num;
        while(start <= end) {
            long mid = (end + start) / 2;
            if(mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                start = (int) mid + 1;
            } else {
                end = (int) mid - 1;
            }
        }
        return false;
    }
}
*/