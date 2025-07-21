package week12.강성욱.programmers;

/**
 * PackageName : week12.강성욱.programmers
 * FileName    : 퍼즐_게임_챌린지
 * Author      : Baekgwa
 * Date        : 2025-07-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-21     Baekgwa               Initial creation
 */
public class 퍼즐_게임_챌린지 {
	class Solution {
		public int solution(int[] diffs, int[] times, long limit) {
			int left = 1;
			int right = 0;
			int mid = 0;
			int result = 0;

			for(int diff : diffs){
				right = Math.max(right, diff);
				result = right;
			}

			while(left <= right) {
				mid = left + (right - left) / 2;

				if(canSolve(diffs, times, limit, mid) == true) {
					right = mid - 1;
					result = mid;
				}
				else {
					left = mid + 1;
				}
			}

			return result;
		}

		private static boolean canSolve(int[] diffs, int[] times, long limit, int mid) {
			long totalTime = 0;
			int prevTime = 0;

			for (int i = 0; i < diffs.length; i++) {
				if (diffs[i] <= mid) {
					totalTime += times[i];
				} else {
					int mistakes = diffs[i] - mid;
					totalTime += (long) mistakes * (times[i] + prevTime) + times[i];
				}
				prevTime = times[i];

				if (totalTime > limit) {
					return false;
				}
			}

			return true;
		}
	}
}
