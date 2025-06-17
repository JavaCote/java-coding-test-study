package week8.강성욱.programmers;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 유연근무제
 * Author      : Baekgwa
 * Date        : 2025-06-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-17     Baekgwa               Initial creation
 */
public class 유연근무제 {
	class Solution {
		public int solution(int[] schedules, int[][] timelogs, int startday) {

			// timeLogs, schedules 에서 확인해야될 인덱스 번호 (평일) 필터링
			int[] checkDays = new int[5];
			int nowDay = startday;
			int index = 0;
			for(int i=0; i<7; i++) {
				if(nowDay != 6 && nowDay != 7) {
					checkDays[index] = i;
					index++;
				}

				nowDay++;
				if(nowDay >= 8) nowDay = 1;
			}

			// 지각 체크.
			// 지각 아닌경우에 result 증가
			int result = 0;
			for (int person = 0; person < schedules.length; person++) {
				boolean isLate = false;
				int allowedHour = schedules[person] / 100;
				int allowedMin = schedules[person] % 100 + 10;

				if (allowedMin >= 60) {
					allowedHour += 1;
					allowedMin -= 60;
				}

				int allowedTime = allowedHour * 100 + allowedMin;

				for (int d = 0; d < 5; d++) {
					int logTime = timelogs[person][checkDays[d]];
					if (logTime > allowedTime) {
						isLate = true;
						break;
					}
				}

				if (!isLate) result++;
			}

			return result;
		}
	}
}
