class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char n = board[r][c];

                if (n == '.') continue;

                if (!set.add(n + " in row " + r) ||
                    !set.add(n + " in col " + c) ||
                    !set.add(n + " in box " + r / 3 + "-" + c / 3))
                    return false;
            }
        }

        return true;
    }
}