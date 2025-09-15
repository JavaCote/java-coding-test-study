/**
 * PackageName : week20.이상억.progarmmers;
 * FileName    : 가장_큰_정사각형_찾기
 * Author      : sangeok
 * Date        : 2025. 09. 11.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 11.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int n = board.length;       // 행
        int m = board[0].length;    // 열

        int[][] dp = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // 첫 행/열은 그대로 1
                    } else {
                        int up = dp[i - 1][j];
                        int left = dp[i][j - 1];
                        int cross = dp[i - 1][j - 1];
                        int minValue = Math.min(up, Math.min(left, cross));
                        dp[i][j] = minValue + 1;
                    }
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
}
