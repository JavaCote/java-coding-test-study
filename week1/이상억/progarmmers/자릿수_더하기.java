package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 자릿수_더하기
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */
class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i<=n ;i++){
            answer += (n % i == 0) ? i : 0;
        }
        return answer;
    }
}