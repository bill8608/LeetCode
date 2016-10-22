/*
168. Excel Sheet Column Title   QuestionEditorial Solution  My Submissions
Total Accepted: 79092
Total Submissions: 333131
Difficulty: Easy
Contributors: Admin
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags Math
Hide Similar Problems (E) Excel Sheet Column Number
*/
/*
The point is to change the A-Z from 1 base to 0 base.
*/

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char)((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}