package week5.김누리.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 귤_고르기
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-27
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 27.     김누리(NRKim)               Initial creation
 */

/*

Case 1 :
입력 값 : [1, 3, 2, 5, 4, 5, 2, 3]
K : 6 >> 8개 중 6개만 pick
정렬 :  [1, 2, 2, 3, 3, 4, 5, 5]
22 33 55

Case 2 :
입력 값 : [1, 3, 2, 5, 4, 5, 2, 3]
K : 4 >> 8개 중 4개만 pick
정렬 :  [1, 2, 2, 3, 3, 4, 5, 5]
22 33
22 55
33 55

Case 3 :
입력 값 : [1, 1, 1, 1, 2, 2, 2, 3]
K : 2 >> 8개 중 2개만 pick
정렬 :  [1, 1, 1, 1, 2, 2, 2, 3]
11
22

*/

public class 귤_고르기 {
	public int solution(int k, int[] tangerine) {
		int answer = 0;

		// 귤의 사이즈 별로 갯수 정리
		Map<Integer,Integer> map = new HashMap<>();

		for(int t : tangerine) {
			map.put(t,map.getOrDefault(t,0)+1);
		}

		//  귤의 갯수를 다시 리스트화
		List<Integer> l = new ArrayList<>(map.values());
		l.sort(Comparator.reverseOrder());

		int sum = 0;

		//  귤의 갯수를 더해가며, sum 의 값이 k 이상이 되는경우 반복 종료
		for(int i : l) {
			sum += i;
			answer++;
			if (sum >= k) break;
		}

		return answer;
	}
}
