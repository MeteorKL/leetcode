/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */
class Solution {

    public String decodeAtIndex(String S, int K) {
        K--;
        long size = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else if (Character.isLetter(c)) {
                if (K == size) {
                    return String.valueOf(c);
                }
                size++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            System.out.println(K + "-" + size);
            if (Character.isDigit(c)) {
                size /= c - '0';
                K %= size;
            } else if (Character.isLetter(c)) {
                size--;
                if (K == size) {
                    return String.valueOf(c);
                }
            }
        }
        throw null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeAtIndex("ha22", 5));
    }
}
