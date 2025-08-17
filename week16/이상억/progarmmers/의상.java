/**
 * PackageName : week16.이상억.progarmmers;
 * FileName    : 의상
 * Author      : sangeok
 * Date        : 2025. 08. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 12.     sangeok               Initial creation
 */


// 고등학교 때 했던 확률과 통계 조합 문제 같음

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeCount = new HashMap<>();

        for (String[] item : clothes) {
            String type = item[1];
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        // 각 종류마다 (입는 개수 + 안 입는 경우 = +1)
        int answer = 1;
        for (int count : typeCount.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
