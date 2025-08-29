/**
 * PackageName : week18.이상억.progarmmers;
 * FileName    : 완전범죄
 * Author      : sangeok
 * Date        : 2025. 08. 28.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 28.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    static final int INF = 100000;

    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        int[][] dp = new int[size + 1][m];
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= size; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            for (int j = 0; j < m; j++) {
                if (dp[i - 1][j] >= INF) continue;
                // A가 훔치는 경우
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                // B가 훔치는 경우
                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }

        int answer = INF;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[size][j]);
        }

        return (answer >= n) ? -1 : answer;
    }
}


// a 도둑이 훔치면 info[i][0] 개의 흔적 >= n 이면 잡힘
// b 도둑이 훔치면 info[i][1] 개의 흔적 >= m 이면 잡힘

// 훔칠 때 생기는 흔적에 대한 정보를 담은 info
//class Solution {
//    int answer = Integer.MAX_VALUE; // 최소 A 흔적 수를 저장
//
//    public int solution(int[][] info, int n, int m) {
//        dfs(info, n, m, 0, 0, 0);
//        return (answer == Integer.MAX_VALUE) ? -1 : answer;
//    }
//
//
//    public void dfs(int[][] info, int n, int m, int index, int aSum, int bSum) {
//
//        if (aSum >= n || bSum >= m) return;
//        if (index == info.length) {
//            if (aSum < n && bSum < m) {
//                answer = Math.min(answer, aSum);
//            }
//            return;
//        }
//
//        dfs(info, n, m, index + 1, aSum + info[index][0], bSum);
//
//        dfs(info, n, m, index + 1, aSum, bSum + info[index][1]);
//    }
//}
