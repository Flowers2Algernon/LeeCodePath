from typing import List


class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        list_result = [[0 for x in range(len(grid)-2)] for y in range(len(grid)-2)]
        for i in range(len(list_result)):
            for j in range(len(list_result[0])):
                list_result[i][j] = self.findTheMaxNumber(i,j,grid)
        return list_result

    def findTheMaxNumber(self,i:int,j:int,grid:List[List[int]])->int:
        maxNumber = 0
        for k in range(i,i+3):
            for m in range(j,j+3):
                maxNumber = max(maxNumber,grid[k][m])
        return maxNumber