// https://leetcode.com/problems/max-area-of-island/

class Solution {
    int[][] grid;

    public int areaOfIsland(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        int area = 1;
        grid[i][j] = 0;
        area += areaOfIsland(i + 1, j);
        area += areaOfIsland(i - 1, j);
        area += areaOfIsland(i, j + 1);
        area += areaOfIsland(i, j - 1);

        return area;
    }

    public int maxAreaOfIsland(int[][] og_grid) {
        grid = og_grid;
        int mxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    mxArea = Math.max(mxArea, areaOfIsland(i, j));
                }
            }
        }

        return mxArea;
    }
}
