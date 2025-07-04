package week7.김상진.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 할인_행사
 * Author      : sangxxjin
 * Date        : 2025. 6. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 12.     sangxxjin               Initial creation
 */
public class 할인_행사 {
	// 문제를 잘 읽어야 하는 문제.
	// 1. 하루에 1개씩만 구매 가능하므로, 정확히 10일 연속으로 원하는 품목과 수량이 일치해야 함
	// 2. number의 총합은 항상 10 → 검사 대상은 discount 배열 내 10일 연속 구간
	// 3. discount의 길이는 최대 100,000 → 전체를 순회하며 모든 구간 검사 필요
	//    → 각 구간마다 10개의 아이템만 검사하므로 O(N*10), 완전탐색 가능
	// 4. 품목 이름과 수량이 주어지므로 Map<String, Integer> 사용 적합
	// 5. 10일 구간마다 Map을 구성하여 기준 Map과 비교 → 슬라이딩 윈도우 방식
	import java.util.*;

	class Solution {
		public int solution(String[] want, int[] number, String[] discount) {
			int answer = 0;

			Map<String, Integer> wantMap = new HashMap<>();
			for (int i = 0; i < want.length; i++) {
				wantMap.put(want[i], number[i]);
			}

			for (int i = 0; i <= discount.length - 10; i++) {
				Map<String, Integer> windowMap = new HashMap<>();
				for (int j = i; j < i + 10; j++) {
					String item = discount[j];
					windowMap.put(item, windowMap.getOrDefault(item, 0) + 1);
				}

				boolean match = true;
				for (String key : wantMap.keySet()) {
					if (windowMap.getOrDefault(key, 0) != wantMap.get(key)) {
						match = false;
						break;
					}
				}

				if (match) {
					answer++;
				}
			}

			return answer;
		}
	}

}
