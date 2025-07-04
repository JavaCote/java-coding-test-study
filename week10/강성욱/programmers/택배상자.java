package week10.강성욱.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 택배상자
 * Author      : Baekgwa
 * Date        : 2025-06-30
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-30     Baekgwa               Initial creation
 */
public class 택배상자 {
	// 일반 컨테이너는 들어오는 순서대로 실을 수 있고
	// 보조 컨테이너에 보관할때는 마지막에 넣은걸 빼서 쓸 수 잇음.
	// 즉 보조 컨테이너는 스택의 구조?
	// 아 order 대로 실어야 되구나.
	//-----
	// 중간에 보조 컨테이너에서 하나씩 꺼내서 2개이상 처리 가능한것도 생각해야됨.

	class Solution {
		public int solution(int[] order) {

			int result = 0;
			int nowOrderIndex = 0; //실어야하는 번호 확인용 index 변수;
			Deque<Integer> subContainer = new ArrayDeque<>(); //보조 컨테이너

			for(int now=1; now<= order.length; now++) {
				int nowTarget = order[nowOrderIndex];
				boolean flag = false; //실었는지 안실었는지, 만약 false 면 현재 now 값 보조 컨테이너에 넣어야됨.

				//현재 들어온 상자가 실을 수 있다면?
				if(nowTarget == now) {
					result++;
					nowOrderIndex++;
					flag = true;
				}

				// 만약 서브 컨테이너에 마지막에 넣은게 실을 수 있다면?
				// 반복해야됨
				while (!subContainer.isEmpty() && order[nowOrderIndex] == subContainer.peekFirst()) {
					subContainer.removeFirst();
					result++;
					nowOrderIndex++;
				}

				// 넣을 수 없음.
				if(!flag) subContainer.addFirst(now);
			}

			while (!subContainer.isEmpty() && order[nowOrderIndex] == subContainer.peekFirst()) {
				subContainer.removeFirst();
				result++;
				nowOrderIndex++;
			}

			return result;
		}
	}
}
