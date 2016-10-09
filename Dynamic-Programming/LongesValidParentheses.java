/*
32. Longest Valid Parentheses  QuestionEditorial Solution  My Submissions
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

Hide Tags Dynamic Programming String
Show Similar Problems
*/

/*
// Solving thought:
String "s" :double quotation
Char 'c' :single quotation
char [] ch = s.toCharArray();
*/


public class Solution {
    public int longestValidParentheses(String s) {
        int [] dp = new int [s.length()];
        int open = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } 
            if (s.charAt(i) == ')' && open > 0 ) {
                
                //Alternative 1
                dp[i] = 2 + dp[i - 1] + ((i - 2 - dp[i - 1]) > 0?dp[i - 2 - dp[i - 1]]:0);
                

                //Anther form of Alternative 1
                //dp[i] = 2 + dp[i-1];
                //if (i - 2 - dp[i -1] > 0) {
                //    dp[i] += dp[i - 2 - dp[i - 1]];
                //}
                //End of Aleternative 1

                
                //Alternative 2
                //dp[i] = 2 + dp[i - 1] + ((i - dp[i]) > 0?dp[i - dp[i]]:0);
                
                
                //Anther form of Alternative 2
                //dp[i] = 2 + dp[i-1];
                //if (i - dp[i] > 0) {
                //    dp[i] += dp[i - dp[i]];
                //}
                //End of Aleternative 2
                
                
                open--;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}