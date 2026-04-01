class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = getMax(piles);
        int m, mVal;
        int best = r;

        while (l <= r) {
            m = l + (r - l) /2;
            mVal = calcHours(piles, m);
            if (mVal <= h) {
                best = Math.min(best, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return best;
    }

    public int getMax(int[] piles) {
        int max = piles[0];
        for (int p : piles) {
            max = Math.max(p, max);
        }
        return max;
    }

    public int calcHours(int[] piles, int rate) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile /  rate);
        }
        return hours;
    }
}
