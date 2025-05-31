package week5.김나은.programmers;

public class 타겟_넘버 {

    class Solution {

        public int solution(int[] numbers, int target) {
            int answer = 0;

            // DFS를 시작: 초기 인덱스 0, 초기 합계 0에서 시작
            answer = dfs(numbers, 0, 0, target);

            // 가능한 조합의 수를 반환
            return answer;
        }

        // DFS 함수: 현재 인덱스 n, 현재 합계 sum, 목표 값 target
        int dfs(int[] numbers, int n, int sum, int target) {
            // 종료 조건: 모든 숫자를 다 사용했을 때
            if (n == numbers.length) {
                // 현재까지의 합이 타겟과 같다면 1 반환 (성공한 경우 1개)
                if (sum == target) {
                    return 1;
                }
                // 그렇지 않으면 0 반환 (실패한 경우)
                return 0;
            }

            // 재귀 호출 2가지 경우:
            // 1. 현재 숫자를 더한 경우
            // 2. 현재 숫자를 뺀 경우
            // 두 경우의 결과를 합산해서 반환
            return dfs(numbers, n + 1, sum + numbers[n], target) +
                    dfs(numbers, n + 1, sum - numbers[n], target);
        }
    }
}
