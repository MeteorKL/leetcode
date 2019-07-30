/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    private int palindromicLen(String s, int center) {
        int start, end;
        if (center % 2 == 0) {
            start = center / 2 - 1;
            end = center / 2 + 1;
        } else {
            start = (center - 1) / 2;
            end = (center + 1) / 2;
        }
        // System.out.println("palindromicLen: " + (center * 1.0 / 2) + "-" + start + "-" + end);
        for (int offset = 0;; offset++) {
            int localStart = start - offset;
            int localEnd = end + offset;
            if (s.charAt(localStart) != s.charAt(localEnd)) {
                return localEnd - localStart - 1;
            }
            if (localStart == 0 || localEnd == s.length() - 1) {
                return localEnd - localStart + 1;
            }
        }
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int longest = 0;
        int start = 0;
        for (int i = 1; i < 2 * s.length() - 2; i++) {
            int len = palindromicLen(s, i);
            // System.out.println((i * 1.0 / 2) + "-" + len);
            if (len > longest) {
                longest = len;
                start = (i - len + 1) / 2;
            }
        }
        if (longest == 0) {
            longest = 1;
        }
        return s.substring(start, start + longest);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("bb"));
    }
}
