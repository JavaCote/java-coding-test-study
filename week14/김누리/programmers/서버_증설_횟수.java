package week14.김누리.programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : 서버_증설_횟수
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-30
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 30.     김누리(NRKim)               Initial creation
 */

public class 서버_증설_횟수 {
	public int solution(int[] players, int m, int k) {
		//  증설 서버 관리
		Queue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);

		//  증설된 서버 수
		int size = 0;

		//  증설 횟수
		int cnt = 0;


		// 24시간 동안 반복
		for(int i = 0; i < players.length; i++) {

			//  증설 종료 시간이 현재 시간과 같으면 큐 poll();
			while(!q.isEmpty() && q.peek()[0] == i) {
				size -= q.poll()[1];
			}

			//  증설 필요 조건 = (n+1) * m
			int need = players[i]/m;

			//  현재 증설된 서버 - 필요 서버 ==> 추가 증설해야 하는 서버
			int more = size - need;

			//  증설할 필요 없을 경우
			if (more < 0) {
				more =- more;
				size += more;
				cnt += more;
				q.add(new int[] {i+k, more});
			}
		}

		return cnt;
	}
}
