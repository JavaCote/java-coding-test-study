/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : H_Index
 * Author      : sangeok
 * Date        : 2025. 6. 27.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 27.     sangeok               Initial creation
 */

// 문제 요구사항 :    논문 n 편중 h 번 이상 인용된 논문이 h 편 이상이고 나머지 논문이 h 번 이하 인용 되었다면
//                  h 의 최댓 값이 h-index

// 회고 : 단순히 정렬 후 가운데 값 뽑으면 되는 줄 알았다. 문제를 이해하는데 있어서 테스트 케이스가 좀 불친절했던 것 같다.
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int len = citations.length;

        for(int i = 0; i < len; i++){
            if( citations[i] >= len-i ) answer = answer > len-i ? answer : len-i ; // 인용 횟수와 h번 인용된 논문의 수 비교
        }

        return answer;
    }
}