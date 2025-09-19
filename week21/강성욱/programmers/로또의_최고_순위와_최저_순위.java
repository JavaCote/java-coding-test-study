package week21.강성욱.programmers;

/**
 * PackageName : week21.강성욱.programmers
 * FileName    : 로또의_최고_순위와_최저_순위
 * Author      : Baekgwa
 * Date        : 2025-09-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-19     Baekgwa               Initial creation
 */
public class 로또의_최고_순위와_최저_순위 {
	class Solution {

		private static final int[] result = new int[]{6, 6, 5, 4, 3, 2, 1}; //index 개 맞췄을때의 등수

		public int[] solution(int[] lottos, int[] win_nums) {
			//못알아본 숫자 수량
			int blankCnt = 0;
			for(int lotto : lottos) {
				if(lotto == 0) blankCnt++;
			}

			//현재 기본 개수 확인
			int badCnt = 0;
			for(int i = 0; i < lottos.length; i++) {
				for(int j=0; j<win_nums.length; j++) {
					if(lottos[i] == win_nums[j]) {
						badCnt++;
					}
				}
			}

			int goodCnt = badCnt + blankCnt;

			return new int[]{result[goodCnt], result[badCnt]};
		}
	}
}
