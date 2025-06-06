package week6.강성욱.programmers;

import java.util.*;

public class 요격_시스템 {
    // 단순 반복으로 풀기에는, 범위가 너무 큼. 500,000 개 케이스의 경우의수 너무 큼.
    // 문제 가정으로, e 기준으로 오름차순 정렬해두고, 가장 끝지점에 뭐 아이기스? 요격 미사일을 발사하면 됨.

    class Solution {
        public int solution(int[][] targets) {
            Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
            int count = 0;
            int last = -1;

            for (int[] target : targets) {
                int start = target[0];
                int end = target[1];

                //만약, 현재 시작지점이, 마지막으로 요격 미사일 발사한 위치보다 같거나, 크다면
                //새로운 요격 미사일을 발사해야됨.
                //그리고 요격 미사일 발사 횟수 증가
                if(start >= last) {
                    count++;
                    last = end;
                }
            }

            return count;
        }
    }
}
