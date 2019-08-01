package ua.nick.leetcode.medium;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Math.toIntExact;

public class CharToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi(" 00001"));
    }

    public static int myAtoi(String str) {
        long returnValue = 0;
        boolean returnZero = false;
        boolean isNegativeValue = false;
        LinkedList<Character> charValue = new LinkedList<>();

        String pattern = "-|\\d";

        Pattern r = Pattern.compile(pattern);

        Matcher m;

        for (int i = 0; i < str.length(); ++i) {
            if ((' ' == (str.charAt(i))
                    || '+' == (str.charAt(i))
                    || '0' == (str.charAt(i)))
                        && charValue.size() == 0) {
                continue;
            }

            m = r.matcher(Character.toString(str.charAt(i)));

            if (m.lookingAt()) {
                if ('-' == (str.charAt(i)) && charValue.size() == 0) {
                    charValue.add(str.charAt(i));
                    isNegativeValue = true;
                } else if (!('-' == (str.charAt(i)))) {
                    charValue.add(str.charAt(i));
                } else {
                    break;
                }
            } else if (charValue.size() == 0) {
                returnZero = true;
                break;
            } else {
                break;
            }
        }

        if (!returnZero) {
            int startListSize = charValue.size();
            long multiplyBase = 1;
            char lastValue;
            int lastValueInt = 0;

            if(startListSize >= 18){
                if(isNegativeValue){
                    returnValue = Integer.MIN_VALUE;
                } else {
                    returnValue = Integer.MAX_VALUE;
                }

            } else {
                for (int i = charValue.size(); i > 0 ; --i) {
                    lastValue = charValue.removeLast().charValue();

                    if ('-' == (lastValue)) {
                        returnValue *= -1;
                        if(returnValue < Integer.MIN_VALUE){
                            returnValue = Integer.MIN_VALUE;
                        }
                        break;
                    }
                    lastValueInt = Integer.parseInt(Character.toString(lastValue));
                    returnValue += (lastValueInt * multiplyBase);
                    multiplyBase *= 10;
                }

                if(returnValue > Integer.MAX_VALUE){
                    returnValue = Integer.MAX_VALUE;
                }
            }
        }

        return toIntExact(returnValue);
    }
}
