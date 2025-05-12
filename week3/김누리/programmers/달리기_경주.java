package week3.김누리.programmers;

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
}
