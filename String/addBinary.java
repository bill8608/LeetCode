/*
67. Add Binary   QuestionEditorial Solution  My Submissions
Total Accepted: 112986
Total Submissions: 377436
Difficulty: Easy
Contributors: Admin
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Hide Company Tags Facebook
Hide Tags Math String
Hide Similar Problems (M) Add Two Numbers (M) Multiply Strings (E) Plus One
Have you met this question in a real interview? Yes  No
Discuss Pick One
*/

//https://discuss.leetcode.com/topic/13698/short-ac-solution-in-java-with-explanation
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0 || b == null || b.length() == 0) {
            return "";
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder ();
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb = sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb = sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
