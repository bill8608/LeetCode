/*
392. Is Subsequence   QuestionEditorial Solution  My Submissions
Total Accepted: 13324
Total Submissions: 30358
Difficulty: Medium
Contributors: Admin
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags Binary Search Dynamic Programming Greedy
*/

/*
The point is the corner case:

1. t == null, s == null, t.length() == 0, s.length() == 0, t.length() < s.length()
				false      true                              true                                 false

We can classify into three categories:

t == null || t.length() < s.length()

s == null || s.length() == 0

s.length() == 0 &&  t.lenth() == 0
*/

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t == null || t.length() < s.length()) {
            return false;
        }
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        char [] sCh = s.toCharArray();
        char [] tCh = t.toCharArray();
        int sLen = s.length();
        int tLen = t.length();
        int i = 0;
        while (i < sLen) {
            int j = i;
            while (j < tLen) {
                if (sCh[i] == tCh[j]) {
                    if (i == sLen - 1) {
                        return true;
                    }
                    ++i;
                }
                ++j;
                if (j == tLen) {
                    return false;
                }
            }
        }
        return false;
    }
}