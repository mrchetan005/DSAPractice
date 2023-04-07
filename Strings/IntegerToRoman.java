package Strings;

/*
        * LEETCODE: 12. Integer To Roman
        * https://leetcode.com/problems/integer-to-roman/

        * LEETCODE: 13. Roman To Integer
        * https://leetcode.com/problems/roman-to-integer/
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static int romanToInt(String s) {
        int answer = 0, number = 0, prev = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            answer += (number < prev) ? -number : number;
            prev = number;
        }
        return answer;
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(intToRoman(3462));
        System.out.println(romanToInt("MMMCDLXII"));
    }
}
