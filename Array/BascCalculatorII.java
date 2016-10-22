/*
// 227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags String
Hide Similar Problems (H) Basic Calculator (H) Expression Add Operators

*/

/*
Stack is the key point;
As well i = len-1 also needs the second if operation.
For this question, it is like to add '+' to each string and according to this sign which is ahead of the for loop, it can decide how to process the number after the 'sign'. Do not forget to update the 'sign' in each for loop and as well re-assign 'num' to 0.

for (int i: stack) {
				res += i;
}
*/
public class Solution {
    public int calculate(String s) {
        int len = s.length();
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0, res = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                }                
                if (sign == '-') {
                    stack.push(-num);
                }                
                if (sign == '*') {
                    stack.push(stack.pop()*num);
                }                
                if (sign == '/') {
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        for (int i: stack) {
            res += i;
        }
        return res;
    }
}
