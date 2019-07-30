import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
    private String getSignature(String s) {
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]).append('-');
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String signature = getSignature(str);
            if (!map.containsKey(signature)) {
                map.put(signature, new ArrayList<>());
            }
            map.get(signature).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
