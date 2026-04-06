class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) return "";
        // Format will be str1str2str3[10, 25, 3, 4]
        
        // First get the lengths:
        List<Integer> lengths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            lengths.add(s.length());
            sb.append(s);
        }

        sb.append(lengths.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        if (str.isEmpty()) return output;
        int splitIndex = str.lastIndexOf('[');

        // Split on the lastIndex of '['
        String lengths = str.substring(splitIndex + 1, str.length() - 1); // "10, 25, 3, 4"
        String strings = str.substring(0, splitIndex); // "str1str2str3"

        String[] strLen = lengths.split(", ");
        int current = 0, len;
        for (String l : strLen) {
            len = Integer.parseInt(l);
            output.add(strings.substring(current, current + len));
            current += len;
        }

        return output;
    }
}
