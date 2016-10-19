/*
224. Basic Calculator   QuestionEditorial Solution  My Submissions
Total Accepted: 37268
Total Submissions: 151890
Difficulty: Hard
Contributors: Admin
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.

Subscribe to see which companies asked this question

Hide Tags Stack Math
Hide Similar Problems (M) Evaluate Reverse Polish Notation (M) Basic Calculator II (M) Different Ways to Add Parentheses (H) Expression Add Operators
*/
/*
//Thought
The point is the the use of stack which push each res and sign before "(" and then when encounting first ")", it pop the sign and res. All is in order.

  remaining   stack      	   res		sign
3-(2+(9-4))   []       	        3		  1
 -(2+(9-4))   []                3        -1
  (2+(9-4))   [-1, 3]           0         1
   2+(9-4))   [-1, 3]                2         1
    +(9-4))   [-1, 3]           2         1
     (9-4))   [-1, 3, 1, 2]      0         1
      9-4))   [-1, 3, 1, 2]     9           1
       -4))   [-1, 3, 1, 2]     9           -1
        4))   [-1, 3, 1, 2]    5           -1
         ))   [-1, 3]      2 + 1 * 5 = 7    -1
          )   []         3 + (-1) * 7 = -4   -1
*/
public class Solution {
    public int calculate(String s) {
        int res = 0, sign = 1, len = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res = res + sign * sum;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                stack.push(res);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = stack.pop() + stack.pop() * res;
            } else if (s.charAt(i) ==' ') {
                continue;
            }
        }
        return res;
    }
}