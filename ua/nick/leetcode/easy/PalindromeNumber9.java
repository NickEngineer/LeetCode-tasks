package ua.nick.leetcode.easy;

public class PalindromeNumber9 {

    public boolean isPalindrome(int x) {
        boolean result = false;
        if (x > -1 && !(x % 10 == 0 && x != 0)) {
            if (x > 9) {
                int reversed = 0;
                while (x > reversed) {
                    reversed = reversed * 10 + x % 10;
                    x /= 10;
                }
                result = reversed == x || x == reversed / 10;
            } else {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromeNumber9 palindromeNumber = new PalindromeNumber9();
        System.out.println(palindromeNumber.isPalindrome(781959187));
    }
}
