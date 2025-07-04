package week5.김나은.programmers;

import java.util.Arrays;

public class 예산 {

    class Solution {

        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d); // 부서별 신청 금액을 오름차순으로 정렬 (적은 금액부터 먼저 처리하기 위해)

            // 정렬된 부서별 신청 금액 배열을 순회
            for (int i = 0; i < d.length; i++) {
                if (d[i] <= budget) { // 현재 부서의 신청 금액이 예산보다 작거나 같으면
                    answer += 1; // 지원 가능한 부서 수 증가
                    budget -= d[i]; // 해당 금액만큼 예산 차감
                } else {
                    break; // 예산을 초과하면 반복 중단 (더 이상 지원 불가)
                }
            }

            return answer; // 지원 가능한 최대 부서 수 반환
        }
    }

}
