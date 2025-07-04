package week3.김상진.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * PackageName : week3.김상진.programmers
 * FileName    : 프로세스
 * Author      : sangxxjin
 * Date        : 2025. 5. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 16.     sangxxjin               Initial creation
 */
public class 프로세스 {
	// 처음 문제를 봤을때 큐를 사용하는 문제인걸 파악 그런데 1~3 조건대로 한다?
	// 현재 index의 값보다 더 높은 값이 뒤에 있는지 어떻게 확인할까?(반복문으로 모든 값 비교? = 비효율)
	// 그러면 priorities 배열 자체에서 가장 큰값을 찾고 그 앞에 값들을 배열의 뒤쪽으로 옮긴다?
	// ex) 2 1 3 2 -> 가장큰 3을 찾고 앞의 2 1을 그대로 뒤로 이동 3 2 2 1 그러면 내가 처음 찾고자 했던 location의 위치를 또 기록해야함
	// 우선순위 큐를 사용하면 쉽게 해결 가능
	import java.util.*;
	class Solution {
		public int solution(int[] priorities, int location) {
			int answer = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i : priorities){
				pq.offer(i);
			}
			while(!pq.isEmpty()){
				for(int i=0; i<priorities.length; i++){
					//현재 위치가 우선순위가 가장 높은 값이면 큐 제거 및 값 증가
					if(priorities[i]==pq.peek()){
						pq.poll();
						answer++;
						//원했던 location이랑 해당 위치가 같다면 리턴
						if(i==location)return answer;
					}
				}
			}
			return answer;
		}
	}

}
