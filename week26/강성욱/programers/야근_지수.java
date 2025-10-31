package week26.강성욱.programers;

import java.util.PriorityQueue;

/**
 * PackageName : week26.강성욱.programers
 * FileName    : 야근_지수
 * Author      : Baekgwa
 * Date        : 25. 10. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 10. 30.     Baekgwa               Initial creation
 */
public class 야근_지수 {
	// 그럼, 전반적으로 가장 높은게 없도록 낮춰야 하잖아?
	// n 만큼 - 를 하는데, 가장 큰걸 차감하면되잖아.
	// 그럼 PQ 로 해서, 정렬을 가장 큰순서대로 하고
	// n 만큼 뽑고, 빼고 하면?
	// n 은 50000 만큼.
	// 할만할듯?

	class Solution {
		public long solution(int n, int[] works) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

			for(int work : works) {
				pq.offer(work);
				// System.out.println(work + "넣음");
			}

			// 일처리
			for(int i=0; i<n; i++) {
				if(pq.isEmpty()) break;
				int now = pq.poll();
				if(now > 0) pq.offer(now - 1);
			}

			long result = 0;
			while(!pq.isEmpty()) {
				int now = pq.poll();
				result += (long) now * now;
			}

			return result;
		}
	}
}
