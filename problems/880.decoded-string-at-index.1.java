/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */
class Solution {
    class Item {
        public long start;
        public long repeatEnd;
        public long end;
        public Item parent;
        public Item child;
        public int repeat;
        public String s;

        public Item() {
            start = 0;
            repeatEnd = 0;
            end = 0;
            child = null;
            repeat = 1;
            s = "";
        }

        public String format() {
            String str = "";
            if (child != null) {
                str += "(" + child.format() + "," + start + "*" + repeat + "," + repeatEnd + "," + end + ")";
            }
            if (!s.isEmpty()) {
                if (!str.isEmpty()) {
                    str += "+";
                }
                str += s;
            }
            return str;
        }

        public String toString() {
            String str = "";
            if (child != null) {
                for (int i = 0; i < repeat; i++) {
                    str += child;
                }
            }
            if (!s.isEmpty()) {
                str += s;
            }
            return str;
        }

        public char charAt(int index) {
            return _charAt(index);
        }

        // private int x = 0;

        private char _charAt(long offset) {
            // System.out.println(offset + ": " + start + "*" + repeat + "," + repeatEnd +
            // "," + end);
            if (offset < repeatEnd) {
                return child._charAt((long) offset % start);
            }
            if (offset < end) {
                return s.charAt((int) (offset - repeatEnd));
            }
            // x++;
            // if (x == 2) {
            // return 0x65;
            // }
            return parent._charAt(offset);
        }
    }

    public String decodeAtIndex(String S, int K) {
        Item result = new Item();
        Item root = result;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ('a' <= c && c <= 'z') {
                result.s += c;
            } else if ('2' <= c && c <= '9') {
                // System.out.printf("%s, %b-%b-%b\n", result.format(), result.s.isEmpty(),
                // result.child != null, result.child!= null ?result.child.s.isEmpty():true);
                if (result.s.isEmpty() && result.child != null && result.child.s.isEmpty()) {
                    // System.out.println(result.format() + String.valueOf(i));
                    result.child.repeat *= result.repeat;
                    result.child.end = result.child.repeatEnd = result.child.start * result.child.repeat;
                    result.child.parent = null;
                    result = result.child;
                    // System.out.println(result.format());
                } else {
                    // System.out.println(result.format());
                    result.end = (result.child != null ? result.child.end * result.repeat : 0) + result.s.length();
                }
                Item temp = new Item();
                result.parent = temp;
                temp.child = result;
                temp.repeat = c - '0';
                temp.start = result.end;
                temp.repeatEnd = temp.start * temp.repeat;
                result = temp;
                // System.out.println(result.format());
            }
        }
        result.end = (result.child != null ? result.child.end * result.repeat : 0) + result.s.length();
        if (result.s.isEmpty() && result.child != null && result.child.s.isEmpty()) {
            // System.out.println(result.format() + String.valueOf(i));
            result.child.repeat *= result.repeat;
            result.child.end = result.child.repeatEnd = result.child.start * result.child.repeat;
            result.child.parent = null;
            result = result.child;
            // System.out.println(result.format());
        }
        // System.out.println(result.format());
        return String.valueOf(root.charAt(K - 1));
        // return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeAtIndex("a23", 6));
    }
}
