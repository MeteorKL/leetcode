import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=893 lang=java
 *
 * [893] Groups of Special-Equivalent Strings
 */
class Solution {
    public String getSignature(String s) {
        int odd[] = new int[26];
        int even[] = new int[26];
        for (int i = 0; i < s.length(); i += 2) {
            even[s.charAt(i) - 'a']++;
        }
        for (int i = 1; i < s.length(); i += 2) {
            odd[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(odd[i]).append('-');
        }
        for (int i = 0; i < 26; i++) {
            sb.append(even[i]).append('-');
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    // ["axaxaxaxaxaxaxaxaxaxaxbx", "axbxbxbxbxbxbxbxbxbxbxbx"]
    // public static void main(String[] args) {
    //     String[] arr = new String[2];
    //     arr[0] = "axaxaxaxaxaxaxaxaxaxaxbx";
    //     arr[1] = "axbxbxbxbxbxbxbxbxbxbxbx";
    //     System.out.println(new Solution().numSpecialEquivGroups(arr));
    // }

    public int numSpecialEquivGroups(String[] A) {
        int strCnt = A.length;
        if (A == null || strCnt == 0) {
            return 0;
        }
        if (strCnt == 1) {
            return 1;
        }
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < A.length; i++) {
            set.add(getSignature(A[i]));
        }
        return set.size();
    }
}
