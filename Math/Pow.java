/*
50. Pow(x, n)   QuestionEditorial Solution  My Submissions
Total Accepted: 119952
Total Submissions: 441167
Difficulty: Medium
Contributors: Admin
Implement pow(x, n).

Hide Company Tags LinkedIn Google Bloomberg Facebook
Hide Tags Binary Search Math
Hide Similar Problems (M) Sqrt(x) (M) Super Pow
*/

/* Thought
// need to consider Integer.MIN_VALUE corner case
// as well some corner case, like x == 1.0, n == 0, n < 0 and the result is far less than 0.00001
// Thought
*/

public class Solution {
    public double myPow(double x, int n) {
        //recursion
        if(n == 0 && x != 0.0 || x == 1.0) {
            return 1.0;
        }
        //long l = (long) n;
        if(n < 0) {
            if(n == Integer.MIN_VALUE) {
                return 1.0 / myPow(x, Integer.MAX_VALUE) / x;
            } else {
                return 1.0 / myPow(x, -n);
            }
        }
        double temp = myPow(x, n/2);
        if (temp == 0.00000) {
            return temp;
        }
        //return n % 2 == 0 ? myPow(x, n/2) * myPow(x, n/2) : myPow(x, n/2) * myPow(x, n/2) * x;
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }
}