package week11.김상진.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보_수집_유효기간 {
    import java.util.*;

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            // 파기해야 할 개인정보의 번호(1-based index)를 저장할 리스트
            List<Integer> answer = new ArrayList<>();

            // 오늘 날짜를 총 일수 형태로 변환
            int todayInDays = dateToDays(today);

            // 약관 종류별 유효기간을 저장할 Map (예: "A" -> 6개월)
            Map<String, Integer> termDurations = new HashMap<>();
            for (String term : terms) {
                String[] parts = term.split(" ");
                termDurations.put(parts[0], Integer.parseInt(parts[1]));
            }

            // 각 개인정보(privacies)를 순회하며 파기 대상인지 확인
            for (int i = 0; i < privacies.length; i++) {
                String privacy = privacies[i];
                String[] parts = privacy.split(" ");
                String collectedDateStr = parts[0]; // 수집 일자
                String termType = parts[1];         // 약관 종류

                // 개인정보 수집 일자를 총 일수 형태로 변환
                int collectedDateInDays = dateToDays(collectedDateStr);

                // 해당 약관의 유효기간
                int durationInMonths = termDurations.get(termType);

                // 파기 예정일 계산: 수집일자(총 일수) + 유효기간(개월 * 28일)
                int expirationDateInDays = collectedDateInDays + (durationInMonths * 28);

                // 파기 여부 판단: 파기 예정일이 오늘 날짜보다 '이전'이거나 '같으면' 파기 대상
                if (expirationDateInDays <= todayInDays) {
                    // 파기 대상인 경우, 해당 개인정보의 번호(1-based)를 결과 리스트에 추가
                    answer.add(i + 1);
                }
            }

            // List<Integer>를 int[] 배열로 변환하여 반환
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
        // 날짜 문자열(YYYY.MM.DD)을 총 일수로 변환하는 헬퍼 함수
        // 모든 달은 28일까지 있다고 가정하여 계산합니다.
        private int dateToDays(String dateStr) {
            String[] parts = dateStr.split("\\.");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            return (year * 12 * 28) + (month * 28) + day;
        }
    }

}
