"""
You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time,
provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
"""
from typing import List


class Solution:

    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        boats = 0
        i = 0
        j = len(people) - 1
        while i<=j:
            if people[i]+people[j]<=limit:
                i = i+1
            j = j - 1
            boats = boats + 1
        return boats


    def main(self):
        people = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
        limit = 30
        print(self.numRescueBoats(people, limit))
Solution().main()