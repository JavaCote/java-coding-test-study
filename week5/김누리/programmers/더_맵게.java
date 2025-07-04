package week5.김누리.programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 더_맵게
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-27
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 27.     김누리(NRKim)               Initial creation
 */

/*
  섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

  1.  스코빌 큐(우선순위 큐로) 생성.
  2.  큐.peek() < k?
    2-1.  (yes) a = 큐.poll(); // 1  b = 큐.poll(); // 2
    2-2.  큐.offer(a+(b*2));
  3.  큐.peek() >= k?
    3-1.  반복 종료
*/

public class 더_맵게 {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		Queue<Integer> que = new PriorityQueue<>();

		for(int s : scoville) {
			que.offer(s);
		}

		while(que.peek() < K) {
			if(que.size() == 1) return -1;

			int a = que.poll();
			int b = que.poll();
			int scov = a + (b*2);
			que.offer(scov);
			answer++;
		}

		return answer;
	}
}
