// https://leetcode.com/problems/number-of-islands/

class Solution {
    char[][] grid;

    public void traverseIsland(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        traverseIsland(i - 1, j);
        traverseIsland(i, j - 1);
        traverseIsland(i, j + 1);
        traverseIsland(i + 1, j);
    }

    public int numIslands(char[][] og_grid) {
        grid = og_grid;
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    traverseIsland(i, j);
                }
            }
        }

        return islands;
    }
}
