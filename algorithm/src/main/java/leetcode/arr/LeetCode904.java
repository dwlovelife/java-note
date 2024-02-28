package leetcode.arr;

import javax.validation.constraints.Max;
import java.util.HashMap;
import java.util.Map;

public class LeetCode904 {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int subLength = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                int count = map.get(fruits[left]) - 1;
                if (count == 0) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], count);
                }
                left++;
            }
            subLength = Math.max(subLength, right - left + 1);
        }
        return subLength;
    }
}
