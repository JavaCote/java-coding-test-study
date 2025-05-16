package week3.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week3.김누리.programmers
 * FileName    : 프로세스
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-14
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 14.     김누리(NRKim)               Initial creation
 */

/*
case 1 :
priorities [2,1,3,2], 위치 2가 입력
숫자가 클 수록 우선순위도 높음
위치가 2 idx = 2
그럼 priorities[2]인 값이 언제 실행되냐?

프로세스 실행은 아래와 같이 진행
큐에서 프로세스를 poll >>  현재 poll 한 프로세스가 가장 우선순위가 큰가? >> 해당 프로세스 offer() 안함 : 해당 프로세스 offer()

진행
2,1,3,2 ==> poll() == 2, max치 아님 ==> 다시 offer() ==> 1,3,2,2
1,3,2,2 ==> poll() == 1, max치 아님 ==> 다시 offer() ==> 3,2,2,1
1,3,2,2 ==> poll() == 3, max치 ==> 다시 offer() 하지 않음 ==> 3,2,2,1

순번적으로 poll 하면서 answer++, 이 때 초창기에 priorities[2]인 3과 현재 다시 poll 한 값이 일치하면 answer값 리턴.

case 2 :
priorities [1,1,9,1,1,1], 위치 0가 입력
위치가 0 idx = 0
그럼 priorities[0]인 값이 언제 실행되냐?

프로세스 실행은 아래와 같이 진행
큐에서 프로세스를 poll >>  현재 poll 한 프로세스가 가장 우선순위가 큰가? >> 해당 프로세스 offer() 안함 : 해당 프로세스 offer()

진행
1,1,9,1,1,1 ==> poll() == 1, max치 아님 ==> 다시 offer() ==> 1,9,1,1,1,1
1,9,1,1,1,1 ==> poll() == 1, max치 아님 ==> 다시 offer() ==> 9,1,1,1,1,1
9,1,1,1,1,1 ==> poll() == 9, max치 ==> 다시 offer() 하지 않음 ==> 9,1,1,1,1,1

순번적으로 poll 하면서 answer++, 이 때 초창기에 priorities[0]인 1과 현재 다시 poll 한 값이 일치하면 answer값 리턴.
*/

public class 프로세스 {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		int target = priorities[location];
		Queue<int[]> prior = new LinkedList<>(); //  단지 Queue<Integer>로만 하면 idx 값을 놓칠 수 있음

		for(int i = 0 ; i < priorities.length; i++) {
			prior.offer(new int[] {i,priorities[i]});
		}

		while(!prior.isEmpty()) {
			int[] tmp = prior.poll(); // [0,2]
			boolean max = false; // 지금 tmp에 있는 값의 우선순위가 가장 높나?

			for(int[] i : prior) {
				//  Queue에 남아있는 우선순위 판정
				if (i[1] > tmp[1]) { // [0,2] : [1,1],[2,3],[3,2] >> [0,1] : [1,3],[2,2],[3,2] >> [0,3] : [1,2],[2,2],[3,1]
					max = true; // [0,3] 일 때 max
					break;
				}
			}

			if(max) {
				// 현재 tmp[1] 값이 max치가 아니므로 다시 큐에 offer()
				prior.offer(tmp);
			} else {
				answer++;

				if(tmp[0] == location) {
					return answer;
				}
			}
		}

		//  실제 여기로 올 확률은 0%, 그러나 없으면 에러가 나기 때문에 남겨둔 return
		return answer;
	}
}
