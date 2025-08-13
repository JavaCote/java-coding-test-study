package week16.김나은.programmers;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    class Solution {

        public int solution(String[][] clothes) {

            // 의상 종류별 개수를 저장할 Map
            Map<String, Integer> map = new HashMap<>();

            // clothes 배열 순회하면서 종류별 개수 세기
            for (String[] c : clothes) {
                // 이미 해당 종류가 있으면 +1, 없으면 0에서 시작해서 +1
                map.put(c[1], map.getOrDefault(c[1], 0) + 1);
            }

            // 조합 계산을 위한 초기값 (곱셈이니까 1로 시작)
            int answer = 1;

            for (int v : map.values()) {
                answer *= (v + 1); // 해당 아이템을 안입는 경우를 포함해야 하므로 + 1 해줌
            }

            return answer - 1; // 모든 아이템을 착용하지 않는 경우를 빼야하므로 - 1
        }
    }
}