package week2.김누리.programmers;

import java.util.Stack;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 햄버거_만들기
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 05.     김누리               Stack 이용해서 문제 풀이
 */
public class 햄버거_만들기 {
	public int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> stk = new Stack<>();

		for(int i : ingredient) {
			stk.push(i); // 햄버거 재료 입력

			//  쌓아올린 재료가 4개 이상일 때 판정 시작 (빵(아래) > 야채 > 고기 > 빵(위))
			if (stk.size() >= 4) {
				int a = stk.get(stk.size()-4);  //  idx 0
				int b = stk.get(stk.size()-3);  //  idx 1
				int c = stk.get(stk.size()-2);  //  idx 2
				int d = stk.get(stk.size()-1);  //  idx 3

				//  (빵(아래) > 야채 > 고기 > 빵(위)) 순번대로 쌓였는지 확인
				if(
					a == 1 &&
						b == 2 &&
						c == 3 &&
						d == 1
				) {
					//  사용한 재료들 예외 처리
					for (int j = 0; j < 4; j++) {
						stk.pop();
					}

					answer++;
				}
			}
		}

		return answer;
	}
}
