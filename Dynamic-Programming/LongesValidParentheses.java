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

//Solution 1: Stack
/*
int a = n, b = 0;
while (!st.empty()) {
    b = st.peek();
    st.pop();
    longest = Math.max(longest, a - b -1);
    a = b;
}
longest = Math.max(longest, a);
*/
//the below is not right, in the case "())" or "(())(()", it will fail with only 0 as output. Actually, we should subtract the 
//adjacent indices to gee the valid parentheses. In the latter one "(())(()", longest = Math.max(longest, a-b-1), where a 
//- b - 1 = 2, that is the last two symbols but actually the right solution shold be the first four elements and so there 
//is "a = b" following, where b = st.peek(), b = 4 and so we will compute "longest = Math.max(longest, a)" that is "Math
//.max(2, 4)", we will get 4 which is the right solution.
//We have to use the above to get rid of such case.

/*
int a = n, b = 0;
if (!st.empty()) {
    b = st.peek();
    st.pop();
    longest = Math.max(longest, a - b -1);
}
*/

// https://discuss.leetcode.com/topic/2289/my-o-n-solution-using-a-stack/2
/*
The workflow of the solution is as below.

Scan the string from beginning to end.
If current character is '(',
push its index to the stack. If current character is ')' and the
character at the index of the top of stack is '(', we just find a
matching pair so pop from the stack. Otherwise, we push the index of
')' to the stack.
After the scan is done, the stack will only
contain the indices of characters which cannot be matched. Then
let's use the opposite side - substring between adjacent indices
should be valid parentheses.
If the stack is empty, the whole input
string is valid. Otherwise, we can scan the stack to get longest
valid substring as described in step 3.
*/

public class Solution {
    public int longestValidParentheses(String s) {
        char [] ch = s.toCharArray();
        Stack <Integer> st = new Stack<Integer>();
        int n = s.length();
        int longest = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == '(') {
                st.push(i);
            } else {
                if (!st.empty()) {
                    if (ch[st.peek()] == '(' ) {
                        st.pop();
                    } else {
                        st.push(i);
                    }
                } else {
                    st.push(i);
                }
                    
            }
        }
        if(st.empty()) {
            longest = n;
        } else {

            int a = n, b = 0;
            while (!st.empty()) {
                b = st.peek();
                st.pop();
                longest = Math.max(longest, a - b -1);
                a = b;
            }
            longest = Math.max(longest, a);
            
            //the below is not right, in the case "())" or "(())(()", it will fail with only 0 as output. Actually, we should subtract the //adjacent indices to gee the valid parentheses. In the latter one "(())(()", longest = Math.max(longest, a-b-1), where a //- b - 1 = 2, that is the last two symbols but actually the right solution shold be the first four elements and so there //is "a = b" following, where b = st.peek(), b = 4 and so we will compute "longest = Math.max(longest, a)" that is "Math//.max(2, 4)", we will get 4 which is the right solution.
            //We have to use the above to get rid of such case.
            /*
            int a = n, b = 0;
            if (!st.empty()) {
                b = st.peek();
                st.pop();
                longest = Math.max(longest, a - b -1);
            }
            */
        }
        return longest;
    }
}

// Solution 2: DP
// https://discuss.leetcode.com/topic/8305/simple-java-solution
/*
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
*/