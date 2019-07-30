import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=884 lang=java
 *
 * [884] Uncommon Words from Two Sentences
 */
class Solution {
    private void update(Map<String, Integer> map, String s) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : A.split(" ")) {
            update(map, s);
        }
        for (String s : B.split(" ")) {
            update(map, s);
        }
        List<String> list = new ArrayList<>();
        map.entrySet().forEach(e -> {
            if (e.getValue() == 1) {
                list.add(e.getKey());
            }
        });
        return list.toArray(new String[list.size()]);
    }
}
