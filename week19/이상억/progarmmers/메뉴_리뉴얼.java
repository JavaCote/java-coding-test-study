/**
 * PackageName : week19.이상억.progarmmers;
 * FileName    : 소수_만들기
 * Author      : sangeok
 * Date        : 2025. 09. 01.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 01.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    // 결과 담을 리스트

    List<String> answerList = new ArrayList<>();

    // 각 course 크기별 최대 등장 횟수 저장
    Map<Integer, Integer> maxCountMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        // 각 주문 문자열을 정렬해서 통일
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        for (int size : course) {
            Map<String, Integer> countMap = new HashMap<>();

            // 각 주문에서 조합 생성
            for (String order : orders) {
                if (order.length() >= size) {
                    makeCombination(order, "", 0, size, countMap);
                }
            }

            // 이번 course 크기에서 최대 등장 횟수 확인
            int maxCount = 0;
            for (int cnt : countMap.values()) {
                maxCount = Math.max(maxCount, cnt);
            }

            // 2번 이상 주문된 조합만 후보에 추가
            if (maxCount >= 2) {
                for (String menu : countMap.keySet()) {
                    if (countMap.get(menu) == maxCount) {
                        answerList.add(menu);
                    }
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    public void makeCombination(String order, String comb, int idx, int targetSize, Map<String, Integer> countMap) {
        if (comb.length() == targetSize) {
            countMap.put(comb, countMap.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            makeCombination(order, comb + order.charAt(i), i + 1, targetSize, countMap);
        }
    }
}
