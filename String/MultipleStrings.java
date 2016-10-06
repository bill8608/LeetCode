/*
43. Multiply Strings  QuestionEditorial Solution  My Submissions
Total Accepted: 76366
Total Submissions: 304308
Difficulty: Medium
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
Hide Company Tags Facebook Twitter
Hide Tags Math String
Hide Similar Problems (M) Add Two Numbers (E) Plus One (E) Add Binary
*/

// Solving Thought
/*
This solution is very ingenious.
It split the multiplying to smallest step jus as what we learn when we first involve in in early school years.

The point is to set a rolling array which will save the adjacent two digits.
"int sum = mul + pos[p2]" and "pos[p1] += sum / 10" are easily neglected whicn need more attention.

"if (!(sb.length() == 0 && p == 0))" is also what I did not think of. If the "p == 0" and "p" is the first element 
in the array, we should skip it. "the first element" is interpreted to "sb.length() == 0".
*/

// Knowledge
/*
String str' length, use str.length() instead of str.length or str.size()
To convert String str convert to char array, use str.toCharArray()
StringBuilder sb
sb.toString()
*/
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int [] pos = new int [m + n];
        for ( int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //System.out.println (i + " " + "\n");
                //System.out.println (j + " " + "\n");
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //System.out.println ("mul: " + mul + " " + "\n");
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                //System.out.println ("sum: " + sum + " " + "\n");
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder ();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0":sb.toString();
    }
}