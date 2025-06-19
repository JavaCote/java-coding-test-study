/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 땅따먹기
 * Author      : sangeok
 * Date        : 2025. 6. 19.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 19.     sangeok               Initial creation
 */

// 문제 요구사항 :	게임 땅 => N 행 4열
//			1 행부터 한 행씩 내려올 때 각 행의 4칸중 한칸만 밣으면서 => 한 행씩 내려올 때 같은 열을 연속해서 x
//
//접근 방식 :		완전탐색 문제로 풀기엔 너무 경우의 수가 많아진다. -> 시간복잡도 터질 확률이 높아보임
//
//

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];

        for (int a = 0; a < 4; a++) {
            dp[0][a] = land[0][a];
        }

        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4 ; j++){
                for(int k = 0; k < 4; k++){
                    if( j == k ) continue;
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][k] + land[i][j]);
                }
            }
        }

        for(int i = 0; i < 4; i++){
            answer = Math.max(answer,dp[land.length-1][i]);
        }

        return answer;
    }
}