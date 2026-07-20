class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I': ans += (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) ? -1 : 1; break;
                case 'V': ans += 5; break;
                case 'X': ans += (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) ? -10 : 10; break;
                case 'L': ans += 50; break;
                case 'C': ans += (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) ? -100 : 100; break;
                case 'D': ans += 500; break;
                case 'M': ans += 1000;
            }
        }
        return ans;
    }
}
