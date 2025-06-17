package week8.김누리.programmers;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 유연근무제
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 17.     김누리(NRKim)               Initial creation
 */

/*
startday = 근무 시작일
1 월
2 화
3 수
4 목
5 금
6 토
7 일

int[] schedules = 각 인원들의 출근 희망 일
int[][] timelogs = 실제 출근 시각

반복 조건
평일일 것
실제 출근 시간 이 희망 출근 시간 보다 이를 때
실제 출근 시간 이 희망 출근 시간 + 10 이내일 때

이 때 주의할 것
int hopeMin = (s / 100) * 60 + (s % 100); // 희망 출근 시간 → 분 변환
int logMin = (timestamp[i] / 100) * 60 + (timestamp[i] % 100); // 실제 출근 시간

*/

public class 유연근무제 {
	public int solution(int[] schedules, int[][] timelogs, int startday) {
		int answer = schedules.length; // 7일부터 시작

		for(int i = 0; i < schedules.length; i++) {
			for(int j = 0; j < 7; j++) {
				int day = (startday + j) % 7;

				//  평일 중 실제 출근 시간이 희망 출근 시간이 이르거나, 희망 출근 시간 + 10분 이내일 때
				if(day > 0 && day < 6
					&& 60 * (timelogs[i][j] / 100) + timelogs[i][j] % 100 > 60 * (schedules[i] / 100) + (schedules[i] % 100 + 10)
				) {
					answer--;
					break;
				}
			}
		}

		return answer;
	}
}
