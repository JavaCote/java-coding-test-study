/**
 * PackageName : week7.이상억.progarmmers;
 * FileName    : 뒤에_있는_큰_수_찾기
 * Author      : sangeok
 * Date        : 2025. 6. 11.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 11.     sangeok               Initial creation
 */
// 문제 요구사항 :	배열의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수
//			뒷 큰수가 존재하지 않는 원소는 -1
//
// 접근 방식	: for문 안에 stack 사용하면서 비교하면 될 거 같다.

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = len-1; i >= 0; i--){
            int current = numbers[i];
            while(!stack.isEmpty() && stack.peek() <= current){
                stack.pop();
            }

            if(stack.isEmpty()){
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
            stack.push(current); // 우선 후보로 사용하기 위해 stack 에 박고 봄
        }
        return answer;
    }
}