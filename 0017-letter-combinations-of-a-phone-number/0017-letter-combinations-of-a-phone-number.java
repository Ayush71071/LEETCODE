class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, "", res, map);
        return res;
    }

    void backtrack(String digits, int i, String s, List<String> res, String[] map) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }

        for (char c : map[digits.charAt(i) - '0'].toCharArray())
            backtrack(digits, i + 1, s + c, res, map);
    }
}