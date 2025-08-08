package week15.김누리.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * PackageName : week15.김누리.programmers
 * FileName    : 보석_쇼핑
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-03
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 03.     김누리(NRKim)               Initial creation
 */

/*
보석의 종류를 map에 저장해서 보석 종류의 구매 갯수 체크

left = 0, right = 0으로 선언 후, right가 일단 모든 보석들을 포함할 때 까지 이동

이후 left를 조정해 가며 map에 보석들이 다 포함 되는지 체크


map을 이용하며 카운팅 하는건 이해했지만 구체적인 방식이 잘 안떠오름.

left, right 변수 선언.

while문 돌리며 right 위치 조정하면 되는것 까지는 이해함.

그러나 while 조건문 이후에 인공지능 도움을 받다보니, 소스 완성이 안되었었음


*/

public class 보석_쇼핑 {
	public int[] solution(String[] gems) {
		Map<String,Integer> map = new HashMap<>();
		int kind = new HashSet<>(Arrays.asList(gems)).size();

		int left = 0, right = 0; //  시작 및 끝 점 위치
		map.put(gems[0],1); //  시작 위치의 보석 담기

		int[] answer = {1,gems.length};

		while(right < gems.length) {
			if (map.size() == kind) {
				//  시작점 - 끝점의 보석 갯수 비교
				if (answer[1] - answer[0] > right - left) {
					answer[0] = left + 1;
					answer[1] = right + 1;
				}

				//  left--
				map.put(gems[left],map.get(gems[left])-1);
				if(map.get(gems[left]) == 0) map.remove(gems[left]);
				left++;

			} else {
				right++;
				if(right < gems.length) {
					map.put(gems[right], map.getOrDefault(gems[right], 0) +1);
				}
			}
		}

		return answer;
	}
}
