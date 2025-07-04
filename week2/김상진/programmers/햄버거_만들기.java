package week2.김상진.programmers;

import java.util.Stack;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 햄버거_만들기
 * Author      : sangxxjin
 * Date        : 2025. 5. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 7.     sangxxjin               Initial creation
 */
public class 햄버거_만들기 {
	//다른사람 문제 풀이 확인 결과 배열이 더 좋은듯
	class Solution {
		public int solution(int[] ingredient) {
			int answer = 0;
			Stack<Integer> stack = new Stack<>();
			for(int i : ingredient){
				stack.push(i);
				if(i==1&&stack.size()>=4){
					int size = stack.size();
					if (stack.get(size - 4) == 1 &&
						stack.get(size - 3) == 2 &&
						stack.get(size - 2) == 3 &&
						stack.get(size - 1) == 1) {
						answer++;
						for(int j=0; j<4; j++){
							stack.pop();
						}

					}
				}
			}
			return answer;
		}
	}
}
