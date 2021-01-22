package leetcode.study.primary.str;


public class StrTest10 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int result = search(haystack, needle);
        System.out.println(result);
    }


    private static int[][] dp;

    public static void kmp(String pat) {
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case 如果状态开始 匹配到第一字符 往后推荐 就为1
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++)
                 dp[j][c] = dp[X][c];
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }

    public static int search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        kmp(pat);
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }

}

