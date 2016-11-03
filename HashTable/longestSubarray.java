/*
3. Longest Substring Without Repeating Characters   QuestionEditorial Solution  My Submissions
Total Accepted: 209359
Total Submissions: 893624
Difficulty: Medium
Contributors: Admin
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Hide Company Tags Amazon Adobe Bloomberg Yelp
Hide Tags Hash Table Two Pointers String
Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Records the most recent occurrence of each entry
        Map<Character, Integer> mostRecentOccurence = new HashMap<>();
        int longestDupFreeSubarrayStartIdx = 0;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            Integer dupIdx = mostRecentOccurence.put(s.charAt(i), i);
            //s.charAt(i) appeared before. Did it appear in the longest current subarray?
            // No. 
            //It returns the previous value associated with key, or null if there was 
            //no mapping for key. (A null return can also indicate that the map previously 
            //associated null with key.)
            //System.out.println("The "+ i +" :" + dupIdx);
            if(dupIdx != null) {
                if(dupIdx >= longestDupFreeSubarrayStartIdx) {
                    result = Math.max(result, i - longestDupFreeSubarrayStartIdx);
                    longestDupFreeSubarrayStartIdx = dupIdx + 1;
                    //System.out.format("The %d : res %d, local %d%n", i, res,local);
                }
            }
        }
        result = Math.max(result, s.length() - longestDupFreeSubarrayStartIdx);
        return result;
    }
}