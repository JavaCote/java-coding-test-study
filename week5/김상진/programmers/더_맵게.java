package week5.김상진.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 더_맵게
 * Author      : sangxxjin
 * Date        : 2025. 5. 26.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 26.     sangxxjin               Initial creation
 */
public class 더_맵게 {
	// 첫 번째 방식은 List를 사용해 매번 정렬했기 때문에 시간초과 발생
	// Collections.sort()는 O(N log N)이므로, 매 반복마다 정렬하면 비효율적임
	// 두 번째 방식은 PriorityQueue(우선순위 큐)를 사용해 가장 작은 두 값을 빠르게 꺼냄
	// PriorityQueue는 내부적으로 배열 기반의 "이진 최소 힙(min-heap)" 구조로,
	// 삽입/삭제가 O(log N)이라 훨씬 효율적임



	// 1번째 문제 풀이
	import java.util.*;
	class Solution {
		public int solution(int[] scoville, int K) {
			int answer = 0;
			List<Integer> arr = new ArrayList<>();
			for (int s : scoville) {
				arr.add(s);
			}

			while (arr.size() >= 2) {
				Collections.sort(arr);
				if (arr.get(0) >= K) break;

				int first = arr.get(0);
				int second = arr.get(1);
				int mixed = first + second * 2;

				arr.remove(1);
				arr.remove(0);
				arr.add(mixed);

				answer++;
			}

			Collections.sort(arr);
			return arr.get(0) >= K ? answer : -1;
		}
	}

	// 2번째 문제풀이 (정답)
	import java.util.*;
	class Solution {
		public int solution(int[] scoville, int K) {
			int answer = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i : scoville){
				pq.offer(i);
			}

			// 계산할 수 있게 pq.size() >= 2여야함
			// 가장 작은 값이 조건보다 작을때만 계산
			while(pq.size()>=2 && pq.peek() < K ){
				int mix = pq.poll() + pq.poll() * 2;
				pq.offer(mix);
				answer++;
			}
			if(pq.peek() < K) answer = -1;

			return answer;
		}
	}

}
