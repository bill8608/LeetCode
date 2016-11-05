/*
113. Path Sum II   QuestionEditorial Solution  My Submissions
Total Accepted: 102167
Total Submissions: 333015
Difficulty: Medium
Contributors: Admin
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
Hide Company Tags Bloomberg
Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (E) Binary Tree Paths (E) Path Sum III
*/
/*
Different with the Path Sum which return true or false instead of all the qualified array, this one we need to remove the element if it get back from the left tree.
"item.remove(item.size() - 1);"
*/
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (res == null) {
            return res;
        }
        List<Integer> item = new ArrayList<>();
        DFS(root, sum, res, item);
        return res;
    }
    public void DFS(TreeNode root, int sum, List<List<Integer>> res, List<Integer> item) {
        if (root == null) {
            return;
        }
        item.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(item));
        } else {        
            DFS(root.left, sum - root.val, res, item);
            DFS(root.right, sum - root.val, res, item);
        }
        item.remove(item.size() - 1);
    }
}