package week2.김상진.programmers;

import java.util.Stack;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 올바른_괄호
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 올바른_괄호 {
	class Solution {
		boolean solution(String s) {
			boolean answer = true;
			Stack<Character> stack = new Stack<>();
			for(char c : s.toCharArray()){
				if(c=='(')stack.push(c);
				else{
					if(stack.isEmpty())return false;
					stack.pop();
				}
			}
			if(!stack.isEmpty())return false;
			return answer;
		}
	}
}
