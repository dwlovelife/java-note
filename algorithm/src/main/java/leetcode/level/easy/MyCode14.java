package leetcode.level.easy;


public class MyCode14 {
    public static void main(String[] args) {
        String[] testData = {"flower", "flow", "flight", "flag"};
        String prefix = longestCommonPrefix4(testData);
        System.out.println(prefix);
    }

    /**
     * 自己的解法 这写法 真够啰嗦的 （属于横向遍历）
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int sameLength = 0;
        String preStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currentStr = strs[i];
            int lengthFlag = 0;
            for (int j = 0; j < Math.min(preStr.length(), currentStr.length()); j++) {
                if (currentStr.charAt(j) != preStr.charAt(j)) {
                    break;
                }
                lengthFlag++;
            }
            if (lengthFlag == 0) {
                sameLength = 0;
                break;
            }
            sameLength = sameLength == 0 ? lengthFlag : Math.min(sameLength, lengthFlag);
        }
        return sameLength == 0 ? "" : strs[0].substring(0, sameLength);
    }

    /**
     * 横向遍历：其实想一想 最长前缀 从前往后遍历只会变短不会变长 因为会受限前面的元素
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currentStr = strs[i];
            prefix = findMaxPrefix(prefix, currentStr);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String findMaxPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int j = 0;
        while (j < minLength && str1.charAt(j) == str2.charAt(j)) {
            j++;
        }
        return str1.substring(0, j);
    }

    /**
     * 纵向扫描
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char c = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }

    /**
     * 递归分治
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        } else {
            return longestCommonPrefix4(strs, 0, strs.length - 1);
        }
    }

    public static String longestCommonPrefix4(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (start + end) / 2;
            String leftStr = longestCommonPrefix4(strs, start, mid);
            String rightStr = longestCommonPrefix4(strs, mid + 1, end);
            return getCommonPrefix(leftStr, rightStr);
        }
    }

    public static String getCommonPrefix(String left, String right) {
        int n = Math.min(left.length(), right.length());
        for (int i = 0; i < n; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, n);
    }



}
