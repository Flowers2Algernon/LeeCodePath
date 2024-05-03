package medium;

public class Solution165 {
    public static void main(String[] args) {
        Solution165 solution165 = new Solution165();
        System.out.println(solution165.compareVersion("1.0.1", "1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int m = Math.min(split1.length, split2.length);
        for (int i = 0; i < m; i++) {
            if (Integer.valueOf(split1[i]) < Integer.valueOf(split2[i])) {
                return -1;
            }
            if (Integer.valueOf(split1[i]) > Integer.valueOf(split2[i])) {
                return 1;
            }
            if (Integer.valueOf(split1[i]) == Integer.valueOf(split2[i])) {
                continue;
            }
        }
        int n = (split2.length - split1.length);
        if (n < 0) {
            //split2.length<split1.length
            n = Math.abs(n);
            for (int i = split2.length; i < split1.length; i++) {
                if (Integer.valueOf(split1[i]) > 0) {
                    return 1;
                }
                if (Integer.valueOf(split1[i]) < 0) {
                    return -1;
                }
                if (Integer.valueOf(split1[i]) == 0) {
                    continue;
                }
            }
        } else if (n > 0) {
            for (int i = split1.length; i < split2.length; i++) {
                if (Integer.valueOf(split2[i]) > 0) {
                    return -1;
                }
                if (Integer.valueOf(split2[i]) < 0) {
                    return 1;
                }
                if (Integer.valueOf(split2[i]) == 0) {
                    continue;
                }
            }
        } else if (n == 0) {
            return 0;
        }
        return 0;
    }
}