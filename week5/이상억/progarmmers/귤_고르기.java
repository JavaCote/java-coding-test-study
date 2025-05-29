/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 예산
 * Author      : sangeok
 * Date        : 2025. 5. 23.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 23.     sangeok               Initial creation
 */


//문제 요구사항 : 	신청 금액 배열 d , 예산 budget 일 때 최대 몇개 부서에 물품을 지원 할 수 있는지

// 접근 방식 : 	정렬 후 작은 수 부터 빼기
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        if (k <= 0) return 0;

        int max = 0;
        for (int t : tangerine) {
            max = Math.max(max, t);
        }

        int[] count = new int[max + 1];

        for (int i : tangerine) {
            count[i]++;
        }

        Arrays.sort(count);

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 0) break;
            if (k <= 0) break;

            k -= count[i];
            answer++;
        }

        return answer;
    }
}
