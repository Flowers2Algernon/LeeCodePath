class Solution(object):
    def totalFruit(self, fruits):
        """
        :type fruits: List[int]
        :rtype: int
        """
        start = 0
        end = 1
        result = 0
        fru = {}
        for end in range(len(fruits)):
            if fruits[end] not in fru:
                fru[fruits[end]] = 1
            else:
                fru[fruits[end]] += 1
            while len(fru) > 2:
                fru[fruits[start]] -= 1
                if fru[fruits[start]] == 0:
                    del fru[fruits[start]]
                start += 1
            if end - start + 1 > result:
                result = end - start + 1
        return result

if __name__ == "__main__":
    solution = Solution()
    print(solution.totalFruit([3,3,3,1,2,1,1,2,3,3,4]))

# 问题1： 当set中的元素个数大于2个时，strat的移动不正确
# 问题2： 使用set的方式，无法保证元素的顺序--要求是连续的