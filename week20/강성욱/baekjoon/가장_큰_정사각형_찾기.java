package week20.강성욱.baekjoon;

/**
 * PackageName : week20.강성욱.baekjoon
 * FileName    : 가장_큰_정사각형_찾기
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */
public class 가장_큰_정사각형_찾기 {
	// class Solution {
	//     public int solution(int[][] board) {
	//         int n = board.length;
	//         int m = board[0].length;
	//         int maxSide = 0;

	//         for (int y = 0; y < n; y++) {
	//             for (int x = 0; x < m; x++) {
	//                 if (board[y][x] == 0) continue;
	//                 int maxPossible = Math.min(n - y, m - x);
	//                 for (int s = 1; s <= maxPossible; s++) {
	//                     if (validate(board, y, x, s)) {
	//                         if (s > maxSide) maxSide = s;
	//                     } else {
	//                         break;
	//                     }
	//                 }
	//             }
	//         }
	//         return maxSide * maxSide;
	//     }

	//     private boolean validate(int[][] b, int y, int x, int s) {
	//         int yEnd = y + s;
	//         int xEnd = x + s;
	//         for (int i = y; i < yEnd; i++) {
	//             for (int j = x; j < xEnd; j++) {
	//                 if (b[i][j] == 0) return false;
	//             }
	//         }
	//         return true;
	//     }
	// }

	class Solution {
		public int solution(int[][] board) {
			int my = board.length;
			int mx = board[0].length;
			int[][] dp = new int[my][mx]; //dp 배열은 [y][x] 좌표를 정사각형 우측 하단 지점으로 잡았을 경우, 가장 크게 만들 수 있는 정사각형의 한 변의 길이

			int result = 0;

			// 가로 세로 초기화
			for(int y = 0; y<my; y++) {
				dp[y][0] = board[y][0];
				//여기에 초기화 넣어야함
				result = Math.max(dp[y][0], result);
			}
			for(int x = 0; x<mx; x++) {
				dp[0][x] = board[0][x];
				result = Math.max(dp[0][x], result);
			}

			for(int y=1; y<my; y++) {
				for(int x=1; x<mx; x++) {
					if(board[y][x] == 0) continue;
					dp[y][x] = Math.min(Math.min(dp[y-1][x], dp[y][x-1]), dp[y-1][x-1]) + 1;
					result = Math.max(result, dp[y][x]);
				}
			}

			return result * result;
		}
	}
}
