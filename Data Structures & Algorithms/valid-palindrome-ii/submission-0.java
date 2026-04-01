class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() -1;
        char[] sChars = s.toCharArray();

        while (l < r) {
            if (sChars[l] != sChars[r]) {
                return isPalindrome(sChars, l+1, r) || isPalindrome(sChars, l, r-1); 
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean isPalindrome(char[] sChars, int l, int r) {
        while (l < r) {
            if (sChars[l] != sChars[r]) return false;
            l++; r--;
        }
        return true;
    }
}