package Strings;

public class StringToInteger_atoi {

    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        boolean negative = false;
        long num = 0;

        // skip whitespaces from front of string
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // check for sign given + or - or not given
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            negative = (s.charAt(i) == '-');
            i++;
        }

        // processing the string to number
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');

            // check for overflow
            if (num > Integer.MAX_VALUE) {
                return (negative ? Integer.MIN_VALUE : Integer.MAX_VALUE);
            }

            i++;
        }

        return (int) (negative ? -num : num);
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(myAtoi("+4193 with words"));
        System.out.println(myAtoi("-426464543545"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi(""));
    }
}
