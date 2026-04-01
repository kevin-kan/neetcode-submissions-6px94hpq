class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        char[] sChars = s.toCharArray();
        char c;
        int left = 0, longest = 0;

        for (int i = 0; i < s.length(); i++) {
            c = sChars[i];
            if (hm.containsKey(c) && hm.get(c) >= left) {
                longest = Math.max(i - left, longest);
                left = hm.get(c) + 1;
            } else {
                longest = Math.max(i - left + 1, longest);
            }
            hm.put(c, i);
        }

        return longest;
    }
}
