package week11.김누리.programmers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week11.김누리.programmers
 * FileName    : 개인정보_수집_유효기간
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 06.     김누리(NRKim)               Initial creation
 */

/*

start = privaceis[0]
end = privacies[0] + map.getOrDefault(terms[0],0);

start <= today < end ==> 아직 보관

today >= end ==> 삭제 대상

*/


public class 개인정보_수집_유효기간 {
	public int[] solution(String today, String[] terms, String[] privacies) {
		Map<String,String> map = new HashMap<>();

		//  terms map화
		for(String t : terms) {
			String[] tmp = t.split(" ");
			map.put(tmp[0],tmp[1]);
		}

		int day = 1;
		List<Integer> list = new ArrayList<>();


		//  유효기간 체크
		for(String p : privacies) {
			String[] tmp = p.split(" ");
			int t = Integer.parseInt(map.getOrDefault(tmp[1],"0"));

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

			LocalDate start = LocalDate.parse(tmp[0],formatter);
			LocalDate target = LocalDate.parse(today,formatter);
			LocalDate end = start.plusMonths(t);


			if (target.isAfter(end) || target.isEqual(end)) {
				list.add(day);
			}

			day++;
		}

		int[] answer = new int[list.size()];

		int idx = 0;

		//  정답 구성
		for(int i : list) {
			answer[idx++] = i;
		}


		return answer;
	}
}
