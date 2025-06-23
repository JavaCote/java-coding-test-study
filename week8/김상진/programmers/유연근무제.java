package week8.김상진.programmers;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 유연근무제
 * Author      : sangxxjin
 * Date        : 2025. 6. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 16.     sangxxjin               Initial creation
 */
public class 유연근무제 {
	// 시간은 모두 분단위로 변경
	// 토,일 계산 x

	class Solution {
		public int solution(int[] schedules, int[][] timelogs, int startday) {
			int answer = 0;
			for (int i = 0; i < timelogs.length; i++) {
				int limitTime = (schedules[i] / 100) * 60 + (schedules[i] % 100) + 10;
				int successCount = 0;
				for (int j = 0; j < 7; j++) {
					//요일계산
					int date = (startday + j - 1) % 7 + 1;
					if (date == 6 || date == 7) continue;

					int time = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);

					if (time > limitTime) {
						successCount = -1;
						break;
					}
					successCount++;
				}

				if (successCount == 5) answer++;
			}

			return answer;
		}
	}

}
