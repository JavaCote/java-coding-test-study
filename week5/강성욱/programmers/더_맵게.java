package week5.강성욱.programmers;

import java.util.*;

public class 더_맵게 {
    // 문제는, 목표치를 정확하게 맞추는게 목표가 아님.
    // 일정 (K) 보다 더 높은 스코빌 지수만 가지는 음식을 만들어 내는것
    // 일딴, 기준보다 높은 스코빌은 떼놓아도 됨.
    // 만약, 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없다면 -1 return
        // 이건, 가지고 있는 음식이 1개 이하인데, K 에 도달하지 못했다면 return 하면 될듯.

    //아, 어렵게 생각하면 안되네, 조합을 생각하는게 아니라, 문제에 가장 작은것과 2번째 작은걸 조합하라는거네?
    //우선순위큐를 쓰자.

    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(); //기본 오름차순
            for(int sco : scoville) {
                pq.add(sco);
            }

            //반복의 조건은 음식의 가장 낮은 스코빌 지수가, K 이상일 것
            int mixCount = 0;
            while(pq.peek() < K) {
                if(pq.size() <= 1) return -1;

                int first = pq.poll();
                int second = pq.poll();

                int next = first + (second * 2);
                pq.add(next);
                mixCount++;
            }

            return mixCount;
        }
    }
}
