package medium;

public class Solution1219 {
    public static void main(String[] args) {
        Solution1219 solution1219 = new Solution1219();
        int[][] grid = new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(solution1219.getMaximumGold(grid));
    }
    public int getMaximumGold(int[][] grid) {
        int sum = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum = Math.max(findTheMaxGold(i, j, grid, visited),sum);
            }
        }
        return sum;
    }

    private int findTheMaxGold(int i, int j, int[][] grid, boolean[][] visited) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        int sum = grid[i][j];
        //每次没有将grid[i][j]的值加入到总和中
        visited[i][j]=true;
        //此处是四个方向都进行了访问，实际题目要求是仅能访问一边
        sum +=Math.max( Math.max( findTheMaxGold(i+1,j,grid,visited),findTheMaxGold(i-1,j,grid,visited)),Math.max( findTheMaxGold(i,j+1,grid,visited),findTheMaxGold(i,j-1,grid,visited)));
        visited[i][j]=false;
        return sum;
        //缺少回溯
    }
}
