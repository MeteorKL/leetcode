/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    private boolean isPalindromic(String s, int start, int end) {
        for (int offset = 0;; offset++) {
            int localStart = start + offset;
            int localEnd = end - offset;
            if (localStart >= localEnd) {
                return true;
            }
            if (s.charAt(localStart) != s.charAt(localEnd)) {
                return false;
            }
        }
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean startRound = true;
        while (true) {
            System.out.println(s.substring(start, end + 1));
            if (isPalindromic(s, start, end)) {
                break;
            }
            if (startRound) {
                start++;
            } else {
                end--;
            }
            startRound = !startRound;
        }
        return s.substring(start, end + 1);
    }
}
