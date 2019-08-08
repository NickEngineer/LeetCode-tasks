package ua.nick.leetcode.easy;

public class HappyNumber202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        boolean answer = false;
        int nNumber = n;
        int buffer = 0;
        byte counter = 0;

        do {
            buffer += powOfNumber(nNumber % 10);
            nNumber /= 10;
            if (nNumber == 0) {
                if (buffer == 1) {
                    answer = true;
                    break;
                } else if (buffer == n) {
                    break;
                }
                nNumber = buffer;
                buffer = 0;
                ++counter;
            }
        } while (counter < 6);

        return answer;
    }

    private static int powOfNumber(int n){
        return n*n;
    }
}
