package week16.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week16.김누리.programmers
 * FileName    : 의상
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-11
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 11.     김누리(NRKim)               Initial creation
 */

/*

clothes[i][1] : 의상 종류 기준으로 map 셋팅

case 1 기준

map = {headgear = 2, eyewear = 1}

headgear 1 (노란 모자)
headgear 1 (초록 터번)
eyewear 1 (파란 선글라스)
headgear 1 + eyewear 1
headgear 1 + eyewear 1


*/

public class 의상 {
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String,Integer> map = new HashMap<>();

		//  의상 종류 별 갯수 확인
		for(String[] c : clothes) {
			map.put(c[1],map.getOrDefault(c[1],0)+1);
		}

		//  의상 조합
		for(String c : map.keySet()) {
			answer *= (map.get(c)+1);

		}

		//  아무것도 안입는 경우
		answer -= 1;

		return answer;
	}
}
