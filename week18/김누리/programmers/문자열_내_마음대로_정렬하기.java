package week18.김누리.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week18.김누리.programmers
 * FileName    : 문자열_내_마음대로_정렬하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 25.     김누리(NRKim)               Initial creation
 */

public class 문자열_내_마음대로_정렬하기 {

	//  Lambda식 이용 안함
	/*public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		Set<String> hs = new HashSet<String>();

		for(String s : strings) {
			hs.add(s.charAt(n) + s);
		}

		List<String> tmp = new ArrayList<String>(hs);

		Collections.sort(tmp);

		for(int i = 0; i < tmp.size(); i++) {
			String s = tmp.get(i);

			answer[i] = s.substring(1);
		}

		return answer;

	}*/

	//  Lambda 식 풀이
	public String[] solution(String[] strings, int n) {
		Arrays.sort(
			strings, Comparator
				.comparing((String s) -> s.charAt(n))
				.thenComparing(s -> s)
		);

		return strings;
	}
}
