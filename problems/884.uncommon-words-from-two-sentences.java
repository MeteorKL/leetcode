import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=884 lang=java
 *
 * [884] Uncommon Words from Two Sentences
 */
class Solution {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : A.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : B.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for(Entry<String, Integer> e :map.entrySet()) {
            if (e.getValue() == 1) {
                list.add(e.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
