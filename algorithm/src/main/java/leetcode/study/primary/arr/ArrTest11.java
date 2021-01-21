package leetcode.study.primary.arr;


public class ArrTest11 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boards = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = c - '1';
                    int index = (i / 3) * 3 + j / 3;
                    if (rows[i][n] != 0 || columns[j][n] != 0 || boards[index][n] != 0) {
                        return false;
                    }
                    rows[i][n] = 1;
                    columns[j][n] = 1;
                    boards[index][n] = 1;
                }
            }
        }
        return true;
    }

}
