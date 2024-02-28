package leetcode.arr;

public class LeetCode76 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int[] data = new int[128];
        for (int i = 0; i < t.length(); i++) {
            data[t.charAt(i)]++;
        }
        int l = 0, r = 0, count = t.length(), start = -1, size = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (data[c] > 0) {
                count--;
            }
            data[c]--;
            if (count == 0) {
                while (l < r && data[s.charAt(l)] < 0) {
                    data[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    start = l;
                    size = r - l + 1;
                }
                data[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return start == -1 ? "": s.substring(start, start + size);
    }
}
