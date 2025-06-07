package week6_a.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week6_a.김상진.programmers
 * FileName    : 공원
 * Author      : sangxxjin
 * Date        : 2025. 6. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 7.     sangxxjin               Initial creation
 */
public class 공원 {
	// mats기준으로 큰것부터 대조.
	// 시작지점 -> (height-mat)까지 검사. (width-mat)까지
	// 각시작점으로부터 오른쪽 아래로 이동하면서 알파벳 만나면 return false.
	// 처음에는 bfs처럼 배열 선언하여 오른쪽, 아래, 한번씩 번갈아가면서 조회하려 했지만 결국 모든 돗자리 범위를
	// 확인하기 때문에 오른쪽으로 검사하게 구현
	import java.util.*;
	class Solution {
		public int solution(int[] mats, String[][] park) {
			Arrays.sort(mats); // 오름차순 정렬 후 역순 순회
			for (int i = mats.length - 1; i >= 0; i--) {
				int matSize = mats[i];
				for (int row = 0; row <= park.length - matSize; row++) {
					for (int col = 0; col <= park[0].length - matSize; col++) {
						if (isCorrect(row, col, park, matSize)) {
							return matSize;
						}
					}
				}
			}
			return -1;
		}
		// -1이 아닌 알파벳이면 해당 자리는 깔수 없는 자리로 판단하고 바로 return false
		private boolean isCorrect(int x, int y, String[][] park, int size) {
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					if (!park[i][j].equals("-1")) {
						return false;
					}
				}
			}
			return true;
		}
	}

}
