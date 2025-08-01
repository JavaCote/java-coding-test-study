package week14.강성욱.programmers;

/**
 * PackageName : week14.강성욱.programmers
 * FileName    : 삼각달팽이
 * Author      : Baekgwa
 * Date        : 2025-07-28
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-28     Baekgwa               Initial creation
 */
public class 삼각달팽이 {
	//처음 시작할때, n만큼 채우고
	//n-1 만큼 넣고 .... 1만큼 채워 넣고 끝임.
	//이번 반복이 n 일때는, 왼쪽 대각 아래로. (array[y][x] 에서 y만 ++)
	//이번 반복이 n-1 일때는, 오른쪽으로. (array[y][x] 에서, x++)
	//이번 반복이 n-2 일때는, 왼쪽 대각 위로. (array[y][x] 에서, x--, y--)
	//아 n-1 이 아니라, %로 계산해야되네.
	// n%3 == 0, 이런식
	// 는 이렇게 하면 안됨. 3방향을 돌아가면서 해야하고, 맨첨에는 왼쪽아래부터 가야함.
	//하면서 좌표 넣으면 될듯?
	//사이즈는 몇짜리 2차원 배열로 해야하나? 는 n곱하기 n으로 하면 되겟네

	class Solution {
		public int[] solution(int n) {
			int[][] map = new int[n+1][n+1];
			int x = 0, y = -1;
			int nowStep = n;
			int cnt = 1;
			int dir = 0;
			while(nowStep != 0) {
				for(int i=0; i<nowStep; i++) {
					if(dir % 3 == 0) y++;
					else if(dir % 3 == 1) x++;
					else if(dir % 3 == 2) {
						y--;
						x--;
					}
					map[y][x] = cnt++;
				}
				nowStep--;
				dir++;
			}

			// for (int i = 0; i <= n; i++) {
			//     for (int j = 0; j <= n; j++) {
			//         System.out.printf("%2d ", map[i][j]);
			//     }
			//     System.out.println();
			// }

			// 출력
			int[] result = new int[cnt-1];
			int index = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 0) continue;
					result[index++] = map[i][j];
				}
			}

			return result;
		}
	}
}
