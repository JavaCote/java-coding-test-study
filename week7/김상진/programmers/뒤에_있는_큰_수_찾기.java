package week7.김상진.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 뒤에_있는_큰_수_찾기
 * Author      : sangxxjin
 * Date        : 2025. 6. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 7.     sangxxjin               Initial creation
 */
public class 뒤에_있는_큰_수_찾기 {
	// 1차 풀이는 시간초과 발생
	// numbers의 길이는 최대 1,000,000
	// 이중 for문을 사용하면 최악의 경우 O(N^2) = 1,000,000^2 = 10^12 연산 발생
	// Java 기준 1억(10^8) 이상의 연산으로, 시간 초과가 발생함
	class Solution {
		public int[] solution(int[] numbers) {
			int[] answer = new int[numbers.length];
			for(int i=0; i<numbers.length; i++){
				for(int j=i+1; j<numbers.length; j++){
					if(numbers[i]<numbers[j]){
						answer[i]=numbers[j];
						break;
					}
				}
				if(answer[i]==0)answer[i]=-1;
			}
			return answer;
		}
	}
	// 덱을 스택처럼 사용하여 인덱스를 저장하며 다음 큰 수 탐색
	import java.util.*;
	class Solution {
		public int[] solution(int[] numbers) {
			int[] answer = new int[numbers.length];
			Deque<Integer> deq = new ArrayDeque<>();

			deq.offerFirst(0);
			for (int i = 1; i < numbers.length; i++) {
				// 현재 값이 스택에 저장된 인덱스의 값보다 크면,
				// 정답을 갱신하고 해당 인덱스를 스택에서 제거
				while (!deq.isEmpty() && numbers[deq.peek()] < numbers[i]) {
					answer[deq.poll()] = numbers[i];
				}
				deq.offerFirst(i);
			}

			// 스택에 남아 있는 인덱스는 뒤에 더 큰 수가 없으므로 -1로 처리
			while (!deq.isEmpty()) {
				answer[deq.poll()] = -1;
			}

			return answer;
		}
	}

}
