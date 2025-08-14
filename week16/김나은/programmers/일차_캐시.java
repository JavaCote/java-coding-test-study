package week16.김나은.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 일차_캐시 {

    class Solution {

        public int solution(int cacheSize, String[] cities) {
            // 총 실행 시간 저장 변수
            int answer = 0;

            // 캐시를 큐로 구현 (FIFO 구조 사용, 실제 LRU 동작은 remove & offer로 보완)
            Queue<String> cache = new LinkedList<>();

            // 입력받은 도시 cities 순회
            for (String s : cities) {
                s = s.toLowerCase(); // 대소문자 구분 없이 처리하기 위해 소문자로 변환

                if (cache.contains(s)) {
                    // 캐시에 해당 도시가 이미 존재 (cache hit) -> + 1
                    answer++;
                    cache.remove(s); // 기존 위치에서 제거
                    cache.offer(s); // 최근 사용으로 갱신 (맨 뒤로 이동)
                } else {
                    // 캐시에 해당 도시가 없음 (cache miss) -> + 5
                    answer += 5;
                    // 캐시가 꽉 차 있으면 가장 오래된 데이터 제거
                    if (cache.size() == cacheSize) {
                        cache.poll(); // 맨 앞(오래된 데이터) 제거
                    }
                    // 캐시 크기가 0이 아닐 경우만 새로운 도시 추가
                    if (cache.size() < cacheSize) {
                        cache.offer(s);
                    }
                }
            }

            return answer;
        }
    }
}