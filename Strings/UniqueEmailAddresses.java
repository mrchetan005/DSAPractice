package Strings;

import java.util.HashSet;

/*
    * LEETCODE: 929. Unique Email Addresses
    * https://leetcode.com/problems/unique-email-addresses/
 */

public class UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for (String email : emails) {
            set.add(helper(email));
        }
        return set.size();
    }

    private static String helper(String s) {
        boolean p = true;
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int i = 0;
        while (c != '@') {
            if (c == '+') {
                p = false;
            } else if (c != '.') {
                if (p)
                    sb.append(c);
            }
            c = s.charAt(++i);
        }
        sb.append(s.substring(i));
        return sb.toString();
    }

    // driver code
    public static void main(String[] args) {
        String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        System.out.println(numUniqueEmails(emails));
    }
}
