package week2.김누리.programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 이천십육년
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 05.     김누리               1차 풀이 완료
 */
public class 이천십육년 {
	public String solution(int a, int b) {
		String answer = "";
		LocalDate date = LocalDate.of(2016,a,b);
		DayOfWeek d = date.getDayOfWeek();

		answer = (d.toString()).substring(0,3);

		return answer;
	}
}
