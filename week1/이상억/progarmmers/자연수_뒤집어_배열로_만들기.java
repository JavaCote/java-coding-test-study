package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 자연수_뒤접어_배열로_만들기
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
