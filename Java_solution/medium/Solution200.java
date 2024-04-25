package medium;
/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslands2(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    public int numIslands2(char[][] grid,int i , int j , boolean[][] visited) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j] == '0') return 0;
        visited[i][j] = true;
        numIslands2(grid, i-1, j, visited);
        numIslands2(grid, i+1, j, visited);
        numIslands2(grid, i, j-1, visited);
        numIslands2(grid, i, j+1, visited);
        return 0;
    }
}
