from typing import List


class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        scoreClone = score.copy()
        scoreClone.sort()
        n = len(score)
        resultList =score.copy()

        for i in range(n):
            rank = Solution.binanrySearchInLists(self, scoreClone, score[i])
            if  rank==n-1:
                resultList[i] = "Gold Medal"
            elif rank == n-2:
                resultList[i]="Silver Medal"
            elif  rank == n-3:
                resultList[i]="Bronze Medal"
            else:resultList[i]=str(n-rank)
        return resultList

    def binanrySearchInLists(self,list:List[int],aim:int) -> int:
        low = 0
        high = len(list)

        while low<=high:
            mid = (low+high)>>1
            midVal = list[mid]

            if  midVal<aim:
                low = mid+1
            elif midVal > aim:
                high = mid -1
            else:return mid

        return -(low+1)