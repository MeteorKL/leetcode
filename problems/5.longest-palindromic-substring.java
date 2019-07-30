/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {

    private void updatePalindromic(String s, int left, int right) {
        // System.out.println(left + "," + right);
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // System.out.println(s.substring(left, right + 1));
            left--;
            right++;
        }
        left++;
        right--;
        // System.out.println(left + "," + right);
        int len = right - left + 1;
        if (len > longestLen) {
            longestLen = len;
            longestStart = left;
        }
    }

    private int longestStart;
    private int longestLen;

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            updatePalindromic(s, i, i);
            updatePalindromic(s, i, i + 1);
        }
        return s.substring(longestStart, longestStart + longestLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("ac"));
    }
}
