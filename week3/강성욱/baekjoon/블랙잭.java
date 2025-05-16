package week3.강성욱.baekjoon;

//음 일딴 정렬해두면 생각이 편할꺼같기도?
//10 500
//93 181 245 214 315 36 185 138 216 295 =>
//36, 93, 138, 181, 185, 214, 216, 245, 295, 315
//? 역순 정렬하고, 만약 안터지는게 발생되면, 그게 가장 작은 합 아냐?
// 이건 논리적으로 안되네;
// 그냥 전부다 3단 반복문ㅇ로 전체 반복
// O(n^3), n=100, O(1_000_000) 이니 할만함.

import java.util.*;

public class 블랙잭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxCount = sc.nextInt();
        int target = sc.nextInt();
        int[] cards = new int[maxCount];

        for (int i = 0; i < maxCount; i++) {
            cards[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 0; i < maxCount - 2; i++) {
            for (int j = i + 1; j < maxCount - 1; j++) {
                for (int k = j + 1; k < maxCount; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= target && sum > max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}