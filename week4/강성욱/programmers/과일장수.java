package week4.강성욱.programmers;

import java.util.*;

public class 과일장수 {
    //정렬 때려서 가장 큰순서대로 묶으면 되는거 아닌가?

    class Solution {
        public int solution(int k, int m, int[] score) {
            List<Integer> list = new ArrayList<>();
            for (int s : score) {
                list.add(s);
            }

            list.sort((a, b) -> b - a); // 내림차순

            int total = 0;
            int boxCount = list.size() / m;

            for (int i = 0; i < boxCount; i++) {
                int startIdx = i * m;
                int minScore = list.get(startIdx + m - 1);
                total += minScore * m;
            }

            return total;
        }
    }
}
