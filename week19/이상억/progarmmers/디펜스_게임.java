/**
 * PackageName : week19.이상억.progarmmers;
 * FileName    : 디펜스_게임
 * Author      : sangeok
 * Date        : 2025. 09. 01.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 01.     sangeok               Initial creation
 */


// 매 라운드 마다 enemy[i] 마리 적 등장
//
// 4 2 4 5 3 3 1
// 0 1 2 3 4 5 6


import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;

        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            n -= e;
            pq.add(e); // 우선 막은 병사 큐에 담기

            if (n < 0) {
                if (k > 0) {
                    n += pq.poll(); // 지금까지 중 가장 큰 적 수를 무적권으로 막음
                    k--;
                } else {
                    return i;
                }
            }
        }

        return enemy.length;
    }
}
