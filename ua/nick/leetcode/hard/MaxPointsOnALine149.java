package ua.nick.leetcode.hard;

/*
    *149. Max Points on a Line
    Hard

    Given n points on a 2D plane, find the maximum number
    of points that lie on the same straight line.

    Example 1:

    Input: [[1,1],[2,2],[3,3]]
    Output: 3
    Explanation:
    ^
    |
    |        o
    |     o
    |  o
    +------------->
    0  1  2  3  4
    Example 2:

    Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    Output: 4
    Explanation:
    ^
    |
    |  o
    |     o        o
    |        o
    |  o        o
    +------------------->
    0  1  2  3  4  5  6
    NOTE: input types have been changed on April 15, 2019. Please reset to default code
     definition to get new method signature.
* */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxPointsOnALine149 {

    private static class Point implements Comparable {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x + y * 10000;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point delta = (Point) obj;
                return delta.getX() == x && delta.getY() == y;
            }
            return false;
        }

        @Override
        public int compareTo(Object o) {
            int result = 0;
            Point delta = (Point) o;

            if (delta.getX() > x && delta.getY() > y) {
                result = 1;
            } else if (delta.getY() != y && delta.getX() != x) {
                result = -1;
            }

            return result;
        }
    }

    public static void main(String[] args) {

        String input = "[40,-23],[9,138],[429,115],[50,-17],[-3,80],[-10,33],[5,-21],[-3,80],[-6,-65],[-18,26],[-6,-65],[5,72],[0,77],[-9,86],[10,-2],[-8,85],[21,130],[18,-6],[-18,26],[-1,-15],[10,-2],[8,69],[-4,63],[0,3],[-4,40],[-7,84],[-8,7],[30,154],[16,-5],[6,90],[18,-6],[5,77],[-4,77],[7,-13],[-1,-45],[16,-5],[-9,86],[-16,11],[-7,84],[1,76],[3,77],[10,67],[1,-37],[-10,-81],[4,-11],[-20,13],[-10,77],[6,-17],[-27,2],[-10,-81],[10,-1],[-9,1],[-8,43],[2,2],[2,-21],[3,82],[8,-1],[10,-1],[-9,1],[-12,42],[16,-5],[-5,-61],[20,-7],[9,-35],[10,6],[12,106],[5,-21],[-5,82],[6,71],[-15,34],[-10,87],[-14,-12],[12,106],[-5,82],[-46,-45],[-4,63],[16,-5],[4,1],[-3,-53],[0,-17],[9,98],[-18,26],[-9,86],[2,77],[-2,-49],[1,76],[-3,-38],[-8,7],[-17,-37],[5,72],[10,-37],[-4,-57],[-3,-53],[3,74],[-3,-11],[-8,7],[1,88],[-12,42],[1,-37],[2,77],[-6,77],[5,72],[-4,-57],[-18,-33],[-12,42],[-9,86],[2,77],[-8,77],[-3,77],[9,-42],[16,41],[-29,-37],[0,-41],[-21,18],[-27,-34],[0,77],[3,74],[-7,-69],[-21,18],[27,146],[-20,13],[21,130],[-6,-65],[14,-4],[0,3],[9,-5],[6,-29],[-2,73],[-1,-15],[1,76],[-4,77],[6,-29]";
        String input2 = "[[2,4], [3,5], [4,8], [5,14],[6,12],[7,13],[8,17],[9,18]]";
        String input29 = "[[-230,324],[-291,141],[34,-2],[80,22],[-28,-134],[40,-23],[-72,-149],[0,-17],[32,-32],[-207,288],[7,32],[-5,0],[-161,216],[-48,-122],[-3,39],[-40,-113],[115,-216],[-112,-464],[-72,-149],[-32,-104],[12,42],[-22,19],[-6,-21],[-48,-122],[161,-288],[16,11],[39,23],[39,30],[873,-111]]";
        String input30 = "[[560,248],[0,16],[30,250],[950,187],[630,277],[950,187],[-212,-268],[-287,-222],[53,37],[-280,-100],[-1,-14],[-5,4],[-35,-387],[-95,11],[-70,-13],[-700,-274],[-95,11],[-2,-33],[3,62],[-4,-47],[106,98],[-7,-65],[-8,-71],[-8,-147],[5,5],[-5,-90],[-420,-158],[-420,-158],[-350,-129],[-475,-53],[-4,-47],[-380,-37],[0,-24],[35,299],[-8,-71],[-2,-6],[8,25],[6,13],[-106,-146],[53,37],[-7,-128],[-5,-1],[-318,-390],[-15,-191],[-665,-85],[318,342],[7,138],[-570,-69],[-9,-4],[0,-9],[1,-7],[-51,23],[4,1],[-7,5],[-280,-100],[700,306],[0,-23],[-7,-4],[-246,-184],[350,161],[-424,-512],[35,299],[0,-24],[-140,-42],[-760,-101],[-9,-9],[140,74],[-285,-21],[-350,-129],[-6,9],[-630,-245],[700,306],[1,-17],[0,16],[-70,-13],[1,24],[-328,-260],[-34,26],[7,-5],[-371,-451],[-570,-69],[0,27],[-7,-65],[-9,-166],[-475,-53],[-68,20],[210,103],[700,306],[7,-6],[-3,-52],[-106,-146],[560,248],[10,6],[6,119],[0,2],[-41,6],[7,19],[30,250]]";
        //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        //{0, 0}, {1, 65536}, {65536, 0}
        //{{84,250}, {0,0}, {1,0}, {0,-70},{0,-70},{1,-1}, {21,10},{42,90},{-42,-230}}
        int[][] points = {{1, 1}, {1, 1}, {2, 2}, {2, 2}};//{1, 10}, {1, 2}, {1, 2}, {5, 10} //{1, 1}, {3, 2}, {5, 3}, {4, 1},{2,3},{1,4}

        points = getPoints(input);

        System.out.println(maxPoints(points));
    }

    private static int[][] getPoints(String input) {
        String pattern = "[+-]?(\\d+)";

        int[][] points = null;
        List<Integer[]> pointsL = new LinkedList<>();

        Pattern r = Pattern.compile(pattern);

        Matcher mExp;

        mExp = r.matcher(input);

        points = new int[4][2];

        Integer[] element;

        while (mExp.find()) {
            element = new Integer[2];
            element[0] = Integer.parseInt(mExp.group());
            if (mExp.find()) {
                element[1] = Integer.parseInt(mExp.group());
            }
            pointsL.add(element);
        }

        points = new int[pointsL.size()][2];

        int i = 0;
        for (Integer[] elem : pointsL) {
            points[i][0] = elem[0];
            points[i++][1] = elem[1];
        }

        return points;
    }

    public static int maxPoints(int[][] points) {

        int maxNumberOfPoints = 0;

        if (points.length <= 2) {

            maxNumberOfPoints = points.length;
        } else {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int result = 0;

                    if (o1[0] > o2[0]) {
                        result = 1;
                    } else if (o1[0] < o2[0]) {
                        result = -1;
                    } else {
                        if (o1[1] > o2[1]) {
                            result = 1;
                        } else if (o1[1] < o2[1]) {
                            result = -1;
                        }
                    }

                    return result;
                }
            });

            int localMaxNumberOfPoints = 0;
            int y, x, gcd, samePointsOverlap;
            String slope;
            StringBuilder lineSlopeBuilder = new StringBuilder();
            HashMap<String, Integer> linesOfPointsMapCounter = new HashMap<>();

            for (int i = 0; i < points.length; i++) {
                linesOfPointsMapCounter.clear();
                samePointsOverlap = 0;
                localMaxNumberOfPoints = 0;

                for (int j = i; j < points.length; j++) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        samePointsOverlap++;
                        continue;
                    }

                    y = points[j][1] - points[i][1];
                    x = points[j][0] - points[i][0];

                    gcd = gcd(x, y);

                    lineSlopeBuilder.append(x / gcd);
                    lineSlopeBuilder.append("&");
                    lineSlopeBuilder.append(y / gcd);

                    slope = lineSlopeBuilder.toString();
                    lineSlopeBuilder.setLength(0);

                    linesOfPointsMapCounter.put(slope, linesOfPointsMapCounter.getOrDefault(slope, 0) + 1);

                    if (linesOfPointsMapCounter.get(slope) > localMaxNumberOfPoints) {
                        localMaxNumberOfPoints = linesOfPointsMapCounter.get(slope);
                    }
                }
                localMaxNumberOfPoints += samePointsOverlap;
                maxNumberOfPoints = Math.max(localMaxNumberOfPoints, maxNumberOfPoints);
            }
        }

        return maxNumberOfPoints;
    }

    private static long findYByX(int x1, int x2, int y1, int y2, int x) {
        return (((x - x1) * (long) (y2 - y1)) / (x2 - x1) + y1);
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

}
