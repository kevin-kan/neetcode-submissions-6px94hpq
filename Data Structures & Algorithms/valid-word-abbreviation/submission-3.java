class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        char[] wordChars = word.toCharArray();
        char[] abbrChars = abbr.toCharArray();
        int c = 0;
        while (c < abbrChars.length) {
            if (i >= wordChars.length) return false;
            if (Character.isDigit(abbrChars[c])) {
                if (abbrChars[c] == '0') return false;
                int nums = 0;
                while (c < abbrChars.length && Character.isDigit(abbrChars[c])) {
                    nums = nums*10 + (abbrChars[c] - '0');
                    c++;
                }
                i += nums;
            } else {
                if (abbrChars[c] != wordChars[i]) return false;
                i++; c++;
            }
        }
        return i == word.length();
    }
}