package ua.nick.leetcode.easy;

/*
*
    67. Add Binary
    Easy

    Given two binary strings, return their sum (also a binary string).

    The input strings are both non-empty and contains only characters 1 or 0.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"
    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"

    "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
 *  */

public class AddBinary67 {

    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public static String addBinary(String a, String b) {

        char[] aChars = a.toCharArray(),
                bChars = b.toCharArray();

        int maxLength = Math.max(aChars.length, bChars.length) + 1;

        StringBuilder stringBuilder = new StringBuilder(maxLength + 1);
        int sumTwoCharsValue = 0;


        for (int aP = aChars.length - 1, bP = bChars.length - 1; aP >= 0 || bP >= 0; --aP, --bP) {
            if (aP >= 0 && bP >= 0) {
                sumTwoCharsValue += (int) aChars[aP] + (int) bChars[bP] - 96;
                sumTwoCharsValue = sumValues(stringBuilder, sumTwoCharsValue);
            } else if (aP >= 0) {
                sumTwoCharsValue += (int) aChars[aP] - 48;
                sumTwoCharsValue = sumValues(stringBuilder, sumTwoCharsValue);
            } else {
                sumTwoCharsValue += (int) bChars[bP] - 48;
                sumTwoCharsValue = sumValues(stringBuilder, sumTwoCharsValue);
            }
        }

        if (sumTwoCharsValue != 0) {
            stringBuilder.append(sumTwoCharsValue);
        }

        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    private static int sumValues(StringBuilder stringBuilder, int sumTwoCharsValue) {
        if (sumTwoCharsValue == 2) {
            stringBuilder.append(0);
            sumTwoCharsValue = 1;
        } else if (sumTwoCharsValue == 3) {
            stringBuilder.append(1);
            sumTwoCharsValue = 1;
        } else {
            stringBuilder.append(sumTwoCharsValue);
            sumTwoCharsValue = 0;
        }
        return sumTwoCharsValue;
    }
}
