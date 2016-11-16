/*
66. Plus One   QuestionEditorial Solution  My Submissions
Total Accepted: 135261
Total Submissions: 372132
Difficulty: Easy
Contributors: Admin
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Hide Company Tags Google
Hide Tags Array Math
Hide Similar Problems (M) Multiply Strings (E) Add Binary (M) Plus One Linked List
*/

/* https://discuss.leetcode.com/topic/24288/my-simple-java-solution/2
Thought
Think simple.
There are two cases only: one is all 9 and the ohter. 
For the 1st one, create more-than-1-digit array with the first digit 1 and all others 0.
For the 2nd one, add 1 and process carry in the given array and return the updated array.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}

//My answer
/* 
//Thought
first, use carry to keep the carry digit,
second, use ArrayList to keep the result after plus one
third, if carry == 1 after the plus one, create a more-than-one-digit array with the first one is 1 and all other digits are 0
else, copy the arraylist to array.

*/
/*
public class Solution {
    public int[] plusOne(int[] digits) {
        int m = digits.length;
        List<Integer> res = new ArrayList<>();
        int carry = 1;
        for(int i = m - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            res.add(m - 1 - i, sum % 10 );
            carry = sum / 10;
        }
        if (carry == 1) {
            int[] r = new int[m + 1];
            r[0] = 1;
            System.out.println("TS1:");
            return r;
        } else {
            int[] r = new int[m];
            for(int i = 0; i < m; i++) {
                r[i] = res.get(m - 1 - i);
            }
            return r;
        }
        //return new int[1];
    }
}
*/
