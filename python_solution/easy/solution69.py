class Solution(object):
    def mySqrt(self, x):
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