/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longest = 0;
        int currentLen = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            boolean same = false;
            for (int j = i - 1; j >= start; j--) {
                if (s.charAt(j) == currentChar) {
                    same = true;
                    if (currentLen > longest) {
                        longest = currentLen;
                    }
                    currentLen = i - j;
                    start = j + 1;
                    // System.out.println(start + "-" + j + "-" + i + "-" + currentChar);
                    break;
                }
            }
            if (!same) {
                currentLen++;
            }
            // System.out.println(start + "-" + currentLen + "-" + currentChar);
        }
        if (currentLen > longest) {
            longest = currentLen;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
}
