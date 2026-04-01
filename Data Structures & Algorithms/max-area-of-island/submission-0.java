class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[] area = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area[0] = 0;
                    dfs(grid, i, j, area);
                    maxArea = Math.max(area[0], maxArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j, int[] area) {
        if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 0) {
            return;
        }

        area[0]++;
        grid[i][j] = 0;
        dfs(grid, i-1, j, area);
        dfs(grid, i+1, j, area);
        dfs(grid, i, j-1, area);
        dfs(grid, i, j+1, area);
    }
}
