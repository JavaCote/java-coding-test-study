package week3.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week3.김누리.programmers
 * FileName    : 달리기_경주
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-12
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 12.     김누리(NRKim)               Initial creation
 * 2025. 05. 12.     김누리(NRKim)               1차 풀이 실패. 사유 :
 *                                               로직에는 NG 없음. 그러나 players 배열을 순회하면서 2중 for문
 *                                               을 이용하다보니, 시간 복잡도가 늘어나 시간초과가 발생하여
 *                                               NG 케이스가 되어버림
 *
 * 2025. 05. 12.     김누리(NRKim)               2차 풀이 성공. 바뀐 내용 :
 *                                               2중 for문이 아니라, hash map을 이용
 *                                               호명된 선수의 idx를 가지고 앞번 선수 구하고 이를 통해
 *                                               players 배열의 idx랑 map의 인덱스값을 갱신하는 방식으로 
 *                                               문제풀이 방식 변경
 */

/*
case 1 :
  callings ["kai", "kai", "mine", "mine"]
  players ["mumu", "soe", "poe", "kai", "mine"]

  step 1 : callings[0] kai
           players ["mumu", "soe", "kai", "poe", "mine"]

  step 2 : callings[1] kai
           players ["mumu", "kai", "soe", "poe", "mine"]

  step 3 : callings[2] mine
           players ["mumu", "kai", "soe", "mine", "poe"]

  step 4 : callings[0] kai
           players ["mumu", "kai", "mine", "soe", "poe"]

  result : ["mumu", "kai", "mine", "soe", "poe"]
*/

public class 달리기_경주 {
	//  실패 사유 2중for문 사용
/*	public String[] solution(String[] players, String[] callings) {
		String[] answer = new String [players.length];

		//  선수 호명
		for(String calling : callings) {

			//  player 배열 순회하며 호명된 선수 찾기,
			for(int i = 0; i < players.length; i++) {
				//  로테이션용 임시 변수
				String tmp = "";

				//  players 배열에서 호명 된 선수 발견
				if(players[i].equals(calling)) {
					tmp = players[i-1];  //  호명된 선수 바로 앞에 있는 사람을 tmp로
					players[i-1] = players[i]; // 호명된 선수와 바로 앞에 있던 사람의 순번 변경
					players[i] = tmp;
				}
			}
		}

		int idx = 0;

		for(String player : players) {
			answer[idx++] = player;
		}

		return answer;
	}*/

	//  HashMap 이용
	public String[] solution(String[] players, String[] callings) {
		String[] answer = new String [players.length];
		Map<String,Integer> map = new HashMap<>();

		// 선수들 셋팅
		for(int i = 0; i < players.length; i++) {
			map.put(players[i],i);
		}

		//  선수 호명
		for(String calling : callings) {
			//  선수 위치 확인
			int idx = map.get(calling);

			//  호명된 선수 앞에 있는 선수 확인
			String frontPlayer = players[idx-1];

			//  player 테이블에서 idx 동기화
			players[idx - 1] = calling;
			players[idx] = frontPlayer;

			//  map에서 idx 동기화
			map.put(calling,idx-1);
			map.put(frontPlayer,idx);
		}

		for(int i = 0; i < players.length; i++) {
			answer[i] = players[i];
		}

		return answer;
	}

}
