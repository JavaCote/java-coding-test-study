/**
 * PackageName : week12.이상억.progarmmers;
 * FileName    : 다리를_지나는_트럭
 * Author      : sangeok
 * Date        : 2025. 07. 15.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 15.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> qe = new LinkedList<>(); // 다리
        int time = 0; // 시간
        int idx = 0;
        int current_weight = 0;

        // 다리 위를 초기화 (빈 공간)
        for (int i = 0; i < bridge_length; i++) {
            qe.offer(0);
        }

        while (!qe.isEmpty()) {
            time++;
            int out = qe.poll();
            current_weight -= out;

            // 트럭이 남아있고, 무게 조건도 만족하면 트럭을 올림
            if (idx < truck_weights.length) {
                if (current_weight + truck_weights[idx] <= weight) {
                    qe.offer(truck_weights[idx]);
                    current_weight += truck_weights[idx];
                    idx++;
                } else {
                    qe.offer(0);  // 아무 트럭도 못 올라오면 빈칸 추가
                }
            }
        }

        return time;
    }
}
