package week3.강성욱.programmers;

public class 멀리_뛰기 {
    //dp?
    //n == 1 || 1가지
    //n == 2 || 2가지
    //n == 3 || 3가지
        // (1, 1, 1), (1, 2), (2, 1)
    //n == 4 || 5가지
        // (1, 1, 1, 1), (1, 1, 2), (1, 2, 1), (2, 1, 1), (2, 2)
    //n == 5 || 8가지
        // (1, 1, 1, 1, 1), (1, 1, 1, 2), (1, 1, 2, 1), (1, 2, 1, 1), (1, 2, 2)
        // (2, 1, 1, 1), (2, 1, 2), (2, 2, 1))

    //이거 dp(n) == dp(n-1) + dp(n-2) 인듯?
    //아 이거 테스트 7번부터, overflow 나오는듯? long도 감당 안되는듯
    //모듈러 한걸 메모이제이션 해야됨

    class Solution {
        public long solution(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (n == 3) return 3;
            if (n == 4) return 5;
            if (n == 5) return 8;

            long[] dp = new long[2001];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            dp[4] = 5;
            dp[5] = 8;

            for (int i = 6; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }

            return dp[n];
        }
    }
}
