package week4.강성욱.programmers;

public class 피보나치수 {
    //피보나치 계산
    //DP 문제
    class Solution {
        private static final int DIV = 1_234_567;
        public int solution(int n) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1; if(n == 1) return 1;
            dp[2] = 1; if(n == 2) return 1;
            dp[3] = 2; if(n == 3) return 2;
            dp[4] = 3; if(n == 4) return 3;
            dp[5] = 5; if(n == 5) return 5;

            for(int i=6; i<=n; i++) {
                dp[i] = (dp[i-2] + dp[i-1]) % DIV;
            }

            return dp[n];
        }
    }
}
