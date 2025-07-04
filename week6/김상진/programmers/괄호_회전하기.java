package week6.김상진.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 괄호_회전하기
 * Author      : sangxxjin
 * Date        : 2025. 5. 31.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 31.     sangxxjin               Initial creation
 */
public class 괄호_회전하기 {
	// https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html?utm_source=chatgpt.com
	// 덱을 스택처럼 사용할때 자바 관행상 앞에서 넣고 빼는게 관례임.
	// 뒤에서 작업을 해도 효율성은 똑같음.

	// 짝을 찾는 문제는 기본적으로 스택을 사용하는게 바로 떠오름.
	import java.util.*;

	class Solution {
		public int solution(String s) {
			int answer = 0;
			int len = s.length();
			for (int i = 0; i < len; i++) {
				String rotated = s.substring(i) + s.substring(0, i);
				if (isCorrect(rotated)) answer++;
			}
			return answer;
		}

		private boolean isCorrect(String s) {
			Deque<Character> stack = new ArrayDeque<>();
			for (int i = 0; i < s.length(); i++) {
				char cur = s.charAt(i);
				if (isOpen(cur)) {
					stack.push(cur);
				} else {
					if (stack.isEmpty()) return false;
					if (!isSet(stack.peek(), cur)) return false;
					stack.pop();
				}
			}
			return stack.isEmpty();
		}

		private boolean isOpen(char c){
			return c == '(' || c == '{' || c == '[';
		}

		private boolean isSet(char a, char b){
			return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
		}
	}

}
