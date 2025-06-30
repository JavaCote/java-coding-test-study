package week10.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 택배상자
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-30
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 30.     김누리(NRKim)               Initial creation
 */

/*
택배상자는 1 ~ n 까지

한방향으로 진행

1 2 3 4 5 박스가 있다 가정

기사양반 요청사항

4 3 1 2 5 순으로 요청


보조 컨테이너 (스택 )
2 1

메인 컨테이너

5

메인 컨테이너
4 3


그러면 메인 컨테이너는 Queue로 보조 컨테이너는 Stack으로 진행

order[i] == queue.peek()? 판정
no ? >> order[i] == stk.peek()? 판정

*/

public class 택배상자 {
	public int solution(int[] order) {
		int answer = 0;
		int len = order.length;//  총 택배 상자 갯수
		Stack<Integer> stk = new Stack<>(); //  보조 컨테이너
		Queue<Integer> que = new LinkedList<>(); // 메인 컨테이너

		//  메인 컨테이너에 적재
		for(int i = 1 ; i <= len; i++) {
			que.offer(i);
		}

		int idx = 0;

		//  보조 컨테이너 이동
		while ( idx < len ) {
			if(!que.isEmpty() && que.peek() == order[idx]) {
				//  메인컨테이너 맨 앞에 있는 상자 번호가 기사양반이 요청한 박스번호와 일치하는 경우
				answer++;
				que.poll();
				idx++;
			} else if (!stk.isEmpty() && stk.peek() == order[idx]) {
				//  메인컨테이너의 맨 앞 상자는 일치하지 않지만, 보조컨테이너 맨 앞에 있는 상자 번호가 기사양반이 요청한 박스번호와 일치하는 경우
				answer++;
				stk.pop();
				idx++;
			} else if (!que.isEmpty()) {
				//  메인컨테이너의 맨 앞, 보조컨테이너의 맨 앞에 있는 상자 번호 둘 다 불일치
				stk.push(que.poll());
			} else {
				break;
			}
		}

		return answer;
	}
}
