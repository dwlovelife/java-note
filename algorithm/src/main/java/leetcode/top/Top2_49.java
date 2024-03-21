package leetcode.top;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * @description: 字母异位词分组
 * @author: dingwei17@jd.com
 * @date : 2024/3/5 11:33
 */

public class Top2_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str: strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortStr = new String(array);
            List<String> list = resultMap.getOrDefault(sortStr, new ArrayList<>());
            if (list != null && list.size() > 0) {
                list.add(str);
            } else {
                list.add(str);
                resultMap.put(sortStr, list);
            }
        }
        return new ArrayList<>(resultMap.values());
    }

}
