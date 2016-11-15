/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

Hide Company Tags Amazon Google Apple
Hide Tags Binary Search Divide and Conquer
Hide Similar Problems (M) Search a 2D Matrix
*/

/*
https://discuss.leetcode.com/topic/20064/my-concise-o-m-n-java-solution/21
@chicm

We start search the matrix from top right corner, initialize the current position to top right corner, 
if the target is greater than the value in current position, then the target can not be in entire row of 
current position because the row is sorted, if the target is less than the value in current position, then 
the target can not in the entire column because the column is sorted too. We can rule out one row or one 
column each time, so the time complexity is O(m+n).
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <= matrix.length - 1 && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                ++row;
            } else {
                --col;
            }
        }
        return false;
    }
}

// Divide and conquer
//https://discuss.leetcode.com/topic/19643/c-divide-and-conquer-solution
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }
    public boolean search(int[][] matrix, int top, int left, int bottom, int right, int target) {
        if(top>bottom || left>right) {
            return false;
        }
        int midY = (bottom + top) / 2;
        int midX = (right + left) / 2;
        int center = matrix[midY][midX];
        if(center < target) {
            return search(matrix, top, midX + 1, midY, right, target) || search(matrix, midY + 1, left, bottom, right, target);
        } else if (center > target) {
            return search(matrix, top, left, midY - 1, right, target) || search(matrix, midY, left, bottom, midX - 1, target);
        } else {
            return true;
        }
    }
}