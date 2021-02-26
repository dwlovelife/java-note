package leetcode.study.medium.arrstr;


import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class ArrStrTest03 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for(List<String> list:lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String result = String.valueOf(arr);
            if (map.get(result) == null) {
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                map.put(result, strList);
            } else {
                map.get(result).add(strs[i]);
            }
        }
        List<List<String>> response = new ArrayList<>();
        response.addAll(map.values());
        return response;
    }

}


