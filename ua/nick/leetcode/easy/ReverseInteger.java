package ua.nick.leetcode.easy;

//7.  ReverseInteger

import static java.lang.Math.toIntExact;

public class ReverseInteger {
    public static void main(String args[]) {
        int length = String.valueOf(1000).length();

        System.out.println(reverse(1563847412));
    }

    public static int reverse(int x) {

        long res = 0;

        int temp = 0;

        boolean positive = true;

        if (x < 0) {
            positive = false;
            x = Math.abs(x);
        }

        int length = (int) (Math.log10(x) + 1);


        for (int i = 0; i < length; ++i) {
            temp = x % 10;
            x /= 10;

            if (res == 0 && temp == 0) {
                continue;
            }

            res += temp;

            if (i != length - 1) {
                res *= 10;
            }
        }
        if (!positive) {
            res *= -1;
        }

        if (res < -2147483648 || res > 2147483647) {
            res = 0;
        }

        return toIntExact(res);
    }
}
