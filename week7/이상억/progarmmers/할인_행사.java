/**
 * PackageName : week7.이상억.progarmmers;
 * FileName    : 할인_행사
 * Author      : sangeok
 * Date        : 2025. 6. 11.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 11.     sangeok               Initial creation
 */

// 문제 요구사항 :	마트는 일정 금액 지불 시 10일 동안 회원 자격 부여
//        회원을 대상으로 매일 한가지 제품을 할인
//        제품은 하루에 하나씩 구매
//        자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰 회원가입
//        원하는 제품 바나나 3개 , 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개
//        치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나
//        셋째, 넷째 다섯째 날 가입하려함

//        1 <= want <= 10 /  10 <= discount <= 100,000

//        접근 방식 :		(1) 우선적으로 want와 number를 map 으로 등록
//        discount 배열을 한칸씩 뒤로 밀면서 비교하면 ?

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = 0; j < 10; j++) {
                String item = discount[i + j];
                discountMap.put(item, discountMap.getOrDefault(item, 0) + 1);
            }

            if (same(wantMap, discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean same(Map<String, Integer> a, Map<String, Integer> b) {
        for (String key : a.keySet()) {
            if (!b.containsKey(key) || !a.get(key).equals(b.get(key))) {
                return false;
            }
        }
        return true;
    }
}
