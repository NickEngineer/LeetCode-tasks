package ua.nick.leetcode.easy;

/*
    * 168. Excel Sheet Column Title
    Easy

    Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
        ...
    Example 1:

    Input: 1
    Output: "A"
    Example 2:

    Input: 28
    Output: "AB"
    Example 3:

    Input: 701
    Output: "ZY"
* */

public class ExcelSheetColumnTitle168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(28 % 26);
    }

    public static String convertToTitle(int n) {
        StringBuilder title = new StringBuilder(20);
        int pow = 1;
        double nFindPow = n;
        int charSequence;

        while (nFindPow > 26) {
            nFindPow -= Math.pow(26, ++pow);
        }

        for (int i = 0; i < pow; ++i) {
            n /= (i == 0) ? 1 : 26;
            charSequence = n % 26;
            charSequence = (charSequence == 0) ? 26 : charSequence;

            title.append((char) (charSequence + 64));
            n -= charSequence;
        }

        title.reverse();

        return title.toString();
    }
}
