package week3.이상억.progarmmers;

/**
 * PackageName : week3.이상억.progarmmers;
 * FileName    : 프로세스
 * Author      : sangeok
 * Date        : 2025. 5. 15.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 15.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});  // 인덱스, 우선순위
            pq.add(priorities[i]);
        }

        while(!pq.isEmpty()){
            int[] current = queue.poll();

            // 가장 큰 우선 순위면 꺼냄
            if(current[1] == pq.peek()){
                pq.poll();
                answer ++;
                if(current[0] == location) break;
            } else queue.add(current);

        }
        return answer;
    }
}