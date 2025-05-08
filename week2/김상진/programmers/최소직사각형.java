package week2.김상진.programmers;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 최소직사각형
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 최소직사각형 {
	class Solution {
		public int solution(int[][] sizes) {
			int maxWidth = 0;
			int maxHeight = 0;

			for (int[] size : sizes) {
				int width = Math.max(size[0], size[1]);
				int height = Math.min(size[0], size[1]);

				maxWidth = Math.max(maxWidth, width);
				maxHeight = Math.max(maxHeight, height);
			}

			return maxWidth * maxHeight;
		}
	}

}
