package test;

import java.util.Scanner;

class Solution_1 {
    public int compare(String version1, String version2) {

        return 0;
    }
}

public class Main_1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = Integer.valueOf(cin.nextLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = cin.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.valueOf(line[j]);
            }
        }

        System.out.println("");
    }
}
