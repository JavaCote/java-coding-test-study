package week6_a.강성욱.programmers;

import java.util.Arrays;
import java.util.Collections;

/**
 * PackageName : week6_a.강성욱.programmers
 * FileName    : 공원
 * Author      : Baekgwa
 * Date        : 2025-06-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-06     Baekgwa               Initial creation
 */
public class 공원 {

	// 해결 아이디어
	// 돗자리를 내림차순으로 정렬 후, 브루트포스로 큰사이즈부터 전부 다 확인하면서, 앉기 가능? 검사
	// 단, out index 안되게 잘 체크해야됨.
	class Solution {
		public int solution(int[] mats, String[][] park) {
			int n = park.length;
			int m = park[0].length;

			Integer[] matsObj = Arrays.stream(mats).boxed().toArray(Integer[]::new);
			Arrays.sort(matsObj, Collections.reverseOrder());

			for (int i = 0; i < matsObj.length; i++) {
				int size = matsObj[i];

				for (int y = 0; y <= n - size; y++) {
					for (int x = 0; x <= m - size; x++) {
						if (possible(park, y, x, size)) {
							return size;
						}
					}
				}
			}
			return -1;
		}

		private boolean possible(String[][] park, int y, int x, int size) {
			for (int dy = 0; dy < size; dy++) {
				for (int dx = 0; dx < size; dx++) {
					if (!park[y + dy][x + dx].equals("-1")) {
						return false;
					}
				}
			}
			return true;
		}
	}
}