package week5.김나은.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤_고르기 {

    class Solution {

        public int solution(int k, int[] tangerine) {
            int count = 0;
            int num = 0;

            // 귤의 크기별 개수를 저장할 맵 선언
            Map<Integer, Integer> map = new HashMap<>();
            for (int tan : tangerine) {
                // 이미 있으면 +1, 없으면 0에서 시작
                map.put(tan, map.getOrDefault(tan, 0) + 1);
            }

            // 귤의 크기별 개수만 리스트로 변환
            List<Integer> list = new ArrayList<>(map.values());
            // 많이 있는 종류부터 뽑기 위해 내림차순 정렬
            Collections.sort(list, Collections.reverseOrder());

            // 개수가 많은 귤 종류부터 차례로 더해가며 k개 이상 채우는 최소 종류 수 찾기
            for (int val : list) {
                if (num + val >= k) { // 현재까지 누적한 개수 + 현재 종류 개수가 k 이상이면
                    count++; // 이 종류까지 포함하면 됨
                    break;
                } else {
                    num += val; // 아직 부족하면 누적하고
                    count++; // 종류 수 추가
                }
            }

            return count; // k개 이상을 만들기 위한 최소 종류 수 반환
        }
    }
}
