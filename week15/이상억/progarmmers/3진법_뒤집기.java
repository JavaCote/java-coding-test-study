/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : 3진법_뒤집기
 * Author      : sangeok
 * Date        : 2025. 08. 06.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 06.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        while( n > 0 ) {
            list.add(n%3);
            n = n/3;
        }

        for(int i = 0; i < list.size(); i++){
            list.get(i);
            answer += list.get(i) * Math.pow(3, list.size() - i - 1);
        }

        return answer;

    }
}