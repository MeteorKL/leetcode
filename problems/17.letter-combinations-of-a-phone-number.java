import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
class Solution {
    private static final Map<String, List<String>> m = new HashMap<>();
    static {
        m.put("2", Arrays.asList("a", "b", "c"));
        m.put("3", Arrays.asList("d", "e", "f"));
        m.put("4", Arrays.asList("g", "h", "i"));
        m.put("5", Arrays.asList("j", "k", "l"));
        m.put("6", Arrays.asList("m", "n", "o"));
        m.put("7", Arrays.asList("p", "q", "r", "s"));
        m.put("8", Arrays.asList("t", "u", "v"));
        m.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();
        int len = digits.length();
        if (digits == null || len == 0) {
            return l;
        }
        int total = 1;
        for (int i = 0; i < digits.length(); i++) {
            total *= m.get(String.valueOf(digits.charAt(i))).size();
        }
        for (int i = 0; i < total; i++) {
            int index = i;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < digits.length(); j++) {
                List<String> currentList = m.get(String.valueOf(digits.charAt(j)));
                int size = currentList.size();
                sb.append(currentList.get(index % size));
                index /= size;
            }
            l.add(sb.toString());
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
