class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows*cols -1;
        int m, mid;

        while (l <= r) {
            m = ((r - l) / 2) + l;
            mid = matrix[m/cols][m%cols];
            if (mid == target) {
                return true;
            }
            if (mid > target) {
                r = m - 1;
            }
            if (mid < target) {
                l = m + 1;
            }
        }
        return false;
    }

}
