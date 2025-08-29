package week18.강성욱.programmers;

import java.util.PriorityQueue;

/**
 * PackageName : week18.강성욱.programmers
 * FileName    : 명예의_전당_1
 * Author      : Baekgwa
 * Date        : 2025-08-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-29     Baekgwa               Initial creation
 */
public class 명예의_전당_1 {
	class Solution {
		public int[] solution(int k, int[] score) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int[] result = new int[score.length];

			for(int idx = 0; idx < score.length; idx++) {
				int nowScore = score[idx];
				pq.offer(nowScore);

				if(pq.size() > k) {
					pq.poll();
				}

				result[idx] = pq.peek();
			}

			return result;
		}
	}
}
