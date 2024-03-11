package leetcode.top;

import java.util.*;

/**
 * @description: 字母异位词分组
 * @author: dingwei17@jd.com
 * @date : 2024/3/5 11:33
 */
public class Top49 {

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
