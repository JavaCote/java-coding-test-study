package week18.김나은.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 명예의_전당1 {

    class Solution {

        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];

            // 명예의 전당: 지금까지 점수 중 상위 k개만 관리하는 리스트
            List<Integer> rank = new ArrayList<>();

            for (int i = 0; i < score.length; i++) {
                // k번째 이전 인덱스까지 rank에 저장
                rank.add(score[i]);

                // rank 리스트의 크기가 k보다 크면 가장 낮은 점수 제거
                if (rank.size() > k) {
                    rank.remove(Collections.min(rank));
                }
                // 현재 명예의 전당에서 가장 낮은 점수를 발표
                answer[i] = Collections.min(rank);
            }
            return answer;
        }
    }
}