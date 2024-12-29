class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        left = 0
        right = len(nums) - 1
        middle = int((left + right) / 2)
        while left < right:
            if nums[middle] == target:
                break
            elif nums[middle] < target:
                left = middle + 1
            else:
                right = middle - 1
            middle = int((left + right) / 2)
        if left > right or nums[middle] != target:
            return [-1, -1]
        start = middle
        end = middle
        while start >= 0 and nums[start] == target:
            start -= 1
        while end < len(nums) and nums[end] == target:
            end += 1
        return [start + 1, end - 1]

if __name__ == "__main__":
    solution = Solution()
    print(solution.searchRange([5, 7, 7, 8, 8, 10], 8))
