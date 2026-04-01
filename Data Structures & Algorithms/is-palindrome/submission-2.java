class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] sChars = s.toCharArray();
        while (l < r) {
            if (!Character.isLetterOrDigit(sChars[l])) {
                l++;
            }
            else if (!Character.isLetterOrDigit(sChars[r])) {
                r--;
            }
            else {
                if (Character.toLowerCase(sChars[l]) != Character.toLowerCase(sChars[r])) {
                    return false;
                }
                l++; r--;
            }
        }
        return true;
    }
}
