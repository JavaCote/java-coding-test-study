package week2.이상억.progarmmers;

/**
 * PackageName : week2.이상억.programmers
 * FileName    : 햄버거_만들기
 * Author      : sangeok
 * Date        : 2025. 5. 7.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 7.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i : ingredient) {
            stack.push(i);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size-4) == 1 &&
                        stack.get(size-3) == 2 &&
                        stack.get(size-2) == 3 &&
                        stack.get(size-1) == 1) {

                    for (int j = 0; j < 4; j++) stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }
}
