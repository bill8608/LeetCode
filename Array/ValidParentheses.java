/*
20. Valid Parentheses   QuestionEditorial Solution  My Submissions
Total Accepted: 142029
Total Submissions: 453525
Difficulty: Easy
Contributors: Admin
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Subscribe to see which companies asked this question

Hide Tags Stack String
Hide Similar Problems (M) Generate Parentheses (H) Longest Valid Parentheses (H) Remove Invalid Parentheses
*/

/*
continue can not be neglected. 
the last 
"        if (!stack.isEmpty()) {
            return false;
        }
"
can not be neglected.
*/

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
                continue;
            }
            if (s.charAt(i) == '[' ) {
                stack.push(']');
                continue;
            }
            if (s.charAt(i) == '{') {
                stack.push('}');
                continue;
            } 
            if (stack.isEmpty()) {
                    //System.out.println("stack is Empty");
                    return false;
            } else {
                if (s.charAt(i) == stack.peek()) {
                    stack.pop();
                } else {
                    //System.out.println("stack is not Empty");
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}