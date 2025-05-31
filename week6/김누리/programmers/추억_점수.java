package week6.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 추억_점수
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-31
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 31.     김누리(NRKim)               Initial creation
 */

/*
해시 맵 이용
    1.  Map<String, Integer> map = new HashMap<>();
    2.  map의 key = name[i], value = yearning[i]
    3.  photo 배열 순회하면서 getOrDefault() 함수 통해서 점수 계산
    4.  answer의 배열은 photo의 사이즈 만큼
*/

public class 추억_점수 {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		Map<String,Integer> map = new HashMap<>();

		//  map 초기화
		for(int i = 0; i < name.length; i++) {
			map.put(name[i],yearning[i]);
		}

		//  idx 채번용 변수
		int idx = 0;

		for(String[] p : photo) {
			int sum = 0;

			for(String n : p) {
				//  사진에 인원이있는 경우에만 점수 취득
				if (map.containsKey(n)) {
					sum += map.get(n);
				}
			}

			answer[idx++] = sum;
		}

		return answer;
	}
}
