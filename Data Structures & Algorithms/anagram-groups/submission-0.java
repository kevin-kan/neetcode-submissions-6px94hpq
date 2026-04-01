class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> countsToStrings = new HashMap<>();
        for (String s : strs) {
            // Count the Characters of the String:
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
            String countStrRep = Arrays.toString(charCount);
            countsToStrings.putIfAbsent(countStrRep, new ArrayList<>());
            countsToStrings.get(countStrRep).add(s);
        }
        return new ArrayList<>(countsToStrings.values());
    }
}
