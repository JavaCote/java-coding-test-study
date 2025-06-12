package week7.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : 할인_행사
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-12
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 12.     김누리(NRKim)               Initial creation
 */


/*
want =   ["banana", "apple", "rice", "pork", "pot"]
number = [3, 2, 2, 2, 1]

map = {banana = 3, apple = 2, rice = 2, pork = 2, port = 1}

discount = ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]

1일차 = "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice" >>
        chicken = 1, apple = 3, banana = 2, rice = 2, pork = 2 >> banana 1개 부족, port 못삼

2일차 = "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot"
        apple = 3 banana = 2 rice = 2 pork =2 pot = 1 >> banana 1개 부족

3일차 = "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana"
        apple = 2, banana = 3, rice = 2, pork = 2, pot = 1

그러므로 3일차에 가입 해야 함.

그러면..

맵 2개 쓰면 좋지 않을까?
효찬이가 원하는 map
예 ) map = {banana = 3, apple = 2, rice = 2, pork = 2, pot = 1}

idx = 부터 10개 취득하며 map 구성
예 )
1일차
map2 = {"chicken" = 1, "apple" = 3, "banana" = 2, "rice" = 2, "pork" = 2}

그리고 map.getKeys(chicken) == map2.getKeys(chicken) ? tmp++ : tmp = 0, days++;

if(tmp != 0) return answer

*/

public class 할인_행사 {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String,Integer> map = new HashMap<>(); // 효찬이가 원하는 물품 map

		//  원하는 물자 맵 초기화
		for(int i = 0; i < number.length; i++) {
			map.put(want[i],number[i]);
		}


		//  할인 물품을 탐색하며, 비교 작업 진행
		for(int i = 0; i < discount.length - 9; i++) {
			Map<String,Integer>map2 = new HashMap<>();

			// 현재 위치에서 부터 10개 취득
			for(int j = i; j < i + 10; j++) {
				//
				String tmp = discount[j]; // 할인 대상 물품
				map2.put(tmp, map2.getOrDefault(tmp,0)+1);
			}

			boolean same = true;

			// map2에 원하는 물품 갯수랑 map에 있는 물품 갯수 비교. 만약 동일하지 않으면 다시 반복문으로 돌아가 진행
			for(String w : want) {
				if(map2.getOrDefault(w,0) != map.get(w)) {
					same = false;
					break;
				}
			}

			if(same) answer++;
		}

		return answer;
	}
}
