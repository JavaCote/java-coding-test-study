package week18.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week18.강성욱.programmers
 * FileName    : 문자열_내_마음대로_정렬하기
 * Author      : Baekgwa
 * Date        : 2025-08-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-29     Baekgwa               Initial creation
 */
public class 문자열_내_마음대로_정렬하기 {

	class Solution {
		public String[] solution(String[] strings, int n) {
			Arrays.sort(strings, (a, b) -> {
				char c1 = a.charAt(n);
				char c2 = b.charAt(n);

				if(c1 == c2) {
					return a.compareTo(b);
				}

				return Character.compare(c1, c2);
			});

			return strings;
		}
	}
}
