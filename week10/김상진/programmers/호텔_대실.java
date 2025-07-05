package week10.김상진.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔_대실 {
    import java.util.*;

    class Solution {
        public int solution(String[][] book_time) {
            // 시각을 분 단위로 변환 + 청소 시간 반영
            int[][] times = new int[book_time.length][2];
            for (int i = 0; i < book_time.length; i++) {
                times[i][0] = toMinutes(book_time[i][0]);
                times[i][1] = toMinutes(book_time[i][1]) + 10;
            }

            // 시작 시각 기준으로 정렬
            Arrays.sort(times, (a, b) -> a[0] - b[0]);

            // 현재 객실 퇴실 시간 + 청소 시간을 저장하는 PQ
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int[] time : times) {
                // 기존 객실 중 사용할 수 있는 객실이 있는지 확인
                if (!pq.isEmpty() && pq.peek() <= time[0]) {
                    pq.poll(); // 해당 객실 재사용
                }
                pq.offer(time[1]); // 현재 예약 퇴실+청소 시간 추가
            }

            return pq.size();
        }

        private int toMinutes(String time) {
            String[] parts = time.split(":");
            return Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]);
        }
    }


}
