package week7_a.김상진.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week7_a.김상진.programmers
 * FileName    : 주식가격
 * Author      : sangxxjin
 * Date        : 2025. 6. 13.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 13.     sangxxjin               Initial creation
 */
public class 주식가격 {
	import java.util.*;
	class Solution {
		// prices의 인덱스를 스택에 담아서 값 비교 하고 index 자리에 값 넣기
		// 바로 떨어져도 1 즉, idx-currentIdx
		// 마지막은 항상 0
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];
			Deque<Integer> deq = new ArrayDeque<>();
			for(int i=0; i<prices.length; i++){
				while(!deq.isEmpty() && prices[deq.peekFirst()]>prices[i]){
					int idx = deq.pollFirst();
					answer[idx]=i-idx;
				}
				deq.offerFirst(i);
			}
			//끝까지 안떨어진 가격
			while(!deq.isEmpty()){
				int idx = deq.pollFirst();
				answer[idx]=prices.length-1-idx;
			}
			return answer;
		}
	}
}
