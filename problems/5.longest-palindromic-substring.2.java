/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    private int palindromicLen(String s, int center, boolean actual) {
        int start = center;
        int end = actual?center:center+1;
        // System.out.println("palindromicLen: " + start + "-" + end);
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
        for (int i = 0; i < s.length() - 1; i++) {
            int len = palindromicLen(s, i, true);
            // System.out.println(i + "-" + len);
            if (len > longest) {
                longest = len;
                start = i - (len - 1) / 2;
                // System.out.println(start+ "-" + longest);
            }
            len = palindromicLen(s, i, false);
            // System.out.println(i+ "-" + len);
            if (len > longest) {
                longest = len;
                start = i - (len / 2 - 1);
                // System.out.println(start+ "-" + longest);
            }
        }
        if (longest == 0) {
            longest = 1;
        }
        return s.substring(start, start + longest);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
