class Solution {
    public int countSubstrings(String s) {
        int numPals = 0;
        char[] sChars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            numPals += expand(sChars, i, i);
            if (i+1 < sChars.length) numPals += expand(sChars, i, i+1);
        }

        return numPals;
    }

    private int expand(char[] s, int l, int r) {
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--; r++;
        }

        return (r-l) / 2;
    }
}
