package week7.김나은.programmers;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {

    class Solution {

        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0; // 조건을 만족하는 경우의 수
            int days = 10;  // 할인 기간은 연속 10일

            // 원하는 상품과 수량을 저장할 Map 생성
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < want.length; i++) {
                map.put(want[i], number[i]); // 예: {"apple": 3, "banana": 2, ...}
            }

            // discount 배열을 10일 단위로 잘라가며 검사
            for (int i = 0; i < discount.length - days + 1; i++) {
                Map<String, Integer> dMap = new HashMap<>(); // 10일간의 할인 품목 수량을 저장할 Map

                // 현재 i일부터 10일간의 할인 품목 수량 계산
                for (int j = 0; j < days; j++) {
                    String item = discount[i + j];
                    dMap.put(item, dMap.getOrDefault(item, 0) + 1);
                }

                // 원하는 상품과 현재 할인 품목이 일치하는지 확인
                boolean isIdentical = true;
                for (String key : map.keySet()) {
                    if (map.get(key) != dMap.get(key)) { // 수량이 다르면 실패
                        isIdentical = false;
                        break;
                    }
                }

                // 조건 만족 시 answer 증가
                answer += isIdentical ? 1 : 0;
            }

            return answer;
        }
    }
}
