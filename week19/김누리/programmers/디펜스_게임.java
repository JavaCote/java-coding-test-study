package week19.김누리.programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PackageName : week19.김누리.programmers
 * FileName    : 디펜스_게임
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-31
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 31.     김누리(NRKim)               Initial creation
 */

public class 디펜스_게임 {
	public int solution(int n, int k, int[] enemy) {
		//  적 병력 수 별로 desc
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int sum = 0;

		for(int i = 0; i < enemy.length; i++) {
			sum += enemy[i];
			q.offer(enemy[i]);

			//  원소값 총합이 내 병력보다 많을 경우
			if(sum > n) {
				if(k > 0) {
					sum -= q.poll();
					k--;
				} else {
					return i;
				}
			}
		}


		return enemy.length;
	}
}
