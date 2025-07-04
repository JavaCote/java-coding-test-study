package week5.김상진.programmers;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 카펫
 * Author      : sangxxjin
 * Date        : 2025. 5. 25.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 25.     sangxxjin               Initial creation
 */
public class 카펫 {
	// 테두리 1줄만 갈색
	class Solution {
		public int[] solution(int brown, int yellow) {
			int[] answer = new int[2];
			// 총 카펫 개수
			int total = brown + yellow;

			// 노란색을 감싸려면 가로 세로가 3 이상이어햠
			for (int height = 3; height <= total / height; height++) {
				// 나눈값이 맞아 떨어져야함. -> 직사각형
				if (total % height != 0) continue;

				int width = total / height;

				// 갈색은 노란색을 감싸는 가장 바깥 1줄이기 때문에 if 조건 성립
				if ((width - 2) * (height - 2) == yellow) {
					answer[0]=width;
					answer[1]=height;
					break;
				}
			}

			return answer;
		}
	}


}
