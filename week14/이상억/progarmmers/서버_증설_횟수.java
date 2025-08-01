/**
 * PackageName : week14.이상억.progarmmers;
 * FileName    : 서버_증설_횟수
 * Author      : sangeok
 * Date        : 2025. 07. 30.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 30.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {

        // 만료 시간이 가장 빠른 순으로 서버 정보를 저장하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        int size = 0;   // 현재 사용 가능한(만료되지 않은) 서버의 수
        int count = 0;  // 전체 서버 증설 횟수 누적

        for (int i = 0; i < 24; i++) {

            while (!pq.isEmpty() && pq.peek()[0] == i) {
                size -= pq.poll()[1];
            }
            int need = players[i] / m;
            int more = size - need;

            if (more < 0) {
                more = -more;     // 부족한 서버 수만큼 양수로 변환
                size += more;
                count += more;
                pq.add(new int[]{i + k, more}); // 새로 증설된 서버는 i + k 시간에 만료됨
            }
        }

        return count;
    }
}
