from typing import List


class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        sum = 0
        happiness.sort() #ascending order
        length = len(happiness)
        for i in range(k):
            if  happiness[length-i-1]-i>0:
                sum += happiness[length-i-1]-i
            else:sum+=0
        return sum
