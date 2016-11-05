/*
129. Sum Root to Leaf Numbers   QuestionEditorial Solution  My Submissions
Total Accepted: 93524
Total Submissions: 269904
Difficulty: Medium
Contributors: Admin
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (H) Binary Tree Maximum Path Sum
*/

// The thought is to use string array to save the path and then convert the string to int using Integer.parseInt() or Integer.valueOf(), then get the sum.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            dfs(res, "", root);
        }
        return sumOfString(res);
    }
    public void dfs(List<String> res, String path, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) {
           dfs(res, path + root.val, root.left); 
        }
        if (root.right != null) {
           dfs(res, path + root.val, root.right); 
        }
    }
    public int sumOfString (List<String> strings) {
        int result = 0;
        for(String s : strings) {
            //result += Integer.parseInt(s);
            result += Integer.valueOf(s);
        }
        return result;
    }
}