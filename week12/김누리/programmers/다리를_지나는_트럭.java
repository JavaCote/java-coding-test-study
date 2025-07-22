package week12.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week12.김누리.programmers
 * FileName    : 다리를_지나는_트럭
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-13
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 13.     김누리(NRKim)               Initial creation
 */

/*
다리 위에는 2개의 트럭만 적재 가능...

그리고 다리에 올라온 순번대로 골라인으로 가야한다..

그러면 다리의 타입은 Queue로 진행.

결과적으로 시나리오는

1.  대기트럭의 맨 앞에 있는 트럭[0]을 다리 위로 이동
  다리 위 트럭 [0]
2.  다리 위에 있는 트럭[0] + 다음 순번의 대기트럭[1] <= weight?
    다리 위로 이동, 아닌 경우 선두 트럭 골라인으로
  다리 위 트럭 [0,1]
3.  선두 트럭 골라인 이동
  다리 위 트럭 [1]
4.  다리 위에 있는 트럭[1] + 다음 트럭[2] <= weight?
    다리 위로 이동, 아닌 경우 선두 트럭 골라인으로
위 과정들 반복


아이디어는 떠올랐지만? 풀이 과정에서 조금 애를 먹음.
AI의 도움을 받았기에 다시 풀어봐야되는 문제.

*/

public class 다리를_지나는_트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		// 다리 큐와 대기 트럭 큐
		Queue<Integer> bridge = new LinkedList<>();
		Queue<Integer> trucks = new LinkedList<>();

		// 초기 대기 트럭 넣기
		for (int t : truck_weights) trucks.offer(t);

		int time = 0; //  진행 시간
		int bridge_weight = 0;  //  현재 다리에 올라간 트럭의 중령

		// 다리 길이만큼 0으로 초기화 (빈칸)
		for (int i = 0; i < bridge_length; i++) {
			bridge.offer(0);
		}

		// 트럭이 모두 다리를 건널 때까지 시뮬레이션
		while (!bridge.isEmpty()) {
			time++;

			// 무조건 1칸 전진
			int out = bridge.poll();
			bridge_weight -= out;

			// 다음 트럭을 올릴 수 있으면 올리기
			if (!trucks.isEmpty()) {
				int next = trucks.peek();
				if (bridge_weight + next <= weight) {
					bridge.offer(trucks.poll());
					bridge_weight += next;
				} else {
					bridge.offer(0); // 빈칸 유지
				}
			}
		}

		return time;
	}
}
