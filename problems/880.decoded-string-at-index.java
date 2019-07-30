/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */
class Solution {
    private String back(String S, int K, long size, int i) {
        for (int j = i; j >= 0; j--) {
            char cc = S.charAt(j);
            // System.out.println(K + "-" + size);
            if (Character.isDigit(cc)) {
                size /= cc - '0';
                K %= size;
            } else {
                size--;
                if (K == size) {
                    return String.valueOf(cc);
                }
            }
        }
        throw null;
    }

    public String decodeAtIndex(String S, int K) {
        K--;
        long size = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                if (K == size) {
                    return String.valueOf(c);
                }
                size++;
            }
            if (K < size) {
                return back(S, K, size, i);
            }
        }

        throw null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeAtIndex("a2345678999999999999999", 1));
    }
}
