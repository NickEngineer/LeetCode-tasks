package ua.nick.leetcode.easy;

/*
    * 118. Pascal's Triangle
    Easy

    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle118 {

    public static void main(String[] args) {
        System.out.println(generate(12).toString());
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalsTriangleList = new LinkedList<>();
        List<Integer> trianglesRow, lastRowPointer;

        if (numRows > 0) {
            trianglesRow = new ArrayList<>(1);
            trianglesRow.add(1);
            pascalsTriangleList.add(trianglesRow);

            for (int i = 2; i <= numRows; ++i) {
                trianglesRow = new ArrayList<>(i);

                lastRowPointer = ((LinkedList<List<Integer>>) pascalsTriangleList).getLast();

                for (int j = 0; j < i; ++j) {
                    if (j == 0 || j == i - 1) {
                        trianglesRow.add(1);
                    } else {
                        trianglesRow.add(lastRowPointer.get(j) + lastRowPointer.get(j - 1));
                    }

                }

                pascalsTriangleList.add(trianglesRow);
            }
        }

        return pascalsTriangleList;
    }
}
