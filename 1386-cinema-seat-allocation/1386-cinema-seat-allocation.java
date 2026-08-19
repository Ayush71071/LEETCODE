class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        // Seats 2-9 matter.
        for (int[] r : reservedSeats) {
            int row = r[0], seat = r[1];
            if (seat >= 2 && seat <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << seat));
            }
        }

        long ans = 2L * (n - map.size());

        for (int mask : map.values()) {
            boolean left = (mask & ((1 << 2) | (1 << 3) | (1 << 4) | (1 << 5))) == 0;
            boolean mid  = (mask & ((1 << 4) | (1 << 5) | (1 << 6) | (1 << 7))) == 0;
            boolean right = (mask & ((1 << 6) | (1 << 7) | (1 << 8) | (1 << 9))) == 0;

            if (left && right)
                ans += 2;
            else if (left || mid || right)
                ans += 1;
        }

        return (int) ans;
    }
}