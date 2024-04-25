package medium;

import java.math.BigDecimal;


public class Solution50 {
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        System.out.println(Math.pow(2.0000, -2147483648));
        System.out.println(solution50.myPow1(2.0000, -2147483648));

    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n > 0) {
            BigDecimal bigDecimal = new BigDecimal(x);
            BigDecimal bigDecimal2 = BigDecimal.ONE;
            while (n > 0) {
                if (n % 2 == 1) {
                    bigDecimal2 = bigDecimal2.multiply(bigDecimal);
                }
                bigDecimal = bigDecimal.multiply(bigDecimal);
                n = n / 2;
            }
            String s = bigDecimal2.toString();
            return Double.parseDouble(s);
        } else if (n == 0) {
            return 1;
        } else if (n < 0) {
            BigDecimal bigDecimal = new BigDecimal(x);
            BigDecimal bigDecimal1 = new BigDecimal(x);
            for (int i = 1; i < -n; i++) {
                bigDecimal = bigDecimal.multiply(bigDecimal1);
            }
            BigDecimal bigDecimal2 = bigDecimal.divide(BigDecimal.ONE);
            String s = bigDecimal2.toString();
            return 1.0 / Double.parseDouble(s);
        }
        return 0;
    }


    public double myPow1(double x, int n) {
        double pow = 1;
        double n1 = n;
        if (n1 < 0) {
            n1 = -n1;
            x = 1 / x;
        }
        while (n1 > 0) {
            if (n1 % 2 == 1) {
                pow *= x;
            }
            x = x * x;
            n1 = (int) n1 / 2;
        }
        return pow;
    }
}