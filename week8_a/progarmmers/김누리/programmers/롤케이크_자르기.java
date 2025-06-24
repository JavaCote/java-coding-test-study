package week8_a.progarmmers.김누리.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week8_a.progarmmers.김누리.programmers
 * FileName    : 롤케이크_자르기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-24
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 24.     김누리(NRKim)               Initial creation
 */

/*
HashSet 이용.
HashSet cs
HashSet sis

cs에 1, 2 [1 2]
sis에 1, 3, 4, 2 [1 3 1 4 1 2]
-- 사이즈 달라서 NG

cs에 1 2 3 [1 2 1 3]
sis에 1 4 2[1 4 1 2]
-- 사이즈 같아서 Good > cnt++

cs에 1 2 3 [1 2 1 3 1]
sis에 4 1 2 [4 1 2]
-- 사이즈 같아서 Good > cnt++

*/

public class 롤케이크_자르기 {
	public int solution(int[] topping) {
		int answer = 0;
		Map<Integer,Integer> map = new HashMap<>(); //  여동생 배열
		Set<Integer> set = new HashSet<>();

		//  여동생한테 토핑 셋팅
		for(int i : topping) {
			map.put(i,map.getOrDefault(i,0)+1);
		}

		//  토핑 갯수
		int cnt = 0;

		//  여동생 토핑 >> 철수 토핑에 분배
		for (int i = 0; i < topping.length; i++) {
			set.add(topping[i]);

			cnt = map.get(topping[i]);

			if(cnt == 1) {
				map.remove(topping[i]);
			} else {
				map.put(topping[i],cnt-1);
			}

			if (set.size() == map.size()) answer++;
		}

		return answer;
	}
}
