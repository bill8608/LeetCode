/*
125. Valid Palindrome   QuestionEditorial Solution  My Submissions
Total Accepted: 127447
Total Submissions: 510376
Difficulty: Easy
Contributors: Admin
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Hide Company Tags Microsoft Uber Facebook Zenefits
Hide Tags Two Pointers String
Hide Similar Problems (E) Palindrome Linked List
*/

/*
Do not use s.toLowerCase() at the very beginning cause there might some special characters.

String s
s.contains("[a-zA-Z0-9]+") == true

did not work
*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        //String str = s.toLowerCase();
        //System.out.println(s);
        
        //for loop
        /*
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            while (i < j && !Character.isLetter(a) && !Character.isDigit(a)) {
                a = s.charAt(++i);
            }
            while (i < j && !Character.isLetter(b) && !Character.isDigit(b)) {
                b = s.charAt(--j);
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
        }
        */
        
        //while loop
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            while (i < j && !Character.isLetter(a) && !Character.isDigit(a)) {
                a = s.charAt(++i);
            }
            while (i < j && !Character.isLetter(b) && !Character.isDigit(b)) {
                b = s.charAt(--j);
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
            ++i;
            --j;
        }
        
        
        return true;
    }
}