class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        end = 0
        su = 0
        val = 10000
        for end in range(len(nums)):
            su += nums[end]
            while su >= target:
                if end - start + 1 < val:
                    val = end - start + 1
                su -= nums[start]
                start += 1
        if val == 10000:
            return 0
        return val
