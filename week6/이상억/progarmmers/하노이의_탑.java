/**
 * PackageName : week6.이상억.progarmmers;
 * FileName    : 하노이의 탑
 * Author      : sangeok
 * Date        : 2025. 6. 3.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 3.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        hanoi(n, 1, 3, 2, list);

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    // 하노이 재귀 함수 (one: 첫번째, three: 3번째, two: 2번째)
    public void hanoi(int n, int one, int three, int two, List<int[]> list) {
        if (n == 1) {
            list.add(new int[]{one, three});
            return;
        }

        hanoi(n - 1, one, two, three, list);      // 위 n-1개를 2번째 기둥으로
        list.add(new int[]{one, three});         // 가장 큰 원판 이동
        hanoi(n - 1, two, three, one, list);     // 2번째 기둥 → 3번째 기둥
    }
}
