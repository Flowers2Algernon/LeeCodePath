package easy;
/*You are given row x col grid representing a map where grid[i][j] = 1 represents land
and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally).
The grid is completely surrounded by water,
and there is exactly one island (i.e., one or more connected land cells).
The island doesn't have "lakes",
meaning the water inside isn't connected to the water around the island.
One cell is a square with side length 1. The grid is rectangular,
 width and height don't exceed 100. Determine the perimeter of the island.

 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
         boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
         for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                     result = Math.max(islandPerimeter2(grid, i, j, visited),result);
                    return result;
                }
            }
        }
        return result;
    }
    public int islandPerimeter2(int[][] grid,int i, int j ,boolean[][] visited) {
//        if (visited[i][j] == true) {return 0;}
        if (i<0||j<0|| i>=grid.length || j>=grid[0].length || visited[i][j] ||grid[i][j]!=1) {return 0;}
         visited[i][j]=true;
        int count = 0;
        //接下来是检查临边是否是1，不是的话就加一条边上去
        if (i>0&& grid[i-1][j]==0 || i== 0){
            count++;
        }
        if (i< grid.length-1&& grid[i+1][j]==0 || i== grid.length-1){
            count++;
        }
        if (j>0&& grid[i][j-1]==0 || j== 0){
            count++;
        }
        if (j< grid[0].length-1&& grid[i][j+1]==0 || j== grid[0].length-1){
            count++;
        }
        count += islandPerimeter2(grid,i-1,j,visited)+islandPerimeter2(grid,i+1,j,visited)+islandPerimeter2(grid,i,j-1,visited)+islandPerimeter2(grid,i,j+1,visited);
        return count;
    }
}
