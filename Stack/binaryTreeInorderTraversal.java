/*
94. Binary Tree Inorder Traversal   QuestionEditorial Solution  My Submissions
Total Accepted: 159572
Total Submissions: 371921
Difficulty: Medium
Contributors: Admin
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

Hide Company Tags Microsoft
Hide Tags Tree Hash Table Stack
Hide Similar Problems (M) Validate Binary Search Tree (M) Binary Tree Preorder Traversal (H) Binary Tree Postorder Traversal (M) Binary Search Tree Iterator (M) Kth Smallest Element in a BST (H) Closest Binary Search Tree Value II (M) Inorder Successor in BST
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}