class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1Chars[i] - 'a']++;
            s2Count[s2Chars[i] - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int oldCharIdx = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches == 26) return true;

            int newCharIdx = s2Chars[i] - 'a';
            if (s1Count[newCharIdx] == s2Count[newCharIdx]) matches--;
            s2Count[newCharIdx]++;
            if (s1Count[newCharIdx] == s2Count[newCharIdx]) matches++;

            int leftCharIdx = s2Chars[oldCharIdx] - 'a';
            if (s1Count[leftCharIdx] == s2Count[leftCharIdx]) matches--;
            s2Count[leftCharIdx]--;
            if (s1Count[leftCharIdx] == s2Count[leftCharIdx]) matches++;
            
            oldCharIdx++;
        }

        return matches == 26;
    }
}
