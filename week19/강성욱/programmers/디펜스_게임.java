package week19.강성욱.programmers;

import java.util.PriorityQueue;

/**
 * PackageName : week19.강성욱.programmers
 * FileName    : 디펜스_게임
 * Author      : Baekgwa
 * Date        : 2025-09-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-05     Baekgwa               Initial creation
 */
public class 디펜스_게임 {
	class Solution {
		public int solution(int n, int k, int[] enemy) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			int round = 0;
			for(int en : enemy) {
				pq.offer(en);
				if(pq.size() > k) {
					n -= pq.poll();
				}

				if(n < 0) {
					return round;
				}

				round++;
			}

			return enemy.length;
		}
	}
}
