/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 귤_고르기
 * Author      : sangeok
 * Date        : 2025. 5. 23.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 23.     sangeok               Initial creation
 */


//문제 요구사항 : 	문제 요구사항 :	귤이 8개 [ 1, 3, 2, 5, 4, 5, 2, 3] => [1, 2, 2, 3, 3, 4, 5, 5]
//			크기가 다른 귤을 최소화 하고 싶음 / 한 상자에 담는 귤의 갯수 : k , 귤 크기 배열 : tangerine
//			크기가 서로 다른 최솟값 : result
//
//
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
