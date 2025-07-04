package week4.김나은.programmers;

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0; // 최종 수익을 저장할 변수

        // 점수 배열을 오름차순 정렬
        // 가장 비싼 가격을 받으려면 높은 점수끼리 묶어야 하므로, 정렬 후 뒤에서부터 묶음 처리
        Arrays.sort(score);

        // 가장 높은 점수부터 m개씩 묶어서 판매
        // score.length - m: 마지막으로 m개를 정확히 묶을 수 있는 시작 인덱스
        // i -= m: m개씩 뒤로 이동하면서 그룹 처리
        for(int i = score.length - m; i >= 0; i -= m) {
            // 묶은 그룹 중 가장 낮은 점수(score[i]) * 사과 개수(m) = 해당 묶음의 가격
            answer += score[i] * m;
        }

        return answer; // 총 수익 반환
    }
}