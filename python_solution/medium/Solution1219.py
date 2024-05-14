from typing import List


class Solution:

    def getMaximumGold(self, grid: List[List[int]]) -> int:
        rowLength = len(grid)
        columnLength = len(grid[0])
        sum = 0
        visited = [[False for _ in range(rowLength)] for _ in range(columnLength)]
        for i in range(rowLength):
            for j in range(columnLength):
                sum = max(sum, self.findTheMaxPath(i, j, grid, visited))
        return sum

    def findTheMaxPath(self, i, j, grid, visited):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid) or visited[i][j] or grid[i][j] == 0:
            return 0
        visited[i][j] = True
        sum = grid[i][j]
        sum += max(max(self.findTheMaxPath(i + 1, j, grid, visited), self.findTheMaxPath(i - 1, j, grid, visited)),
                   max(self.findTheMaxPath(i, j + 1, grid, visited), self.findTheMaxPath(i, j - 1, grid, visited)))
        visited[i][j] = False
        return sum


if __name__ == "__main__":
    solution = Solution()
    grid = [[0,6,0],[5,8,7],[0,9,0]]
    sum = solution.getMaximumGold(grid)
    print(sum)