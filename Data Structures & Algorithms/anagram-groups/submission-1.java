class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> countsToStrings = new HashMap<>();
        for (String s : strs) {
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            String countStrRep = new String(sChars);
            countsToStrings.putIfAbsent(countStrRep, new ArrayList<>());
            countsToStrings.get(countStrRep).add(s);
        }
        return new ArrayList<>(countsToStrings.values());
    }
}
