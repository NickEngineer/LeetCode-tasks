package ua.nick.leetcode.easy;

/*
    * 119. Pascal's Triangle II
    Easy

    Given a non-negative index k where k ≤ 33, return the kth index
    row of the Pascal's triangle.

    Note that the row index starts from 0.


    In Pascal's triangle, each number is the sum of
    the two numbers directly above it.

    Example:

    Input: 3
    Output: [1,3,3,1]
    Follow up:

    Could you optimize your algorithm to use only O(k) extra space?
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2_119 {

    public static void main(String[] args) {
        System.out.println(getRow(4).toString());
    }

    public static List<Integer> getRow(int rowIndex) {
        ++rowIndex;
        List<Integer> pascalsTriangleRow = new ArrayList<>(rowIndex);
        int[] arraySearch = new int[rowIndex];
        int[] arraySearchTemp = new int[rowIndex];

        pascalsTriangleRow.add(1);

        if (rowIndex > 1) {
            arraySearchTemp[0] = 1;
            arraySearchTemp[1] = 1;
            System.arraycopy(arraySearchTemp, 0, arraySearch, 0, 2);

            for (int i = 1; i < rowIndex - 1; ++i) {
                arraySearch[0] = 1;
                for (int j = 1; j <= i + 1; ++j) {
                    arraySearch[j] = arraySearchTemp[j - 1] + arraySearchTemp[j];
                }

                System.arraycopy(arraySearch, 0, arraySearchTemp, 0, i + 2);

            }

            for (int i = 1; i < arraySearch.length; ++i) {
                pascalsTriangleRow.add(arraySearch[i]);
            }
        }

        return pascalsTriangleRow;
    }
}
