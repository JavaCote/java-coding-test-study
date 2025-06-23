/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 유연근무제
 * Author      : sangeok
 * Date        : 2025. 6. 16.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 16.     sangeok               Initial creation
 */

// 문제 요구사항 : 	출근 희망 시각 + 10 까지 어플로 출근	 ( 희망 시각 9:58 => 10:8 까지 )
//			토,일요일의 출근 시각은 이벤트에 영향 x
//			모든 시각은 시에 x 100 더한 정수 10:13 => 1013
//			직원 n 명의 출근 희망 시각 : schedules //
//			일주일 동안 출근한 시각 : timelogs // 이벤트 시작 요일 startday
//			1 : 월 ~ 7 : 일
//
// 접근 방식 : (1) 그냥 for 문 ?
//		1) schedules에 10 더하고 그 다음 timelogs 도 그냥 돌면 되겠는데
//			그 안에서 startday n % 7 + 1 로 요일 돌리고

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {

            int maxtime = ((schedules[i] / 100) * 60) + ((schedules[i] % 100) + 10);
            int correctcount = 0;
            int currentDay = startday;

            for (int j = 0; j < timelogs[i].length; j++) {

                int log = ((timelogs[i][j] / 100) * 60) + (timelogs[i][j] % 100);
                if (log > maxtime && currentDay != 6 && currentDay != 7) correctcount--;
                currentDay = (currentDay % 7) + 1;

            }
            if (correctcount == 0) answer++;
        }
        return answer;
    }
}
