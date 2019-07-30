import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=893 lang=java
 *
 * [893] Groups of Special-Equivalent Strings
 */
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        int strCnt = A.length;
        if (A == null || strCnt == 0) {
            return 0;
        }
        if (strCnt == 1) {
            return 1;
        }
        int len = A[0].length();
        int oddWordCnt[][] = new int[strCnt][26];
        int evenWordCnt[][] = new int[strCnt][26];
        for (int i = 0; i < strCnt; i++) {
            for (int j = 0; j < len; j++) {
                int offset = A[i].charAt(j) - 'a';
                if (j%2==0) {
                    evenWordCnt[i][offset]++;
                } else {
                    oddWordCnt[i][offset]++;
                }
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strCnt; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                builder.append(evenWordCnt[i][j]).append('-');
            }
            for (int j = 0; j < 26; j++) {
                builder.append(oddWordCnt[i][j]).append('-');
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}
