/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (j = 0; j < Math.min(common.length(), strs[i].length()); j++) {
                if (common.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            common = common.substring(0, j);
        }
        return common;
    }
}
