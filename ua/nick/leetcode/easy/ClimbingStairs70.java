package ua.nick.leetcode.easy;

/*
    * 70. Climbing Stairs
    Easy

    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Note: Given n will be a positive integer.

    Example 1:

    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:

    Input: 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
* */

import java.math.BigInteger;

public class ClimbingStairs70 {

    private static final BigInteger[] FACTORIAL_TABLE = initFactorialTable();

    private static BigInteger[] initFactorialTable() {
        final long[] factorialTable = new long[46];

        BigInteger[] bigIntegers = new BigInteger[46];

        bigIntegers[0] = new BigInteger("1");


        factorialTable[0] = 1;
        for (int i = 1; i < bigIntegers.length; i++)
            bigIntegers[i] = new BigInteger(bigIntegers[i - 1]
                    .multiply(new BigInteger(Integer.toString(i))).toString());
        //factorialTable[i] = factorialTable[i - 1] * i;
        return bigIntegers;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(46));
    }

    public static int climbStairs(int n) {
        /*int result = 0, fullyTwoDivided = n / 2;

        if (n % 2 == 0) {
            result = 2;
            for (int i = 1; i < fullyTwoDivided; ++i) {
                result += countingTheNumberOfPlacements(i, n - i);
            }
        } else {
            result = 1;
            for (int i = 1; i < fullyTwoDivided + 1; ++i) {
                result += countingTheNumberOfPlacements(i, n - i);
            }
        }*/

        //the best efficiency
        int[] steps = new int[n];
        if (n == 1) {
            return 1;
        }

        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; ++i) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n - 1];
    }

    private static int countingTheNumberOfPlacements(int m, int all) {
        int result = 0;


        result = FACTORIAL_TABLE[all].divide(FACTORIAL_TABLE[all - m])
                .divide(FACTORIAL_TABLE[m]).intValue();

        /*result = (int) ((FACTORIAL_TABLE[all] / (double) FACTORIAL_TABLE[all - m])
                / FACTORIAL_TABLE[m]);*/

        return result;
    }
}
