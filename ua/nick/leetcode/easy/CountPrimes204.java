package ua.nick.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class CountPrimes204 {

    public static void main(String[] args) {
        System.out.println(countPrimes(12));
        System.out.println(isPrime(11));
    }

    public static int countPrimes(int n) {
        boolean[] selectedNumbers = new boolean[n];
        int numberOfPrimes = 0;
        for (int i = 2; i < n; ++i) {
            if (selectedNumbers[i]) {
                continue;
            }
            ++numberOfPrimes;
            for (int j = 2; i * j < n; ++j) {
                selectedNumbers[j * i] = true;
            }
        }
        return numberOfPrimes;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}