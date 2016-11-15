/*
74. Search a 2D Matrix   QuestionEditorial Solution  My Submissions
Total Accepted: 101129
Total Submissions: 285684
Difficulty: Medium
Contributors: Admin
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Hide Tags Array Binary Search
Hide Similar Problems (M) Search a 2D Matrix II
*/

// Thought
        // use binary search for matrix[0][0], matrix[1][0], matrix[2][0], ..., matrix[m-1][0]
        // then use binary search for the potential row
        // search the range first
        // 1, 7
        // 10, 20
        // 23, 50
		// check start and end since the above while loop does not check
		// in the case which there is only one column
        // for the case which there is only one row, it will "jump" the above while and go to the second while which is binary search a 
        // row.
		// narrow the range to matrix[start][0] ~ matrix[end][0], actually check matrix[start] only
// Thought

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // use binary search for matrix[0][0], matrix[1][0], matrix[2][0], ..., matrix[m-1][0]
        // then use binary search for the potential row
        int m = matrix.length;
        int n = matrix[0].length;
        // search the range first
        // 1, 7
        // 10, 20
        // 23, 50
        int start = 0;
        int end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int candidate = matrix[mid][0];
            if (candidate == target) {
                return true;
            } else if (candidate < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        // check start and end since the above while loop does not check
        if (matrix[start][0] == target) {
            return true;
        } else if (matrix[start][0] > target){
            return false;
        }
        if (matrix[end][0] == target) {
            return true;
        } else if (matrix[end][0] < target) {
            start = end;
        }
        
        // in the case which there is only one column
        // for the case which there is only one row, it will "jump" the above while and go to the second while which is binary search a 
        // row.
        if (n == 1) {
            if (matrix[start][0] == target) {
                return true;
            }
            if (matrix[end][0] == target) {
                return true;
            }
            return false;
        }
        
        // narrow the range to matrix[start][0] ~ matrix[end][0], actually check matrix[start] only
        int startN = 0;
        int endN = n - 1;
        while (startN + 1 < endN) {
            int midN = startN + (endN - startN) / 2;
            int candidateN = matrix[start][midN];
            if (candidateN == target) {
                return true;
            } else if (candidateN < target) {
                startN = midN;
            } else {
                endN = midN;
            }
        }
        if (matrix[start][startN] == target) {
            return true;
        }
        if (matrix[start][endN] == target) {
            return true;
        }
        return false;
    }
}