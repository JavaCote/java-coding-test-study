package week20.김누리.programmers;

/**
 * PackageName : week20.김누리.programmers
 * FileName    : 가장_큰_정사각형_찾기
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 06.     김누리(NRKim)               Initial creation
 */

/*

dp 채택하면 될듯,
1 = 1*1의 정사각형, 0 빈칸

n = 높이, m = 가로

dp[n][m] 돌리며 가장 큰 정사각형의 한 변을 구한 뒤

제곱 해서(정사각형의 넓이니) 반환 하면 될 듯

*/

public class 가장_큰_정사각형_찾기 {
	public int solution(int [][]board)
	{
		int n = board.length;
		int m = board[0].length;
		int answer = 0;
		int[][] dp = new int[n][m];

		//  첫번째 행/ 열은 cp -p
		for(int i = 0; i < n; i++) {
			dp[i][0] = board[i][0];

			if(dp[i][0] > answer) answer = dp[i][0];
		}

		for(int i = 0; i < m; i++) {
			dp[0][i] = board[0][i];

			if(dp[0][i] > answer) answer = dp[0][i];
		}

		//  dp 알고리즘 처리
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				if(board[i][j] == 1) {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));

					if(dp[i][j] > answer) answer = dp[i][j]; //  정사각형의 한 선의 길이
				} else {
					dp[i][j] = 0;
				}
			}
		}

		//  dp 알고리즘에서 한 변의 길이만 구한 것이기 때문에 반환시 제곱을 해야 함.
		return answer*answer;
	}
}
