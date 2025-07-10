package week11.김상진.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 비밀_코드_해독 {
    import java.util.*;

    class Solution {
        // N: 비밀 코드에 사용될 수 있는 최대 정수 범위 (1부터 N까지)
        private int N;
        // Q: m번의 시도에서 사용자가 입력한 정수 배열 (각 시도마다 5개 정수)
        private int[][] Q;
        // ANS: 각 시도(Q)에 대한 시스템 응답 (실제 비밀 코드와 일치하는 정수의 개수)
        private int[] ANS;

        // possibleCodes: 1부터 N까지 5개를 뽑는 모든 가능한 조합(후보 비밀 코드)을 저장하는 리스트
        private List<int[]> possibleCodes;
        // answerCount: 모든 조건을 만족하는 유효한 비밀 코드의 최종 개수
        private int answerCount;

        /**
         * 주어진 조건들을 모두 만족하는 비밀 코드 조합의 개수를 계산합니다.
         *
         * @param n   비밀 코드에 사용될 수 있는 정수의 최대 범위
         * @param q   사용자가 시도한 정수들을 담은 2차원 배열
         * @param ans 각 시도에 대한 시스템의 응답 (일치하는 정수의 개수)
         * @return 모든 조건을 만족하는 비밀 코드 조합의 총 개수
         */
        public int solution(int n, int[][] q, int[] ans) {
            // 매개변수들을 클래스 멤버 변수에 저장하여 다른 메서드에서 쉽게 접근하도록 합니다.
            this.N = n;
            this.Q = q;
            this.ANS = ans;

            // 가능한 비밀 코드 조합들을 저장할 리스트 초기화
            this.possibleCodes = new ArrayList<>();
            // 유효한 비밀 코드 개수를 세기 위한 카운터 초기화
            this.answerCount = 0;

            // 1부터 N까지의 숫자 중 5개를 선택하는 모든 조합을 재귀적으로 생성합니다.
            // 생성된 각 조합은 possibleCodes 리스트에 추가됩니다.
            generateCombinations(1, new int[5], 0);

            // 생성된 모든 '비밀 코드 후보'에 대해 각각의 유효성을 검증합니다.
            for (int[] candidateCode : possibleCodes) {
                // 현재 후보 코드가 Q와 ANS의 모든 조건을 만족하는지 확인
                if (isValidSecretCode(candidateCode)) {
                    answerCount++; // 모든 조건을 만족하면 카운트 증가
                }
            }

            // 최종적으로 유효한 비밀 코드 조합의 총 개수를 반환합니다.
            return answerCount;
        }

        /**
         * 재귀를 사용하여 1부터 N까지의 숫자 중 5개의 조합을 모두 생성합니다.
         * 생성된 조합은 `possibleCodes` 리스트에 저장됩니다.
         *
         * @param startNum          현재 숫자를 선택하기 시작할 범위의 시작 값
         * @param currentCombination 현재까지 선택된 숫자를 담는 배열 (길이 5)
         * @param count             현재까지 `currentCombination`에 선택된 숫자의 개수
         */
        private void generateCombinations(int startNum, int[] currentCombination, int count) {
            // 베이스 케이스 1: 5개의 숫자를 모두 선택했다면, 하나의 조합이 완성된 것입니다.
            if (count == 5) {
                // currentCombination 배열의 사본을 리스트에 추가합니다.
                possibleCodes.add(Arrays.copyOf(currentCombination, 5));
                return;
            }

            // 베이스 케이스 2: 더 이상 유효한 조합을 만들 수 없는 경우 (가지치기)
            // 선택할 수 있는 숫자가 없거나, 남은 자리보다 선택 가능한 숫자가 적다면 탐색 중단
            if (startNum > N || (N - startNum + 1) < (5 - count)) {
                return;
            }

            // 재귀 스텝 1: 현재 숫자(startNum)를 조합에 포함시키는 경우
            currentCombination[count] = startNum;
            generateCombinations(startNum + 1, currentCombination, count + 1);

            // 재귀 스텝 2: 현재 숫자(startNum)를 조합에 포함시키지 않는 경우
            // 다음 숫자로 넘어가서 선택 (currentCombination[count]는 다음 호출에서 덮어씌워짐)
            generateCombinations(startNum + 1, currentCombination, count);
        }

        /**
         * 주어진 후보 비밀 코드가 모든 시도(`Q`)에 대해 시스템 응답(`ANS`)과 일치하는지 검증합니다.
         *
         * @param candidateCode 검증할 5개의 정수로 이루어진 후보 비밀 코드
         * @return 모든 시도 조건을 만족하면 true, 하나라도 만족하지 않으면 false
         */
        private boolean isValidSecretCode(int[] candidateCode) {
            // 후보 코드를 HashSet으로 변환하여 빠른 존재 여부 확인을 가능하게 합니다.
            Set<Integer> candidateSet = new HashSet<>();
            for (int num : candidateCode) {
                candidateSet.add(num);
            }

            // 모든 m번의 시도(`Q` 배열의 각 행)에 대해 검증을 수행합니다.
            for (int i = 0; i < Q.length; i++) {
                int[] query = Q[i];         // i번째 시도에서 사용자가 입력한 5개의 정수
                int expectedCount = ANS[i]; // i번째 시도에 대해 시스템이 응답한 기대 일치 개수
                int actualCount = 0;        // 현재 후보 코드와 query 배열이 실제 일치하는 개수

                // query 배열의 각 숫자가 후보 비밀 코드에 포함되어 있는지 확인
                for (int qNum : query) {
                    if (candidateSet.contains(qNum)) {
                        actualCount++;
                    }
                }

                // 실제 일치 개수가 기대 개수와 다르다면, 이 후보는 유효하지 않습니다.
                if (actualCount != expectedCount) {
                    return false;
                }
            }

            // 모든 시도 조건을 통과했다면, 이 후보 비밀 코드는 유효합니다.
            return true;
        }
    }

}
