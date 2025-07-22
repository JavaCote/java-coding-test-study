package week12.김상진.programmers;

import java.util.Deque;


public class 다리를_지나는_트럭 {
    import java.util.*;

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int time = 0;
            int currentBridgeWeight = 0;

            Deque<Integer> bridge = new ArrayDeque<>();
            Deque<Integer> waitingTrucks = new ArrayDeque<>();

            // 모든 트럭 무게를 대기 큐에 추가
            for (int truckWeight : truck_weights) {
                waitingTrucks.offer(truckWeight);
            }

            // 다리 시작은 모두 빈 칸(0)으로 채움
            for (int i = 0; i < bridge_length; i++) {
                bridge.offer(0);
            }

            // 모든 트럭이 다리를 건널 때까지 반복
            while (!bridge.isEmpty() || !waitingTrucks.isEmpty()) {
                time++;

                // 다리 맨 앞에 있는 요소를 제거 (트럭이 다리를 건너 완료했거나, 빈 칸이 이동함)
                int truckOut = bridge.poll();
                if (truckOut > 0) {
                    currentBridgeWeight -= truckOut;
                }
                if (!waitingTrucks.isEmpty()) {
                    int nextTruckWeight = waitingTrucks.peek();
                    // 현재 다리 무게 + 다음 트럭 무게가 다리가 견딜 수 있는 무게 이하
                    if (currentBridgeWeight + nextTruckWeight <= weight) {
                        bridge.offer(waitingTrucks.poll());
                        currentBridgeWeight += nextTruckWeight; // 다리 총 무게 업데이트
                    } else {
                        // 무게 제한 때문에 트럭이 진입할 수 없다면, 다리에 빈 칸(0)을 추가하여 시간 흐름을 유지
                        bridge.offer(0);
                    }
                }
            }

            return time;
        }
    }

}
