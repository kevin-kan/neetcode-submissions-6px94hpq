class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] sChars = s.toCharArray();

        while (left <= right) {
            if (!Character.isLetterOrDigit(sChars[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(sChars[right])) {
                right--;
            } else {
                if (Character.toLowerCase(sChars[left]) != Character.toLowerCase(sChars[right])) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
