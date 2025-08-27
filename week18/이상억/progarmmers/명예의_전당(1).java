/**
 * PackageName : week18.이상억.progarmmers;
 * FileName    : 명예의_전당(1)
 * Author      : sangeok
 * Date        : 2025. 08. 27.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 27달.     sangeok               Initial creation
 */

// 상위 k 번째 이내이면 명예의 전당 기록
// k일 다음 부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k 번째 순위의 가수 점수보다 높으면 명예의 전당

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> list = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : score){
            pq.add(a);

            if(pq.size() > k) pq.poll();

            list.add(pq.peek());
        }

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}