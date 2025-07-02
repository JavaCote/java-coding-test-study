/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 택배상자
 * Author      : sangeok
 * Date        : 2025. 07. 02.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 02.     sangeok               Initial creation
 */


// 벨트에 놓인 순서대로 상자를 내릴 수 있음 ( 1번 )
// 택배 기사님이 알려준 순서에 맞게 실어야 함
// 벨트의 맨 앞에 놓인 상자가 현재 트럭에 실어야 하는 순서가 아니라면 잠시 다른 곳에 보관
// 보조 컨테이너 벨트는 앞뒤로 이동가능 하지만 맨 앞의 택배만 뺄 수 있음
// 보조 컨테이너 사용해도 더 이상 싣지 못한다면 싣지 않음

// 택배 기사님이 원하는 상자 순서 order 일 때 몇개의 상자를 실을 수 있는지
// 1번부터 ~ n 번까지

// 보조 컨테이너 설명을 볼 때 stack 써서 풀면 되겠구나 생각 함
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너

        int boxnumber = 1; // 컨테이너에서 오는 박스 번호
        int i = 0;

        while(boxnumber <= order.length){
            if(order[i] == boxnumber){
                i++;
                boxnumber ++;
            }else if (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                i++;
            } else{
                stack.push(boxnumber);
                boxnumber++;
            }
        }

        while(!stack.isEmpty() && stack.peek() == order[i]) {
            stack.pop();
            i++;
        }

        return i;
    }
}