package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 2xn_타일링
 * Author      : sangeok
 * Date        : 2025. 5. 22.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 22.     sangeok               Initial creation
 */

// 문제 요구사항 : 	신청 금액 배열 d , 예산 budget 일 때 최대 몇개 부서에 물품을 지원 할 수 있는지

//  접근 방식 : 	정렬 후 작은 수 부터 빼기

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int cost : d){
            if(cost <= budget) {
                budget -= cost ;
                answer ++;
            }
        }

        return answer;
    }
}
