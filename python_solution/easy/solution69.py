class Solution(object):
    def mySqrt1(self, x):
        """
        :type x: int
        :rtype: int
        """
        i = 1
        while i * i <= x:
            i += 1
        if i * i == x:
            return i
        dif_1 = x - (i - 1) * (i - 1)
        dif_2 = (i+1) * (i+1) - x
        return i - 1 if dif_1 < dif_2 else i
    def mySqrt2(self ,x):
        left = 1
        right = x
        while left < right:
            middle = int((left + right) / 2)
            if middle * middle == x:
                return middle
            elif middle * middle < x:
                left = middle +1
            else:
                right = middle - 1
        # be mind, the result is round down
        return right

if __name__ == "__main__":
    solution = Solution()
    print(solution.mySqrt2(5))