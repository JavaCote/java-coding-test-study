package week2.김상진.programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 문제_2016
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 문제_2016 {
	class Solution {
		public String solution(int a, int b) {
			LocalDate date = LocalDate.of(2016, a, b);
			DayOfWeek dayOfWeek = date.getDayOfWeek();
			return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
		}
	}
}
