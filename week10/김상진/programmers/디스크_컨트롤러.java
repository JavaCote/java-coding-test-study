package week10.김상진.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    import java.util.*;

    class Solution {
        public int solution(int[][] jobs) {
            //요청 시각 순서로 정렬
            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
            // 우선순위 큐에 작업 종료 시각 기준으로 정렬
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            int time = 0;
            int index = 0;
            int total = 0;
            int count = 0;

            while (count < jobs.length) {
                while (index < jobs.length && jobs[index][0] <= time) {
                    pq.offer(jobs[index]);
                    index++;
                }

                if (!pq.isEmpty()) {
                    int[] job = pq.poll();
                    time += job[1];
                    total += time - job[0];
                    count++;
                } else {
                    time = jobs[index][0];
                }
            }

            return total / jobs.length;
        }
    }

}
