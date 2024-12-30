class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        res_1 = []
        res_2 = []
        point_1 = 0
        point_2 = 0
        while point_1 < len(s):
            if s[point_1] == '#':
                if res_1:
                    res_1.pop()
            else:
                res_1.append(s[point_1])
            point_1 += 1
        while point_2 < len(t):
            if t[point_2] == '#':
                if res_2:
                    res_2.pop()
            else:
                res_2.append(t[point_2])
            point_2 += 1
        return res_1 == res_2
