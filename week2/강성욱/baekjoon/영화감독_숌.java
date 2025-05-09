package week2.강성욱.baekjoon;

import java.util.Scanner;

public class 영화감독_숌 {

    private static final String CODE = String.valueOf(666);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int result = 665;

        for (int i = 1; i <= cnt; i++) {
            result++;
            while (!Integer.toString(result).contains(CODE)) {
                result++;
            }
        }

        System.out.println(result);
    }
}