class Solution(object):
    def sortedSquares(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        start = 0
        end = len(nums) - 1
        res = [0] * len(nums)
        for i in range(len(nums)-1,-1,-1):
            if abs(nums[start]) > abs(nums[end]):
                res[i] = nums[start] * nums[start]
                start += 1
            else:
                res[i] = nums[end] * nums[end]
                end -= 1
        return res
    
if __name__ == '__main__':
    solution = Solution()
    print(solution.sortedSquares([-4,-1,0,3,10]))