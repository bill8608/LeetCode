/*
46. Permutations   QuestionEditorial Solution  My Submissions
Total Accepted: 126407
Total Submissions: 323988
Difficulty: Medium
Contributors: Admin
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Subscribe to see which companies asked this question

Hide Tags Backtracking
Hide Similar Problems (M) Next Permutation (M) Permutations II (M) Permutation Sequence (M) Combinations
*/

/*
The point is that the 
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
				
				are defined ouside 
				and copy item every time it is full.
				res.add(new ArrayList<Integer>(item)
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, item, nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> item, int[]nums) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!item.contains(nums[i])) {
                item.add(nums[i]);
                helper(res, item, nums);
                item.remove(item.size() - 1);
            } else {
                continue;
            }
        }
    }
}
