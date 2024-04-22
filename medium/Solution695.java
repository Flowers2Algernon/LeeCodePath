package medium;

/*
* 695. Max Area of Island
You are given an m x n binary matrix grid. An island is a group of 1's
* (representing land) connected 4-directionally (horizontal or vertical.)
* You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
*
* Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
*
* */

public class Solution695 {
}

class Solution69501 {
    public static void main(String[] args) {
        Solution69501 solution69501 = new Solution69501();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(solution69501.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        int maxCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxCount = Math.max(maxCount, search(grid, i, j, visited));
            }
        }
        return maxCount;
    }


    public static int search(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || visited[x][y] || grid[x][y] != 1) {
            return 0;
        }
        visited[x][y] = true;
        int count = 1;
        count+=
        ((search(grid, x + 1, y, visited) ) + (search(grid, x - 1, y, visited) ) + (search(grid, x, y + 1, visited) ) + (search(grid, x, y - 1, visited)));

        return count;
    }
}















