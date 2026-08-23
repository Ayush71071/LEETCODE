class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] != '.') continue;

                for (char n = '1'; n <= '9'; n++) {
                    if (isValid(board, r, c, n)) {
                        board[r][c] = n;

                        if (solve(board))
                            return true;

                        board[r][c] = '.';
                    }
                }

                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] b, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            if (b[r][i] == n || b[i][c] == n)
                return false;

            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;

            if (b[row][col] == n)
                return false;
        }

        return true;
    }
}