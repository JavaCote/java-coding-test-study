package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : x만큼_간격이_있는_n개의_숫자
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 1; i<=n; i++){
            answer[i-1] = (long)x * i ;
        }
        return answer;
    }
}