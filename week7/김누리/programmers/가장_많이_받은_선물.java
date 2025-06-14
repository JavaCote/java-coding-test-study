package week7.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : 가장_많이_받은_선물
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-11
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 11.     김누리(NRKim)               Initial creation
 */

/*
친구 = ["muzi", "ryan", "frodo", "neo"]
선물 = ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]


        muzi    ryan    frodo    neo
muzi     -        0       2       0
ryan     3        -       0       0
frodo    1        1       -       0
neo      1        0       0       -

위와 같이 그래프 구성

선물 주고 받는 기록 정리

※  답지를 보고 풀이함. 다시 풀어볼 필요 있음
*/

public class 가장_많이_받은_선물 {
	public int solution(String[] friends, String[] gifts) {
		int answer = 0;
		Map<String, Integer> friendMap = new HashMap<>();

		//  친구 맵 초기화
		for(int i = 0; i < friends.length;i++) {
			friendMap.put(friends[i],i);
		}

		int[] present = new int[friends.length]; // 선물지수용 배열
		int[][] fromTo = new int[friends.length][friends.length];//  예시와 같이, 그래프 생성을 위한 2차원 배열

		for(String gift : gifts) {
			String[] g = gift.split(" "); // muzi frodo 형태로 된 from to 문을 space 기준으로 나눔
			present[friendMap.get(g[0])]++; // from ++
			present[friendMap.get(g[1])]--; // to 쪽에 --

			//  n*n 그래프 구성
			fromTo[friendMap.get(g[0])][friendMap.get(g[1])]++;
		}

		for (int i = 0; i < friends.length; i++) {
			int n = 0;

			for (int j = 0; j < friends.length; j++) {
				if (i == j) continue;

				//  선물을 준 횟수 > 받은횟수 or 선물 주고받은 횟수는 같지만, 선물 지수에 차이가 있는 경우
				if(fromTo[i][j] > fromTo[j][i] ||
					(fromTo[i][j] == fromTo[j][i] && present[i] > present[j])
				) n++;

				if(answer < n) answer = n;
			}
		}

		return answer;
	}
}
