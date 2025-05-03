package week2.김누리.programmers;

import java.util.*;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 완주하지_못한_선수
 * Author      : 김누리
 * Date        : 2025-05-03
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 03.     김누리               Initial creation
 * 2025. 05. 03.     김누리               HashMap을 이용한 버전 풀이
 */
public class 완주하지_못한_선수 {
	//  HashMap 이용 버전
/*	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String,Integer> map = new HashMap<>();

		//  map에 참여자 정보 ++
		for (String participants : participant) {
			map.put(participants,map.getOrDefault(participants,0)+1);
		}

		//  map에서 완주자 정보 --
		for (String completions : completion) {
			map.put(completions,map.getOrDefault(completions,0)-1);
		}

		//  map에 0이 아닌 값을 answer로 제출
		for (String participants : participant) {
			if (map.get(participants) != 0) answer = participants;
		}

		return answer;
	}*/
}
