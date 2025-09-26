package week22.김나은.programmers;

class 숫자_변환하기 {

    class Solution {

        public int solution(int x, int y, int n) {
            // dp[i] = x에서 i로 가는 최소 연산 횟수
            int[] dp = new int[y + 1];

            // x부터 y까지 숫자를 차례로 확인하면서 dp를 채움
            for (int i = x; i < y + 1; i++) {
                // 시작점(x)이 아니고, 아직 도달 못한 숫자라면
                if (i != x && dp[i] == 0) {
                    dp[i] = -1; // 도달 불가 표시
                    continue;   // 이 숫자에서 확장은 못하니까 스킵
                }

                // 1) 현재 숫자 i에서 *2
                if (i * 2 <= y) {
                    // 아직 안 채워진 곳이면 dp[i]+1 저장
                    // 이미 값이 있으면 더 작은 값으로 갱신
                    dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
                }

                // 2) 현재 숫자 i에서 *3
                if (i * 3 <= y) {
                    dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
                }

                // 3) 현재 숫자 i에서 +n
                if (i + n <= y) {
                    dp[i + n] = (dp[i + n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
                }
            }

            // 최종적으로 dp[y] = x에서 y까지 가는 최소 연산 횟수
            return dp[y];
        }
    }
}