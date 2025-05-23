/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 더_맵게
 * Author      : sangeok
 * Date        : 2025. 5. 23.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 23.     sangeok               Initial creation
 */

// 문제 요구사항 : 	스코빌 지수를 k 이상으로 만들고 싶음
//        섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//        스코빌 지수가 가장 낮은 두 음식을 아래와 같은 방법으로

//        접근 방식 : (1) 우선순위 큐 사용해서 반복문

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            int mixed = a + 2 * b;
            pq.add(mixed);
            answer++;
        }

        if (pq.peek() < K) return -1;

        return answer;
    }
}
