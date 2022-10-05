package test;

import java.io.*;
import java.util.*;

class Solution {
    public int compare(String version1, String version2) {
        // System.out.printf("in %s %s\n", version1, version2);

        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        if (v1s.length != v2s.length) {
            if (v1s.length - v2s.length > 0) {
                return -1;
            } else {
                return 1;
            }
        }

        for (int i = 0; i < v1s.length; i++) {
            Integer v1 = Integer.valueOf(v1s[i]);
            Integer v2 = Integer.valueOf(v2s[i]);

            // Todo: Integer null, 异常

             System.out.printf("in_1 %d %d\n", v1, v2);

            if (v1 != v2) {
                if (v1 > v2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String a = cin.next();
        String b = cin.next();

        Solution s = new Solution();
        int c = s.compare(a, b);
        System.out.println(c);
    }
}
