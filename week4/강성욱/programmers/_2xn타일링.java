package week4.강성욱.programmers;

public class _2xn타일링 {
    //전형적인 dp 문제
    //n = 1, 1 (세로)
    //n = 2, 1 (세로, 세로)
    //n = 3, 2 (가로x2, 세로), (세로, 가로x2)
    //n = 4, 4
    //이거 사실 피보나치임
    class Solution {
        private static final int DIV = 1_000_000_007;

        public int solution(int n) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1; if(n == 1) return 1;
            dp[2] = 2; if(n == 2) return 2;
            dp[3] = 3; if(n == 3) return 3;
            dp[4] = 5; if(n == 4) return 5;
            dp[5] = 8; if(n == 5) return 8;

            for(int i=6; i<=n; i++) {
                dp[i] = (dp[i-2] + dp[i-1]) % DIV;
            }

            return dp[n];
        }
    }
}
