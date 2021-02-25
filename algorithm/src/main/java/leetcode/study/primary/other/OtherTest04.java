package leetcode.study.primary.other;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class OtherTest04 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> lists = generate(numRows);
        for(int i = 0; i < lists.size(); i++){
            System.out.println(Arrays.toString(lists.get(i).toArray()));
        }
    }


    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return null;
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1));
        if(numRows >= 2){
            lists.add(Arrays.asList(1,1));
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 1; j < i; j++){
                int result = lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j);
                list.add(result);
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }

}
