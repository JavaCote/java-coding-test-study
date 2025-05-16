package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 짝지어_제거하기
 * Author      : sangeok
 * Date        : 2025. 5. 16.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 16.     sangeok               Initial creation
 */


// 문제 요구사항 : 같은 알파벳이 2개 붙어 있는 짝을 찾음 -> 그 다음 그 둘을 제거 -> 앞 뒤로 다시 이어 붙임
//        -> 다 제거하는 함수 작성하기

//  접근 방법 : (1) list 로 선언해서 했지만 효율성에서 시간 초과 리스트를 삭제하는데 있어서 시간 복잡도가 초과 됨
//             (2) stack / LinkedList 등 다른 자료구조 사용

// 회고 :
import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char alphabet : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == alphabet) {
                stack.pop();
            } else {
                stack.push(alphabet);
            }
        }

        return stack.isEmpty() ? 1:0 ;
    }
}