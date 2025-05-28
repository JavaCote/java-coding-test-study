package week5.김나은.programmers;

import java.util.PriorityQueue;

public class 더_맵게 {

    class Solution {

        public int solution(int[] scoville, int K) {
            int answer = 0; // 음식을 섞은 횟수

            // 우선순위 큐(최소 힙) 선언: 가장 맵지 않은 음식부터 꺼낼 수 있음
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            // 모든 스코빌 지수를 우선순위 큐에 넣기
            for (int a : scoville) {
                pq.add(a);
            }

            // 현재 가장 맵지 않은 음식의 스코빌 지수 확인
            int min = pq.peek();

            // 가장 작은 스코빌 지수가 목표치(K)보다 작을 동안 반복
            while (min < K) {

                // 2개 이상이 있어야 섞을 수 있음
                if (pq.size() >= 2) {
                    // 가장 맵지 않은 두 개 꺼내서 새 음식 만들기
                    int first = pq.poll();         // 가장 작은 스코빌
                    int second = pq.poll();        // 두 번째로 작은 스코빌
                    int mixed = first + (second * 2); // 섞은 후 스코빌

                    pq.add(mixed); // 새로 만든 음식 다시 큐에 넣기
                    min = pq.peek(); // 다음 최소 스코빌 값 확인
                    answer++; // 섞은 횟수 증가
                } else {
                    // 섞을 수 있는 음식이 2개 미만이면 실패 → -1 반환
                    return -1;
                }
            }

            // 모든 음식이 스코빌 K 이상이면 섞은 횟수 반환
            return answer;
        }
    }
}
