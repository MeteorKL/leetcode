/*
 * @lc app=leetcode id=859 lang=java
 *
 * [859] Buddy Strings
 */
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        int diffCount = 0;
        int diffAcc = 0;
        int charFlag = 0;
        boolean charEqual = false;
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a != b) {
                diffCount++;
                diffAcc += (a - b);
                if (diffCount > 2) {
                    break;
                }
            } else if (diffCount == 0) {
                int offset = a - 'a';
                if (((charFlag >> offset) & 1) == 1) {
                    charEqual = true;
                } else {
                    charFlag |= 1 << offset;
                }
            }
        }
        if (diffCount == 2 && diffAcc == 0) {
            return true;
        }
        if (diffCount == 0 && charEqual) {
            return true;
        }
        return false;
    }
}
