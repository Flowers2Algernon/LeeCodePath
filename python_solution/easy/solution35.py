class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums)-1
        middle = int(round((left+right) / 2,0))
        while left < right:
            if nums[middle] == target:
                return middle
            elif nums[middle] > target:
                right = middle
            elif nums[middle] < target:
                left = middle+1
            middle = int(round((left+right) / 2,0))
        if middle == len(nums)-1 and nums[middle] < target:
            return middle+1
        return middle

# ...existing code...

if __name__ == "__main__":
    solution = Solution()
    nums = [1, 3, 5, 6]
    target = 7
    result = solution.searchInsert(nums, target)
    print(f"Index of target {target} in list {nums} is: {result}")