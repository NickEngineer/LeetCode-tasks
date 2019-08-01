package ua.nick.leetcode.hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber65 {
    public static void main(String[] args) {
        System.out.println(isNumber("959440.94f"));
    }

        /*"0" => true
        " 0.1 " => true
        "abc" => false
        "1 a" => false
        "2e10" => true
        " -90e3   " => true
        " 1e" => false
        "e3" => false
        " 6e-1" => true
        " 99e2.5 " => false
        "53.5e93" => true
        " --6 " => false
        "-+3" => false
        "95a54e53" => false*/

    public static boolean isNumber(String s) {
        boolean returnValue = false;

        String pattern = "(\\s*)(^[^\\S]*)(\\s*)([+-]?)(\\d*)(\\.?)(\\d+)*(e[+-]?\\d+)*(\\s*)($[^\\S]*)(\\s*)";

        Pattern r = Pattern.compile(pattern);

        Matcher mExp;

        mExp = r.matcher(s);

        if (mExp.lookingAt()) {
            returnValue = true;

            try {
                Float.parseFloat(mExp.group());
            } catch (NumberFormatException ex) {
                returnValue = false;
            }
        }

        return returnValue;
    }
}
