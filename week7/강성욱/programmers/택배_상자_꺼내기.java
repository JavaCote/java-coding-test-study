package week7.강성욱.programmers;

/**
 * PackageName : week7.강성욱.programmers
 * FileName    : 택배_상자_꺼내기
 * Author      : Baekgwa
 * Date        : 2025-06-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-11     Baekgwa               Initial creation
 */
public class 택배_상자_꺼내기 {
	//박스를 다 쌓아두고, 진행하면? 즉, map 을 만들어주는거지
	//그럼 특정 y축 인덱스 위치를 특정할 수 있나? 계산으로?
	//생각보다 어려워보임. 차라리 쌓을때부터, 특정 인덱스 위치를 알고있는게 나을듯
	//그럼 쌓으면서, 특정 인덱스에 몇개가 쌓이는지도 확인을 하면 굳이 확인을 계속할 필요도?
	//일딴 쌓아보자

	class Solution {
		public int solution(int n, int w, int num) {
			int h = (n + w - 1) / w;
			int[][] map = new int[h][w];
			int cur = 1;

			int targetRow = -1, targetCol = -1;

			for (int i = 0; i < h; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < w && cur <= n; j++) {
						map[i][j] = cur;
						if (cur == num) {
							targetRow = i;
							targetCol = j;
						}
						cur++;
					}
				} else {
					for (int j = w - 1; j >= 0 && cur <= n; j--) {
						map[i][j] = cur;
						if (cur == num) {
							targetRow = i;
							targetCol = j;
						}
						cur++;
					}
				}
			}

			int count = 0;
			for (int i = targetRow; i < h; i++) {
				if (map[i][targetCol] != 0) count++;
			}

			return count;
		}
	}
}
